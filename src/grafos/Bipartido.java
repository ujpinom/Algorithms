package grafos;

public class Bipartido {
	
	private boolean [] marked;
	private boolean [] color;
	private boolean bipartido=true;
	
	public Bipartido(UndirectedGraph g) {
		
		marked= new boolean[g.V()];
		color= new boolean[g.V()];
		
		for(int s=0;s<g.V();s++) {
			
			if(!marked[s]) {
				dfs(g,s);
			}
			
		}
		
		
	}
	
	
	private void dfs(UndirectedGraph g,int s) {
		
		marked[s]=true;
		
		for(int w:g.adj(s)) {
			
			if(!marked[w]) {
				
				color[w]=!color[s];
				
				dfs(g,w);
				
			}
			
			else if(marked[w]==marked[s]) {
				bipartido=false;
			}
			
		}
		
		
	}
	
	public boolean esBipartido() {
		return bipartido;
	}
	
	

}
