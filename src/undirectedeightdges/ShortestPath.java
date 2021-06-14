package undirectedeightdges;

import java.util.Arrays;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

public class ShortestPath {
	
	private double [] distTo;
	
	private DirectedEdge[] edgeTo;
	
	
	public ShortestPath(EdgeWeightedDigraph g, int source) {
		
		distTo= new double [g.V()];
		
		Arrays.fill(distTo, Double.POSITIVE_INFINITY);
		
		distTo[source]=0.0;
		
		edgeTo= new DirectedEdge[g.V()];
		
		
		Queue<Integer> cola = new Queue<>();
		
		cola.enqueue(source);
		
		while(!cola.isEmpty()) {
			
			int v=cola.dequeue();
			
			for(DirectedEdge e: g.adj(v)) {
				
				int w= e.to();
				
				if(distTo[w]>distTo[v]+e.weight()) {
					
					distTo[w]=distTo[v]+e.weight();
					edgeTo[w]=e;
					cola.enqueue(w);

				}
			}
			
			
		}
		

	}
	

	
	public double distTo(int v) {
		
		return distTo[v];
	}
	
	public boolean hasPath(int v) {
		
		return distTo[v]!=Double.POSITIVE_INFINITY;
		
	}
	
	public  Stack<DirectedEdge> trayectoria(int v){
		
		if(!hasPath(v)) {
			return null;
		}
		
		Stack<DirectedEdge> path= new Stack<>();
		
		for(DirectedEdge e=edgeTo[v];e!=null;e=edgeTo[e.from()]) {
			
			path.push(e);
			
		}
		
		return path;

	}

}
