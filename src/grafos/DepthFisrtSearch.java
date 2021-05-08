package grafos;

import edu.princeton.cs.algs4.Stack;

public class DepthFisrtSearch {
	
	private boolean marked[];
	
	private int N;
	
	private final int source;
	
	private int [] edges;
	
	private UndirectedGraph g;
	
	public DepthFisrtSearch(UndirectedGraph g,int source) {
		
		marked=new boolean[g.V()];
		
		this.g=g;
		
		this.source=source;
		
		edges=new int[g.V()];
		
		dfs(g,source);
		
	}
	
	
	
	private void dfs(UndirectedGraph g,int s) {
		
		
		marked[s]=true;
		
		++N;
		
		for(Integer i: g.adj(s)) {
			
			if(!marked[i]) {
				edges[i]=s;
				dfs(g,i);
			}
			
		}
		
	}
	
	
	public boolean hasPath(int v) {
		
		return marked[v];
	}
	
	
	public Iterable<Integer> path(int v){
		
		if(v>=g.V()) {
			throw new IllegalArgumentException("Valor ingresado mayor que el número de vertices.");
		}
		
		
		if(!hasPath(v)) {
			return null;
		}
		
		Stack<Integer> path= new Stack<>();
		
		for(int x=v;x!=source;x=edges[x]) {
			
			path.push(x);
			
		}
		
		path.push(source);
		
		return path;
	}
	
	
	
	
	public boolean marked(int v) {
		
		return marked[v];
	}
	
	public int count() {
		return N;
	}
	
	
	

}
