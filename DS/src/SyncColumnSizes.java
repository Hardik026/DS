import java.sql.*;

public class SyncColumnSizes {

    private static final String DEV_DRIVER = "oracle.jdbc.driver.OracleDriver"; 
    private static final String PROD_DRIVER = "oracle.jdbc.driver.OracleDriver"; 
    private static final String DEV_URL = "jdbc:oracle:thin:@epstestdb.ncratleos.com:1527/EPS_ESDEV"; 
    private static final String PROD_URL = "jdbc:oracle:thin:@epsdb.ncratleos.com:1527/EPSESP"; 
    private static final String DEV_USERNAME = "KWAPP";
    private static final String PROD_USERNAME = "KWAPP";
    private static final String DEV_PASSWORD = "Login2PredictiveDev#2024ESEPSD";
    private static final String PROD_PASSWORD = "Login2Predictive#2022EPSESFTKS";

    public static void main(String[] args) {

        try (Connection devConn = DriverManager.getConnection(DEV_URL, DEV_USERNAME, DEV_PASSWORD);
             Connection prodConn = DriverManager.getConnection(PROD_URL, PROD_USERNAME, PROD_PASSWORD)) {

            // Get column size information from PROD
            synchronizeColumnSizes(devConn, prodConn);

        } catch (SQLException e) {
            System.err.println("Error connecting to databases: " + e);
        }
    }

    private static void synchronizeColumnSizes(Connection devConn, Connection prodConn) throws SQLException {
        DatabaseMetaData devMeta = devConn.getMetaData();
        DatabaseMetaData prodMeta = prodConn.getMetaData();
        
        
        Statement stmt = null;
		ResultSet rs;
		stmt = prodConn.createStatement();
		

        // Prepare a query to get all table names in DEV (adjust for Oracle)
        String query = "SELECT TABLE_NAME FROM user_tables where TABLE_NAME like 'BADACTORS'";

        // Execute the query on DEV database
//        Statement devStmt = devConn.createStatement();
        ResultSet prodTables = stmt.executeQuery(query);

        while (prodTables.next()) {
        	
        	
            String tableName = prodTables.getString("TABLE_NAME");

            // Get DEV table details (column names)
            ResultSet proColumns = prodMeta.getColumns(null, null, tableName, null);

            while (proColumns.next()) {
                String columnName = proColumns.getString("COLUMN_NAME");
                int prodSize = proColumns.getInt("COLUMN_SIZE"); // Use DATA_TYPE_MOD for Oracle column size

                // Get corresponding column details from PROD
                ResultSet devColumns = devMeta.getColumns(null, null, tableName, columnName);
                if (devColumns.next()) {
                    int devSize = devColumns.getInt("COLUMN_SIZE");
                    String data_type=devColumns.getString("DATA_TYPE");

                    // Update DEV column size if smaller
                    if (devSize < prodSize) {
                        
                        String alterQuery = "ALTER TABLE " + tableName + " MODIFY (" + columnName + " "+data_type + "(" + prodSize + "))";
                        System.out.println("Executing query: " + alterQuery); // For logging

                        Statement devStmt2 = devConn.createStatement();
                        devStmt2.execute(alterQuery);
                    }
                    else {
                    	System.out.println("size in DEV "+tableName +" is large or equal");
                    }
                } else {
                    System.err.println("Warning: Column " + columnName + " not found in PROD table " + tableName);
                }
                devColumns.close();
            }
            proColumns.close();
        }

        prodTables.close();
        stmt.close();
    }
}
