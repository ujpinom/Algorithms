package grafos;

import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Stack;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.Digraph;

public class DiGraph {
	
	private int V;
	private int E;
	
	private Bag<Integer> [] lista;
	
	private DiGraph copy;
	
	public DiGraph(int v) {
		
		this.V=v;
		
		lista=new Bag[v];
		
		for(int i=0;i<v;i++) {
			
			lista[i]= new Bag<Integer>();
			
		}

	}
	
	public DiGraph(DiGraph g) {
		
		copy= new DiGraph(g.V());
		
		Stack<Integer> temp= new Stack<>();
		for(int i=0;i<g.V();i++) {
			for(int w:g.adj(i) ) {
			
				temp.push(w);
				
			}
		
			while(!temp.empty()) {
				
				copy.addEdge(i, temp.pop());
				
			}

		}
		
	}
	
	public DiGraph copyDiGraph() {
		return copy;
	}
	
	
	public DiGraph(Scanner in)  {
		

		this(in.nextInt());
		
		int E= in.nextInt();
		
		for(int i=0;i<E;i++) {
			
			int v= in.nextInt();
			int w= in.nextInt();
			
			addEdge(v, w);
		
		}

	}
	
	public int V() {
		return V;
	}
	
	public int E() {
		return E;
	}
	
	public Bag<Integer> adj(int v){
		
		return lista[v];
	}
	
	
	public DiGraph invertir() {
		
		DiGraph rev= new DiGraph(V);
		
		for(int i=0;i<V;i++) {
			
			for(int w: adj(i)) {
				
				rev.addEdge(w, i);
				
			}	
		}
		
		return rev;
	
	}
	
	
	public boolean hasEdge(int v,int w) {
		
		if(v>=V) {
			throw new IllegalArgumentException("primer argumento mayor o igual al número de vertices del digrafo");
		}

		for(int s: adj(v)) {
			
			if(s==w) {
				return true;
			}
			
		}
		
		return false;
		
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
	
	public Iterable<Integer>[] lista(){
		return lista;
	}
	
	public void addEdge(int v, int w) {
		
		lista[v].add(w);
		
		++E;
	}
	

}
