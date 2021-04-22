package grafos;

import java.io.FileNotFoundException;
import java.util.Scanner;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class TestSearch {

	
	public static void main(String[] args) throws FileNotFoundException
	{
		
	java.io.File file = new java.io.File("C:\\Users\\SONY\\Desktop\\tinyG.txt");
	
	Scanner input = new Scanner(file);
		
	UndirectedGraph G = new UndirectedGraph(input);
	
	
	int s = 0;
	
	DepthFisrtSearch search = new DepthFisrtSearch(G, s);
	for (int v = 0; v < G.V(); v++)
	if (search.marked(v))
	StdOut.print(v + " ");
	StdOut.println();
	if (search.count() != G.V())
	StdOut.print("NOT ");
	StdOut.println("connected");
	}
	
	
}
