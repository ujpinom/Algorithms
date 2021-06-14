package undirectedeightdges;

import java.util.Arrays;

import edu.princeton.cs.algs4.Stack;

public class AcyclicLP {
	
	private DirectedEdge[] edgeTo;
	
	private double [] distTo;
	
	
	public AcyclicLP(EdgeWeightedDigraph g, int s) {
		
		edgeTo= new DirectedEdge[g.V()];
		
		distTo= new double [g.V()];
		
		Arrays.fill(distTo, Double.NEGATIVE_INFINITY);

		distTo[s]=0.0;
		
		Topological topo= new Topological(g);
		
		if(!topo.isDAG()) {
			return;
		}
		
		Stack<Integer> orden= (Stack<Integer>) topo.order();
		
		while(!orden.isEmpty())
			relax(g, orden.pop());
		
		
	}
	
	private void relax(EdgeWeightedDigraph g, int v) {
		
		for(DirectedEdge e: g.adj(v)) {
			
			int w= e.to();
			
			if(distTo[w]< distTo[v] + e.weight()) {
				
				distTo[w]= distTo[v] + e.weight();
				
				edgeTo[w]= e;
				
			}
			
		}
		
	}
	
	public double distTo(int v) {
		
		return distTo[v];
	}
	
	public boolean hasPath(int v) {
		
		return distTo[v]!=Double.NEGATIVE_INFINITY;
		
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
