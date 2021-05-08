package grafos;

import java.io.FileNotFoundException;
import java.util.Scanner;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.Digraph;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

public class Testdigraph {
	
	
	public static void main(String a[]) throws FileNotFoundException {
		
		
		
		
		
		
		java.io.File file = new java.io.File("C:\\Users\\SONY\\Desktop\\tinyDG.txt");
		
		Scanner input = new Scanner(file);
		
		DiGraph g= new DiGraph(input);
		
//		System.out.println(g);
//		
//		
//		DiGraph g1= g.invertir();
//		
//		System.out.println();
//		
//		System.out.println(g1);
		
		DirectedCycle ciclo= new DirectedCycle(g);
		
		System.out.println(ciclo.tieneCiclo());
		
		for(int s: ciclo.ciclo()) {
			
			System.out.print(s+" ");
		}
		

	}

}
