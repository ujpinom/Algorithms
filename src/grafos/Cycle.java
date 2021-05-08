package grafos;

public class Cycle {
	
	
	private UndirectedGraph g;
	
	private boolean [] marked;
	private boolean ciclo;
	
	
	public Cycle(UndirectedGraph g) {
		
		this.g=g;
		
		marked= new boolean[g.V()];
		
		for(int s=0;s<g.V();s++) {
			
			if(!marked[s]) {
				dfs(g,s,s);
			}
		}
		
		
	}
	
	public void dfs(UndirectedGraph g,int v,int u) {
		
		marked[v]=true;
		
		for(int w:g.adj(v)) {
			
			if(!marked[w]) {
				dfs(g,w,v);
			}
			else if(w!=v) {
				ciclo=true;
			}
			
			
		}
	
	}

	public boolean esCiclico() {
		return  ciclo;
	}

}
