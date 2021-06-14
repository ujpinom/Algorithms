package grafos;

import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.Stack;

public class DirectedCycle {
	
	private boolean marked[];
	private boolean enPila[];
	private int conexionA[];
	private Stack<Integer> ciclo;
	
	
	public DirectedCycle(DiGraph g) {
		
		marked= new boolean[g.V()];
		enPila=new boolean[g.V()];;
		conexionA= new int[g.V()];
		
		int n=g.V();
		
		for(int i=0;i<n;i++) {
			
			if(!marked[i]) {
				dfs(g,i);
			}
			
		}
		
		
	}
	
	
	private void dfs(DiGraph g, int v) {
		
		marked[v]=true;
		enPila[v]= true;
		
		for(int w: g.adj(v)) {
			
			if(tieneCiclo()) {
				return;
			}
			
			else if(!marked[w]) {
				conexionA[w]=v;
				dfs(g,w);
			}
			else if(enPila[w]) {
				
				ciclo= new Stack<Integer>();
				
				for(int x=v;x!=w;x=conexionA[x]) {
					
					ciclo.push(x);
				}
				ciclo.push(w);
				ciclo.push(v);
				
			}
	
		}
		
		enPila[v]= false;
	
	}
	
	public Iterable<Integer> ciclo(){
		
		return ciclo;
	}
	
	
	public boolean tieneCiclo() {
		return ciclo!=null;
	}
	
	

}
