package graph;
import java.util.*;

public class LearningGraph {
	
	static class Edge{
		int source;
		int dest;
		int weight;
		
		public Edge(int source,int dest, int weight){
			this.source=source;
			this.dest=dest;
			this.weight=weight;
			
		}
	}
	
	public static void createGraph(ArrayList<Edge> graph[]) {
		
		for(int i=0;i<graph.length;i++) {
			graph[i]=new ArrayList<Edge>();
			
		}
		graph[0].add(new Edge(0,1,2));
		graph[0].add(new Edge(0,2,4));
		
		graph[1].add(new Edge(1,2,1));
		graph[1].add(new Edge(1,3,7));
		
		
		graph[2].add(new Edge(2,4,3));
		

		graph[3].add(new Edge(3,5,1));
		

		graph[4].add(new Edge(4,3,2));
		graph[4].add(new Edge(4,5,5));
		

		
		
		
	}
	
	public static void CountNeighbour(ArrayList<Edge> graph[],int n) {
		
		for(int i=0;i<graph[n].size();i++) {
			Edge e= graph[n].get(i);
			System.out.println(e.dest);
			
		}
		
		
		
		
	}
	
	public static void DijktraAlgo(ArrayList<Edge> graph[], int[] vis,int V) {
		PriorityQueue<Integer> pq=new PriorityQueue<>();
		int[] dis=new int[V];
		pq.add(0);
		
		
		
		
	}
	
	public static void breadthFirstSearch(ArrayList<Edge> graph[], int V) {
		
		Queue<Integer> q=new LinkedList<>();
		boolean vis[]=new boolean[V];
		q.add(0);
		while(!q.isEmpty()) {
			int ele=q.remove();
			if(vis[ele]==false) {
				System.out.print(ele+ " ");
				vis[ele]=true;
				for(int i=0;i<graph[ele].size();i++) {
					Edge e =graph[ele].get(i);
					q.add(e.dest);
					
				}
					
				
				
			}
			
			
			
		}
		
		
	}
	
	public static void dfs(ArrayList<Edge>graph[],int currNode,boolean [] vis) {
		
		System.out.print(currNode +" ");
		vis[currNode]=true;
		for(int i =0;i<graph[currNode].size();i++) {
			Edge e=graph[currNode].get(i);
			if(vis[e.dest]==false)
			dfs(graph,e.dest,vis);
		}
			
			
		
		
	}

	public static void main(String[] args) {
		
		int v=6;
	  ArrayList<Edge> graph[]=new ArrayList[v];
	  createGraph(graph);
	  boolean[]vis=new boolean[v];
	  
//	  CountNeighbour(graph,2);
	  breadthFirstSearch(graph,v);
//	  System.out.println();
//	  dfs(graph,0,vis);
	  
		
	  

	}

}
