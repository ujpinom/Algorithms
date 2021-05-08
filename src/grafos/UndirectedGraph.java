package grafos;

import java.util.Scanner;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;

public class UndirectedGraph {
	
	
	protected int V;
	protected int E;
	protected Bag<Integer>[] adj;
	
	protected UndirectedGraph g;
	
	



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
		
		 in.nextLine();
		
		while(in.hasNextLine()) {
			String[] a= in.nextLine().split(" ");
			
			int n= a.length;
			int v= Integer.parseInt(a[0]);
			
			for(int i=1;i<n;i++) {
				
				addEdge(v, Integer.parseInt(a[i]));
		
			}
	
		}
		
	}
	
	@SuppressWarnings("unchecked")
	public  UndirectedGraph(UndirectedGraph g) {
		
		if(g==null) {
			this.V=0;
		}
		else {
		
		this.g=g;
		
		this.V=g.V;
		this.E=g.E;
		
		this.adj=(Bag<Integer>[]) new Bag[g.V()];
		
		
		for(int i=0;i<g.V();i++) {
			adj[i]= new Bag<Integer>();
			adj[i]=g.adj[i];
		}	
		
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
	
	
	public UndirectedGraph copyGrafo() {
		return g;
	}
	
	
	/**
	 * 
	 * @param v
	 * @return Número de vertices adyacentes a v
	 */
	
	public Iterable<Integer> adj(int v){
		
		return adj[v];
		
	}
	
	public boolean hasEdges(int v,int w) {
		
		Bag<Integer> temp1= adj[v];
		
		Bag<Integer> temp2= adj[w];
		
		if(temp1.size()>=temp2.size()) {
			
			return hasEdges(temp2,v);
		}
		
		
		
		else {
			return hasEdges(temp1,w);
		}
		
		
	}
	
	private boolean hasEdges(Bag<Integer> bag, int v) {
	
		for(int s:bag) {
			if(s==v) {
				return true;
			}
			
		}
		
		return false;
		
		
	}

}
