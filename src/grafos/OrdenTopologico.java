package grafos;

import java.util.Iterator;
import java.util.List;
import java.util.Stack;

import edu.princeton.cs.algs4.Digraph;

public class OrdenTopologico {
	
	private Iterable<Integer> order;

	DiGraph g; 
	
	public OrdenTopologico(DiGraph g) {
		
		this.g=g;
		
		
		DirectedCycle cyclefinder = new DirectedCycle(g);
		if (!cyclefinder.tieneCiclo())
		{
		DephFirstOrder dfs = new DephFirstOrder(g);
		order = dfs.reversePostOrder();
		}
	}
	
	public Iterable<Integer> order()
	{ return order; }
	public boolean isDAG()
	{ return order != null; }
	

	public boolean checkTopologia(DiGraph g, List<Integer>orden) {
		
		if(order==null) {
			throw new IllegalArgumentException("DiGraph no es DAG");
		}
		
		if(orden.size()!=g.V()) {
			return false;
		}
		
		
		boolean [] marked= new boolean[g.V()];
		
		for(int i=orden.size()-1;i>=0;i--) {
			
			if(marked[i]) {
				return false;
			}
			
			marked[i]=true;
			
			for(int w: g.adj(i)) {
				
				if(!marked[w]) {
					return false;
				}
			}
			
		}
		
		return true;
		
		
	}

}
