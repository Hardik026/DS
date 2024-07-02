package api;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.ProtocolException;
import java.net.URL;


public class Call {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		URL url = new URL("https://jsonmock.hackerrank.com/api/countries?name=Afghanistan");  
		HttpURLConnection connection = (HttpURLConnection)url.openConnection();
		try {
			connection.setRequestMethod("GET");
		} catch (ProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
//		connection.addRequestProperty("Content-Type", "application/json"); 
		  StringBuilder response = new StringBuilder();
	        try (BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()))) {
	            String line;
	            while ((line = reader.readLine()) != null) {
	                response.append(line);
	            }
	        }
	 
//	        JSONObject jsonResponse = new JSONObject(response.toString());
		Object is = connection.getResponseCode();  
		System.out.println(response);
		
		
	}

}
