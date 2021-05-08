package grafos;

public class DirectedDFS {
	
	private boolean marked[];
	
	
	public DirectedDFS(DiGraph g, int source) {
		
		marked= new boolean[g.V()];
		
		marked[source]=true;
		
		dfs(g,source);
		
		
		
	}
	
	public DirectedDFS(DiGraph g, Iterable<Integer> sources) {
		
		marked= new boolean[g.V()];
		
		for(int s: sources) {
			
			if(!marked[s]) {
				marked[s]=true;
				dfs(g,s);
				
			}
			
		}
		
	}
	
	private void dfs(DiGraph g, int s) {
		
		
		for(int w: g.adj(s)) {
			
			if(!marked[w]) {
				
				marked[w]=true;
				
				dfs(g,w);
				
			}	
		}
		
	}
	

	public boolean marked(int v) {
		return marked[v];
	}
	


}
