package java8;

import java.util.HashMap;

public class TestMain {
	

	
	

	public static void main(String[] args) {
		
		int arr[]= {1,2,3};
    int curr=0;
    int k=3;
    int result=0;
    HashMap<Integer,Integer> map=new HashMap<>();
    map.put(0, 1);
    
    
    for(int i=0;i<arr.length;i++) {
    	
    	curr+=arr[i];
    	int target=curr-k;
    	if(map.containsKey(target)) {
    	
    		result+=map.get(target);
    		
    	}
    	
    	map.put(curr,map.getOrDefault(curr,0)+1);
    	
    	
    }
    
    System.out.println(result);
		
		
		
			

	}

}
