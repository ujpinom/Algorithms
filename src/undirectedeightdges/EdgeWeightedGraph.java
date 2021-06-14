package undirectedeightdges;

import java.io.FileNotFoundException;
import java.util.Scanner;

import edu.princeton.cs.algs4.Bag;

public class EdgeWeightedGraph {
	
	private static final String NEWLINE = System.getProperty("line.separator");
	
	private int V;
	private int E;
	
	private Bag<Edge>[] lista;
	
	
	@SuppressWarnings("unchecked")
	public EdgeWeightedGraph(int V) {
		
		this.V=V;
		
		if(V<=0) {
			throw new IllegalArgumentException("El número de vertices debe ser positivo");
		}
		
		lista=(Bag<Edge>[])new Bag[V];
		
		for(int i=0;i<V;i++) {
			
			lista[i]=new Bag<Edge>();
		}

	}
	
	
	@SuppressWarnings("unchecked")
	public EdgeWeightedGraph(String direccionArchivo) throws FileNotFoundException {
		
	java.io.File file = new java.io.File(direccionArchivo);
	Scanner input = new Scanner(file);
	
	this.V=input.nextInt();
	int E=input.nextInt();
	
	if(V<=0) {
		throw new IllegalArgumentException("El número de vertices debe ser positivo");
	}
	
	if(E<0) {
		throw new IllegalArgumentException("V y E deben ser positivos");
	}
	
	lista=(Bag<Edge>[])new Bag[V];
	
	for(int i=0;i<V;i++) {
		
		lista[i]=new Bag<Edge>();
	}
	
	for(int i=0;i<E;i++) {
		
		int v= input.nextInt();
		int w=input.nextInt();
		
		double weight=Double.parseDouble(input.next());
		
		verificarVertex(v);
		verificarVertex(w);
		
		Edge e= new Edge(v,w,weight);
		
		addEdge(e);

	}


		
	}
	
	public Iterable<Edge> adj(int v){
		verificarVertex(v);
		return lista[v];
		
	}
	
	public Iterable<Edge> edges(){
		
		Bag<Edge> b = new Bag<Edge>();
		for (int v = 0; v < V; v++)
		for (Edge e : lista[v])
		if (e.other(v) > v) b.add(e);
		return b;
	
	}
	
	public void addEdge(Edge e) {
		
		int v=e.either();
		int w= e.other(v);
	
		lista[v].add(e);
		lista[w].add(e);
		++E;
	}
	
	public int V() {
		return V;
	}
	
	public int E() {
		return E;
	}
	
	
	
	private void verificarVertex(int v) {
		if (v < 0 || v >= V)
            throw new IllegalArgumentException("El vertice " + v + " no está entre 0 y " + (V-1));
	}
	
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(V + " " + E + NEWLINE);
        for (int v = 0; v < V; v++) {
            s.append(v + ": ");
            for (Edge e : lista[v]) {
                s.append(e + "  ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }
	
	
	

}
