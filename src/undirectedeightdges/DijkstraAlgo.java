package undirectedeightdges;

import java.util.Arrays;

import edu.princeton.cs.algs4.IndexMinPQ;
import edu.princeton.cs.algs4.Stack;

public class DijkstraAlgo {
	
	private double [] distTo;
	
	private DirectedEdge[] edgeTo;
	
	private IndexMinPQ<Double> pq;
	
	public DijkstraAlgo(EdgeWeightedDigraph g, int source) {
		
		distTo= new double [g.V()];
		
		Arrays.fill(distTo, Double.POSITIVE_INFINITY);
		
		distTo[source]=0.0;
		
		edgeTo= new DirectedEdge[g.V()];
		
		pq= new IndexMinPQ<>(g.V());
		
		pq.insert(source, 0.0);
		
		while(!pq.isEmpty()) {
			
			relax(g,pq.delMin());
		}

	}
	
	
	private void relax(DirectedEdge g) {
		
		int v= g.from();int w=g.to();
		
		if(distTo[w]>distTo[v]+g.weight()) {
			
			distTo[w]=distTo[v]+g.weight();
			
			edgeTo[w]=g;
		}
	}
	
	private void relax(EdgeWeightedDigraph g, int v) {
		
		for(DirectedEdge e: g.adj(v)) {
			
			int w= e.to();
			
			if(distTo[w]>distTo[v]+e.weight()) {
				
				distTo[w]=distTo[v]+e.weight();
				edgeTo[w]=e;
				
				if(!pq.contains(w)) {
					pq.insert(w, e.weight());
				}
				else {
					pq.changeKey(w, e.weight());
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
