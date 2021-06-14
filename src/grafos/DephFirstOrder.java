package grafos;


import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stack;

public class DephFirstOrder {
	
	private boolean [] marked;
	private Queue<Integer> preOrder;
	private Queue<Integer> postOrder;
	private Stack<Integer> reversePostOrder;
	
	public DephFirstOrder(DiGraph g) {
		
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
	
	
	private void dfs(DiGraph g, int s) {
		
		preOrder.enqueue(s);
		marked[s]=true;
		
		for(int w:g.adj(s)) {
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
