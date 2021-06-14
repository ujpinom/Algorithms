package grafos;

import edu.princeton.cs.algs4.Bag;

public class Degrees {
	
	private boolean isMap=true;
	
	private DiGraph reverse;
	private DiGraph g;
	
	public Degrees(DiGraph g) {
		
		this.g=g;
		
		reverse= g.invertir();
		
		
	}
	
	public int inDegree(int v) {
		
		return ((Bag<Integer>) reverse.adj(v)).size();
		
	}
	
	public int outDegree(int v) {
		
		return ((Bag<Integer>) g.adj(v)).size();
	}
	
	
	public Bag<Integer> sources(){
		
		Bag<Integer> sources= new Bag<>();
		
		int contador=0;
		
		for(Bag<Integer> source: (Bag<Integer>[])reverse.lista()) {
			
			if(source.size()==0) {
				sources.add(contador);
			}
			
			++contador;
		}
		
		return sources;
	
	}
	
	public Bag<Integer> sinks(){
		
		Bag<Integer> sources= new Bag<>();
		
		int contador=0;
		
		for(Bag<Integer> source: (Bag<Integer>[])g.lista()) {
			
			if(source.size()>1) {
				isMap=false;
			}
			
			if(source.size()==0) {
				sources.add(contador);
			}
			
			++contador;
		}
		
		return sources;
	
	}
	
	public boolean isMap() {
		return isMap;
	}

}
