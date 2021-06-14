package undirectedeightdges;

import edu.princeton.cs.algs4.IndexMinPQ;

public class EagerMST {
	
	private Edge[] edgeTo;
	private double distTo[];
	
	private boolean marked[];
	
	private IndexMinPQ<Double> pq;
	
	
	public EagerMST(EdgeWeightedGraph g) {
		
		edgeTo= new Edge[g.V()];
		
		distTo= new double [g.V()];
		
		
		pq= new IndexMinPQ<Double>(g.V());
		
		for(int i=0;i<g.V();i++) {
			distTo[i]= Double.POSITIVE_INFINITY;
		}
		
		
		distTo[0]=0;
		pq.insert(0, 0.0);
		
		while(!pq.isEmpty()) {
			
			visitar(g,pq.delMin());
			
		}

	}
	
	private void visitar(EdgeWeightedGraph g, int v) {
		
		marked[v]=true;
		
		for(Edge e: g.adj(v)) {
			
			int w=e.other(v);
			
			if(marked[w]) {
				continue;
			}
			
			if(e.weight()<distTo[w]) {
				
				
				distTo[w]=e.weight();
				edgeTo[w]=e;
				
				if(pq.contains(w)) {
					pq.changeKey(w, e.weight());
				}
				else {
					pq.insert(w, e.weight());
				}
				
				
			}

		}
		
		
	}

}
