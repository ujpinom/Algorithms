package grafos;

import java.util.HashSet;

import edu.princeton.cs.algs4.Queue;

public class LowComAnc {
	
	private DiGraph g;
	
	private int[] dist;
	
	public LowComAnc(DiGraph g) {
		
		this.g=g;
		
		
		if(g==null) {
			throw new IllegalArgumentException("Argumento del constructor tiene valor nulo");
		}
		
		OrdenTopologico dag= new OrdenTopologico(g);
		
		if(!dag.isDAG()) {
			System.out.println("El grafo ingresado no es DAG");
			return;
		}
		
		dist=new int [g.V()];
		
		HashSet<Integer> fuentes= new HashSet<>();
		
		
		int [] esFuente= new int[g.V()];
		
		for(int i=0;i<g.V();i++) {
			
			for(int j: g.adj(i)){
				
				esFuente[j]++;
				
			}
		}
		
		for(int i=0;i<g.V();i++) {
			
			if(esFuente[i]==0) {
				
				fuentes.add(i);
			}
			
		}
		
		for(int i=0;i<g.V();i++) {
			dist[i]=-1;
		}
		
		
		for(int source: fuentes) {
			
			int [] distanciaActual= new int[g.V()];
			
			Queue<Integer> cola= new Queue<>();
			
			cola.enqueue(source);
			
			if(distanciaActual[source]>dist[source]) {
				dist[source]=distanciaActual[source];
			}
			
			
			while(!cola.isEmpty()) {
				
				int v= cola.dequeue();
				
				for(int w: g.adj(v)) {

					cola.enqueue(w);
					
					distanciaActual[w]=distanciaActual[v]+1;
					
					if(distanciaActual[w]>dist[w]) {
						
						dist[w]=distanciaActual[w];
					}
					
				}
				
				
			}
			
			
		}

	}
	
	
	public int lowCommonAncestor(int v, int w) {
		
		HashSet<Integer> ancestorsV= new HashSet<>();
		
		HashSet<Integer> commonAncestors= new HashSet<>();
		
		
		DiGraph invertV= g.invertir();
		
		Queue<Integer> cola= new Queue<>();
		
		cola.enqueue(v);
		
		while(!cola.isEmpty()) {
			
			int current= cola.dequeue();
			
			for(int vecino: invertV.adj(current)) {
				
				cola.enqueue(vecino);
				ancestorsV.add(vecino);
				
			}
			
		}
		
		cola.enqueue(w);
		
		while(!cola.isEmpty()) {
			
			int current= cola.dequeue();
			
			for(int vecino: invertV.adj(current)) {
				
				cola.enqueue(vecino);
				
				if(ancestorsV.contains(vecino)) {
					commonAncestors.add(vecino);
				}
				
				
			}
			
		}
		
		int maxDist=-1;
		
		int padre=-1;
		
		for(int ancestor: commonAncestors) {
			
			if(dist[ancestor]>maxDist) {
				
				maxDist=dist[ancestor];
				
				padre=ancestor;
			}
			
			
		}
		
		return padre;
		
	}
	
	
	public static void main(String a[]) {
		  DiGraph digraph2 = new DiGraph(5);
	        digraph2.addEdge(0, 1);
	        digraph2.addEdge(0, 2);
	        digraph2.addEdge(2, 3);
	        digraph2.addEdge(2, 4);
        LowComAnc lca= new LowComAnc(digraph2);
        
        
        System.out.println(lca.lowCommonAncestor(0, 1));
		
		
	}
	
	

}
