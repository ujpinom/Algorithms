package grafos;

import java.util.Arrays;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

public class BreathFirstSearch {
	
	private int count;
	private boolean [] marked;
	private int edges[];
	private int distancia[];
	
	private UndirectedGraph g;
	
	private int source;
	
	public BreathFirstSearch(UndirectedGraph g,int source) {
		
		marked= new boolean[g.V()];
		edges= new int [g.V()];
		distancia= new int[g.V()];
		this.g=g;
		this.source=source;
		
		bfs(g,source);
	
	}
	
	
	public void bfs(UndirectedGraph g,int s) {
		
		Queue<Integer> cola= new Queue<>();
		
		marked[s]=true;
		
		cola.enqueue(s);
		count++;
		
		
		while(!cola.isEmpty()) {
			
			int v=cola.dequeue();
			
			for(int w:g.adj(v)) {
				
				if(!marked[w]) {
					
					distancia[w]=distancia[v]+1;
					
					cola.enqueue(w);
					marked[w]=true;
					edges[w]=v;
					count++;
		
				}
				
			}
	
		}

	}
	
	public Iterable<Integer> paths(int v){
		
		if(!marked[v]) {
			return null;
		}

		Stack<Integer> st=new Stack<>();
		
		for(int x=v;x!=source;x=edges[x]) {
	
			st.push(x);	
		}
		
		st.push(source);
		
		
		return st;
		
	}
	

	
	public boolean marked(int v) {
		
		return marked[v];
	}
	
	
	public int count() {
		
		return count;
		
	}
	
	public int distancia(int v) {
		return distancia[v];
	}
	
	public int maxDist() {
		
		int temp [] = distancia;
		
		Arrays.sort(temp);
		return temp[temp.length-1];
				
	}
	

}
