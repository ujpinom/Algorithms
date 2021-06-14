package grafos;

import edu.princeton.cs.algs4.Bag;

public class SCC {
	
	private boolean [] marked;
	
	private int [] ids;
	
	private int count=0;
	
	public  SCC(DiGraph g) {
		
		marked= new boolean[g.V()];
		
		ids= new int[g.V()];
		
		DephFirstOrder order= new DephFirstOrder(g.invertir());
		
		for(int s: order.reversePostOrder()) {
			
			if(!marked[s]) {
				dfs(g,s);
				++count;
			}
			
		}
		
		
	}
	
	
	
	
	private void dfs(DiGraph g,int s) {
		
		marked[s]=true;
		ids[s]=count;
		
		for(int w:g.adj(s)) {
			
			if(!marked[w]) {
				
				dfs(g,w);
			}
			
		}
		
		
	}
	
	public Bag<Integer> componente(int v){
		
		Bag<Integer> bag= new Bag<Integer>();
		
		int c= ids[v];
		
		for(int i=0;i<ids.length;i++) {
			
			if(ids[i]==c) {
				
				bag.add(i);
			}
			
		}
		
		return bag;
		
	}
	
	
	public boolean fuertementeConectados(int v,int w) {
		
		return ids[w]==ids[v];
		
	}
	
	
	public int count() {
		return count;
	}
	

	public int id(int v) {
		return ids[v];
	}
	
	

}
