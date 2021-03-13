package searching;

import java.util.Iterator;

public class Pruebas_ST {

	public static void main(String[] args) {

		BinarySearchST<String, Double> notas = new BinarySearchST<>(11);
		
		notas.put("A+", 4.33);
		notas.put("A", 4.0);
		notas.put("A-", 3.67);
		notas.put("B+", 3.33);
		notas.put("B", 3.0);
		notas.put("B-", 2.67);
		notas.put("C+", 2.33);
		notas.put("C", 2.0);
		notas.put("C-", 1.67);
		notas.put("D", 1.0);
		notas.put("F", 1.0);
		
		double califi=0;
		
		
		
		for(String s:notas.keys()) {
			 
			califi+=notas.get(s);
		}
		
		System.out.println("Promedio :"+ califi/notas.size());
		
		
	
		
		
	}

}
