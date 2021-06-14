package undirectedeightdges;

import edu.princeton.cs.algs4.MinPQ;
import edu.princeton.cs.algs4.Queue;

public class MST {
	
	private double weight;
	
	private Queue<Edge> tree;
	private boolean [] marked;
	
	private MinPQ<Edge> pq;
	
	public MST(EdgeWeightedGraph g) {
		
		tree= new Queue<>();
		marked= new boolean[g.V()];
		
		pq= new MinPQ<>();

		visitar(g,0);
		
		while(!pq.isEmpty()) {
			
			Edge min= pq.delMin();
			
			int v= min.either();
			int w= min.other(v);
			
			if(marked[v] && marked[w]) {
				continue;
			}
	
			tree.enqueue(min);
			
			weight+=min.weight();
			
			if(!marked[v]) {
				visitar(g,v);
			}
			
			else if(!marked[w]) {
				visitar(g,w);
			}
			
		}
		
	}
	
	/**
	 * Agrega vertices al MST y bordes a la cola de prioridad.
	 * 
	 * @param g EdgeWeightedGraph
	 * @param v Vertice del EdgeWeightedGraph
	 */
	
	private void visitar(EdgeWeightedGraph g, int v) {
		
		marked[v]=true; // Marca el vertice que ingresa al MST
		
		for(Edge e: g.adj(v)) { // Recorre todos los bordes incidentes en el vertice v

			if(!marked[e.other(v)]) {  // Revisa si el otro vertice está incluido en el MST para no agregar dicho borde a la cola de prioridad.
				
				pq.insert(e);
			}
			
		}
	
	}
	
	
	/**
	 * Retorna los bordes que constituyen al MST.
	 * 
	 * @return Retorna una {@code Queue} con objectos tipo {@code Edge}, los cuales constituyen el MST
	 */
	
	public Iterable<Edge> edges(){
		return tree;
		
	}
	
	public double weight() {
		return weight;
	}

}
