package grafos;

import java.util.ArrayList;
import java.util.List;

import edu.princeton.cs.algs4.Queue;

public class ComponentesConectados {
	
	private int count;
	private int [] id;
	private boolean [] marked;
	
	private int contador=0;
	
	private List<Integer> tamaniosComponentes= new ArrayList<>();
	
	
	public ComponentesConectados(UndirectedGraph g) {
		
		int vertices= g.V();
		
		id= new int [vertices];
		
		marked= new boolean [vertices];

		for (int s=0;s<vertices;s++) {
			
			
			if(!marked[s]) {
				
				dfs(g,s);
				
				count++;
				
				tamaniosComponentes.add(contador);
				
				
				contador=0;

			}
			
			
		}
		
	}
	
	public List<Integer> sizeComponentes(){
		return tamaniosComponentes;
	}
	
	
	public void dfs(UndirectedGraph g,int source) {
			
		Queue<Integer> cola= new Queue<>();
		
		marked[source]=true;
		
		cola.enqueue(source);
		
		
		while(!cola.isEmpty()) {
			
			int v=cola.dequeue();
			
			for(int w:g.adj(v)) {
				
				if(!marked[w]) {
			
					cola.enqueue(w);
					marked[w]=true;
					id[w]=count;
					contador++;
		
				}
				
			}
	
		}


	}
	
	public int [] id() {
		return id;
	}
	
	public int count() {
		return count;
	}
	
	public boolean conectados(int v, int w) {
		
		return id[v]==id[w];
		
	}
	
	public int id(int v) {
		return id[v];
	}
	
}
