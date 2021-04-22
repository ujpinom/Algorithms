package grafos;

import java.util.Scanner;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

public class UndirectedGraph {
	
	
	private int V;
	private int E;
	private Bag<Integer>[] adj;

	/**
	 * 
	 * @param Construye un grafo de V vertices sin conexión entre ellos
	 * 
	 */
	
	
	@SuppressWarnings("unchecked")
	public  UndirectedGraph(int V) {
		
		
		this.V=V;
		this.E=0;
		
		adj=(Bag<Integer>[]) new Bag[V];
		
		for(int i=0;i<V;i++) {
			
			adj[i]=new Bag<Integer>();
			
		}
		
	}
	
	public  UndirectedGraph(Scanner in) {
		
		this(in.nextInt());
		
		
		int E= in.nextInt();
		

		for(int i=0;i<E;i++) {
			

			int v= in.nextInt();
			int w= in.nextInt();
			
			addEdge(v, w);
			
		}
		
	}
	
	
	
	
	public UndirectedGraph(In entrada) {
		
		this(entrada.readInt());
		
		int E = entrada.readInt();
		
		for(int i=0;i<E;i++) {
			
			int v= entrada.readInt();
			int w= entrada.readInt();
			
			addEdge(v, w);
		
		}
	
	}

	/**
	 * 
	 * @return El número de vertices que contiene el grafo
	 */
	
	public int V() {
		return V;
	}
	
	
	/**
	 * Agrega una conexión entre los vertices especificados
	 * 
	 * @param v Vertice v
	 * @param w Vertice w
	 */
	
	public void addEdge(int v,int w) {
		
		adj[v].add(w);
		adj[w].add(v);
		++E;
		
		
	}
	
	
	public String toString() {
		
		String s = V + " vertices, " + E + " edges\n";
		for (int v = 0; v < V; v++)
		{
			s += v + ": ";
			for (int w : this.adj(v))
				s += w + " ";
		s += "\n";
		}
		
		return s;
		
	}
	

	/**
	 * 
	 * @return El número de bordes que contiene el grafo
	 */
	public int E() {
		return E;
	}
	
	
	/**
	 * 
	 * @param v
	 * @return Número de vertices adyacentes a v
	 */
	
	public Iterable<Integer> adj(int v){
		
		return adj[v];
		
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
