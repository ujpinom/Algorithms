package grafos;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.ST;

public class SymbolGraph {
	
	private ST<String, Integer> st;
	
	private String [] keys;
	
	private UndirectedGraph g;
	

	public SymbolGraph(String file,String separador) {
		

		In in= new In(file);
		
		
		st=new ST<>();
		
		
		while(in.hasNextLine()) {
			String[] a= in.readLine().split(separador);
			
			int n= a.length;
			
			for(int i=0;i<n;i++) {
				
				if(!st.contains(a[i])) {
					
					st.put(a[i], st.size());
					
				}
				
			}
	
		}
		
		
		keys= new String[st.size()];
		
		for(String nombre: st.keys()) {
			
			keys[st.get(nombre)]=nombre;
			
		}
		
		g= new UndirectedGraph(st.size());
		
		 in= new In(file);
		
		while(in.hasNextLine()) {
			String[] a= in.readLine().split(separador);
			
			int n= a.length;
			
			int v=  st.get(a[0]);
			
			for(int i=1;i<n;i++) {
				
				g.addEdge(v, st.get(a[i]));
				
			}
	
		}
		
	}
	
	public boolean contains(String s) {
		
		return st.contains(s);
	}
	
	public int index(String s) {
		
		return st.get(s);
	}
	
	public String nombre(int v) {
		return keys[v];
	}
	
	public UndirectedGraph grafo() {
		return g;
	}

}
