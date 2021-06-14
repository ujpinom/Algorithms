package undirectedeightdges;

import java.io.FileNotFoundException;
import java.util.Scanner;

import edu.princeton.cs.algs4.Bag;

public class EdgeWeightedDigraph {
	
	private static final String NEWLINE = System.getProperty("line.separator");
	
	
	private int V;
	private int E;
	
	Bag<DirectedEdge>[] lista;
	

	@SuppressWarnings("unchecked")
	public EdgeWeightedDigraph(int v)
	{
		this.V=v;
		
		lista=(Bag<DirectedEdge>[])new Bag[v];
		
		for(int i=0;i<v;i++) {
			
			lista[i] = new Bag<DirectedEdge>();
			
		}
		
	}
	
	
	@SuppressWarnings("unchecked")
	public EdgeWeightedDigraph(String dir) throws FileNotFoundException {
		
		java.io.File file = new java.io.File(dir);
		Scanner input = new Scanner(file);
		
		this.V=input.nextInt();
		int E=input.nextInt();
		
		if(V<=0) {
			throw new IllegalArgumentException("El número de vertices debe ser positivo");
		}
		
		if(E<0) {
			throw new IllegalArgumentException("E debe ser positivo");
		}
		
		lista=(Bag<DirectedEdge>[])new Bag[V];
		
		for(int i=0;i<V;i++) {
			
			lista[i]=new Bag<DirectedEdge>();
		}
		
		for(int i=0;i<E;i++) {
			
			int v= input.nextInt();
			int w=input.nextInt();
			
			double weight=Double.parseDouble(input.next());
			
			verificarVertex(v);
			verificarVertex(w);
			
			DirectedEdge e= new DirectedEdge(v,w,weight);
			
			addEdge(e);

		}
		
		
	}
	
	
	public void addEdge(DirectedEdge e) {
		
		int v= e.from();
		
		lista[v].add(e);
		
		++E;
		
	}
	
	public Iterable<DirectedEdge> adj(int v)
	{ return lista[v]; }
	
	
	public Iterable<DirectedEdge> edges()
	{
	Bag<DirectedEdge> bag = new Bag<DirectedEdge>();
	
	for (int v = 0; v < V; v++)
		for (DirectedEdge e : lista[v])
			bag.add(e);
	
	return bag;
	}
	
	private void verificarVertex(int v) {
		if (v < 0 || v >= V)
            throw new IllegalArgumentException("El vertice " + v + " no está entre 0 y " + (V-1));
	}
	
	
	@Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append(V + " " + E + NEWLINE);
        for (int v = 0; v < V; v++) {
            s.append(v + ": ");
            for (DirectedEdge e : lista[v]) {
                s.append(e + "  ");
            }
            s.append(NEWLINE);
        }
        return s.toString();
    }
	
	
	
	public int V() {
		return V;
	}
	
	public int E() {
		return E;
	}

}
