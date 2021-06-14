package grafos;

import java.util.Iterator;
import java.util.Stack;

import edu.princeton.cs.algs4.Bag;

public class Euler {
	
	Stack<Integer> ciclo= null;
	
	

	public Euler(DiGraph g) {
		
		
		if(g==null) {
			throw new IllegalArgumentException("null DiGraph");
		}
		
		if(g.E()==0) {
			return;
		}
		
		for(int i=0;i<g.V();i++) {
			
			if(((Bag<Integer>)g.adj(i)).size()!=((Bag<Integer>)g.invertir().adj(i)).size()) {
				return;
			}
			
		}
		
		Stack<Integer> recorrido= new Stack<Integer>();
		
		
		int inicio=0;
		
		while(((Bag<Integer>)g.adj(inicio)).size()==0) {
			
			++inicio;
			
		}
		
		recorrido.push(inicio);
		
		
		@SuppressWarnings("unchecked")
		Iterator<Integer>[] iteradores= (Iterator<Integer>[])new Iterator[g.V()];
		
		for(int i=0;i<g.V();i++) {
			
			iteradores[i]=g.adj(i).iterator();
		}
		
		ciclo=new Stack<>();
		
		while(!recorrido.isEmpty()) {
			
			int v= recorrido.pop();
			
			while(iteradores[v].hasNext()) {
				
				recorrido.push(v);
				
				v=iteradores[v].next();
				
			}
			
			ciclo.push(v);
			
			
		}
		
		
		if(ciclo.size()!=g.E()+1) {
			ciclo=null;
		}

	}
	
	
	public boolean tieneCicloEuler() {
		return ciclo!=null;
	}
	
	public Stack<Integer> ciclo(){
		return ciclo;
	}
	

	

}
