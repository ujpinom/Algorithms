package undirectedeightdges;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;
import grafos.DiGraph;

public class Topological {

	private Iterable<Integer> order;

	EdgeWeightedDigraph g; 
	
	public Topological(EdgeWeightedDigraph g) {
		
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
	
	
}

class DephFirstOrder{
	private boolean [] marked;
	private Queue<Integer> preOrder;
	private Queue<Integer> postOrder;
	private Stack<Integer> reversePostOrder;
	
	public DephFirstOrder(EdgeWeightedDigraph g) {
		
		marked= new boolean[g.V()];
		preOrder= new Queue<>();
		postOrder=new Queue<>();
		reversePostOrder= new Stack<>();
		
		
		for(int i=0;i<g.V();i++) {
			
			if(!marked[i]) {
				dfs(g,i);
			}
			
		}
		
	}
	
	
	private void dfs(EdgeWeightedDigraph g, int s) {
		
		preOrder.enqueue(s);
		marked[s]=true;
		
		for(DirectedEdge e:g.adj(s)) {
			
			int w= e.to();
			if(!marked[w]) {
				dfs(g,w);
			}
		}
		
		postOrder.enqueue(s);
		reversePostOrder.push(s);
		
	}
	
	public Iterable<Integer> preOrder(){
		return preOrder;
	}
	
	public Iterable<Integer> postOrder(){
		return postOrder;
	}
	
	public Iterable<Integer> reversePostOrder(){
		return reversePostOrder;
	}
	
	
}


class DirectedCycle{

	private boolean marked[];
	private boolean enPila[];
	private int conexionA[];
	private Stack<Integer> ciclo;
	
	
	public DirectedCycle(EdgeWeightedDigraph g) {
		
		marked= new boolean[g.V()];
		enPila=new boolean[g.V()];;
		conexionA= new int [g.V()];
		
		int n=g.V();
		
		for(int i=0;i<n;i++) {
			
			if(!marked[i]) {
				
				dfs(g,i);
				
			}
			
			
		}
	
		
		
	}
	
	private void dfs(EdgeWeightedDigraph g, int v) {
		
		marked[v]=true;
		enPila[v]= true;
		
		for(DirectedEdge e: g.adj(v)) {
			
			int w=e.to();
			
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
