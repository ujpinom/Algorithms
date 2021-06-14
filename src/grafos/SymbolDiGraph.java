package grafos;

import java.io.FileNotFoundException;
import java.util.Scanner;

import edu.princeton.cs.algs4.ST;

public class SymbolDiGraph {
	
	
	ST<String, Integer> mapa= new ST<>();
	
	private DiGraph dig;
	
	private String [] claves;
	
	
	public SymbolDiGraph(String direccion, String separador) throws FileNotFoundException {
		
		java.io.File file = new java.io.File(direccion);
		
		Scanner input = new Scanner(file);
		
		
		while(input.hasNextLine()) {
			
			String[] a = input.nextLine().split(separador);
			
			int n= a.length;
			
			for(int i=0;i<n;i++) {
				
				if(!mapa.contains(a[i])) {
					
					mapa.put(a[i], mapa.size());
					
				}
			}
			
		}
		
		claves= new String[mapa.size()];
		
		for(String nombre: mapa.keys()) {
			
			claves[mapa.get(nombre)]=nombre;
		}
		
		
		 dig= new DiGraph(mapa.size());
		 
		 
		 input = new Scanner(file);
		 
		 while(input.hasNextLine()) {
			 
			 String[] a = input.nextLine().split(separador);
			 
			 int v= mapa.get(a[0]);
			 
			 for(int i=1;i<a.length;i++) {
				 
				 dig.addEdge(v, mapa.get(a[i]));
				 
			 }
			 
			 
		 }

		
	}
	
	
	public boolean contains(String s) {
		
		return mapa.contains(s);
	}
	
	public int index(String s) {
		
		return mapa.get(s);
	}
	
	public String nombre(int v) {
		return claves[v];
	}
	
	public DiGraph digrafo() {
		return dig;
	}
	
	
	
	

}
