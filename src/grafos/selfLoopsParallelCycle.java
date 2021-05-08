package grafos;

import edu.princeton.cs.algs4.Queue;

public class selfLoopsParallelCycle {
	
	private boolean ciclo;
	
	

	public selfLoopsParallelCycle(UndirectedGraph g) {

		int n=g.V();
		
		for(int i=0;i<n;i++) {

			bfs(g,i);
		
			if(ciclo) {
				break;
			}
		}

	}
	
	
	
	private void bfs(UndirectedGraph g,int s) {
		
		Queue<Integer> cola= new Queue<>();
		
		int [] padre= new int[g.V()];
		
		padre[s]=-1;
		
		boolean marked[]= new boolean[g.V()];
		
		marked[s]=true;
		
		cola.enqueue(s);
		
		while(!cola.isEmpty()) {
			int v= cola.dequeue();
			
			for(int w:g.adj(v)) {
				
				if(!marked[w]) {
					
					marked[w]=true;
					cola.enqueue(w);
					padre[w]=v;
					
				}
				
				else if(padre[v]!=w) {
					
					ciclo=true;
					
				}

			}

		}
		
	}
	
	
	public boolean isCycle() {
		return ciclo;
	}

}
