package undirectedeightdges;

import java.io.FileNotFoundException;
import java.util.Timer;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

public class TestEWD {

	public static void main(String[] args) throws FileNotFoundException {
		
		CPM cpm= new CPM("C:\\\\Users\\\\SONY\\\\Desktop\\\\cpm.txt");
		
		System.out.println(cpm);
		
		

//		EdgeWeightedDigraph G= new EdgeWeightedDigraph("C:\\\\Users\\\\SONY\\\\Desktop\\\\tinyEWDAG.txt");
//		 
//		int s=5;
//		
//		
//		AcyclicLP sp= new AcyclicLP(G,s);
//		
//		
//
//
////    	System.out.println("Dijk");
////		
//		for (int t = 0; t < G.V(); t++)
//		{
//		StdOut.print(s + " to " + t);
//		StdOut.printf(" (%4.2f): ", sp.distTo(t));
//		if (sp.hasPath(t))
//		for (DirectedEdge e : sp.trayectoria(t))
//		StdOut.print(e + " ");
//		StdOut.println();
//		}
//		
//		
//		System.out.println("Otro");
//		for (int t = 0; t < 8; t++)
//		{
//		StdOut.print(s + " to " + t);
//		StdOut.printf(" (%4.2f): ", h.distTo(t));
//		if (h.hasPath(t))
//		for (DirectedEdge e : h.trayectoria(t))
//		StdOut.print(e + " ");
//		StdOut.println();
//		}
		
		
//		System.out.println(timer.elapsedTime());
	}

}
