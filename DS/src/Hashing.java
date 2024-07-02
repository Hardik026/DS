import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.HashMap;
public class Hashing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		HashSet<Integer> set= new HashSet<>();
		set.add(1);
		set.add(3);
		set.add(2);
		set.add(4);
		set.add(2);
		Iterator<Integer> it = set.iterator();
		
		while(it.hasNext()) {
			System.out.println(it.next() +" has hashcode "+ it.hashCode());
			
		}
		
		
		HashMap<String,Integer> map=new HashMap<>();
		map.put("India", 120);
		map.put("Australia", 8);
		map.put("China", 150);
		if(map.containsKey("India")) {
			System.out.println("India is present ");
		
			
		}
		else {
			System.out.println("Not");
		}
		
		System.out.println(map);
		map.put("China", 160);
		
		System.out.println(map);
		
		
		for(Map.Entry<String, Integer> e:map.entrySet()) {
			System.out.println(e.getValue());
			
		}
		
		Set<String>  keys =  map.keySet();
		
		for(String key: keys) {
		System.out.println(key + " has value "+ map.get(key));
		
		}
		
		
//		String type=TypeMap.getJdbcTypeName(12);
		
		
		
		
		
		

	}

}
