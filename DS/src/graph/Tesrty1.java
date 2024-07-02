package graph;

//{ Driver Code Starts
//Initial Template for Java
import java.util.*;
import java.lang.*;
import java.io.*;

public class Tesrty1{
	


 public static void main(String[] args) throws IOException {

         ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
         
        ArrayList<Integer>a1=new ArrayList<>();
        a1.add(1);
        a1.add(2);
        a1.add(3);
        
        adj.add(a1);
        ArrayList<Integer>a2=new ArrayList<>();
        adj.add(null);
        a2.add(4);
        adj.add(null);
        adj.add(null);
        
        

        
         
         
         Solution obj = new Solution();
         ArrayList<Integer> ans = obj.bfsOfGraph(4, adj);
         for (int i = 0; i < ans.size(); i++)
             System.out.print(ans.get(i) + " ");
         System.out.println();
     }


//} Driver Code Ends


public static class Solution {
 

 
 
 // Function to return Breadth First Traversal of given graph.
 public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
     int ele,n;
     boolean vis[]=new boolean[V];
     Queue<Integer> q=new LinkedList<>();
     ArrayList<Integer> result = new ArrayList<>();
     q.add(0);
     while(!q.isEmpty()){
         ele=q.remove();
         
         
         System.out.println(vis[0]);
         if(vis[ele]==false){
             result.add(ele);
             vis[ele]=true;
             for(int i=0 ;i<adj.get(ele).size();i++){
                 
                      n=adj.get(ele).get(i);
                      q.add(n);
                     
              
                     }
             
         }
        
         
         
     }
     return result;
 }
     
 
     
     
     // Code here
 

}
}

