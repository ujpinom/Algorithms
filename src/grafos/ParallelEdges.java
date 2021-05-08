package grafos;

public class ParallelEdges {
	
	
	private int paralelo;
	
	public ParallelEdges(UndirectedGraph g) {
		
		
		parallelEdges(g);
		
	}
	
	
	private void parallelEdges(UndirectedGraph g) {
		
		int vertices= g.V();
		
		for(int v=0;v<vertices;v++) {
			
			boolean [] marked= new boolean[vertices];
			
			for(int w: g.adj(v)) {
				
				if(!marked[w]) {
					
					
					marked[w]=true;
				}
				
				else {
					++paralelo;
				}
		
			}

			
		}

	}
	
	
	public int parallel() {
		return paralelo/2;
	}

}
