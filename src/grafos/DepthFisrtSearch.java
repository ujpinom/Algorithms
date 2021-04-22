package grafos;

public class DepthFisrtSearch {
	
	private boolean marked[];
	
	private int N;
	
	public DepthFisrtSearch(UndirectedGraph g,int source) {
		
		marked=new boolean[g.V()];
		
		
		dfs(g,source);
		
	}
	
	
	
	private void dfs(UndirectedGraph g,int s) {
		
		
		marked[s]=true;
		
		++N;
		
		for(Integer i: g.adj(s)) {
			
			if(!marked[i]) {
				dfs(g,i);
			}
			
		}
		
	}
	
	
	public boolean marked(int v) {
		
		return marked[v];
	}
	
	public int count() {
		return N;
	}
	
	
	

}
