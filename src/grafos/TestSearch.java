package grafos;

import java.io.FileNotFoundException;
import java.util.Scanner;

import edu.princeton.cs.algs4.Bag;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdOut;

public class TestSearch {

	
	public static void main(String[] args) throws FileNotFoundException
	{
		
	
		int [][] original= {{1,2,3},{1,2,3},{1,2,3}};
		
		imprimir(original);
		
		int [][] reemplazo= new int[original.length][original[0].length];
		
		int n=original.length-1;
		
		
		for(int i=0;i<original.length;i++) {
			for(int j=0;j<original.length;j++) {
				
				reemplazo[j][i]=original[i][j];
				
			}
		}
		
		System.out.println();
		imprimir(reemplazo);
		
		
		
//	java.io.File file = new java.io.File("C:\\Users\\SONY\\Desktop\\tinyG.txt");
//	
//	String source="Kidman, Nicole";
//	
//	Scanner input = new Scanner(file);
////	
//	String separador="/";
//	
//	
//	UndirectedGraph g = new UndirectedGraph(4);
//	g.addEdge(0, 1);
//	g.addEdge(2, 1);
//	g.addEdge(0, 2);
//	g.addEdge(1, 3);
////	g.addEdge(3, 4);
////	g.addEdge(5, 4);
////	g.addEdge(4, 3);
////	g.addEdge(4, 0);
////	g.addEdge(4, 0);
////	g.addEdge(1, 2);
////	g.addEdge(4, 2);
//	
//	EdgeConnectivity edge=new EdgeConnectivity(g);
//	
//	System.out.println(edge.components());
//	
	
//SymbolGraph sg= new SymbolGraph("C:\\Users\\SONY\\Desktop\\movies.txt", separador);
//
//UndirectedGraph g= sg.grafo();
//
//ComponentesConectados cc= new ComponentesConectados(g);
//
//System.out.println(g.E()+"-----"+g.V());
//
//BreathFirstSearch search = new BreathFirstSearch(g, sg.index("Kidman, Nicole"));
//System.out.println(search.count());
//
//System.out.println("Numero de componentes conectados "+ cc.count());
////	
////
//System.out.println("Componente más grande: "+cc.sizeComponentes());

//		
//	UndirectedGraph g = new UndirectedGraph(input);
//	
//	ComponentesConectados cc= new ComponentesConectados(g);
//	System.out.println("Numero de componentes conectados "+ cc.count());
//	System.out.println("Componente más grande: "+cc.sizeComponentes());
//	
//	graph.addEdge(0 ,0);
//       graph.addEdge(0 ,1);
//       graph.addEdge(0 ,1);
//       graph.addEdge(0 ,4);
//       graph.addEdge(1 ,2);
//       graph.addEdge(3 ,4);
//       graph.addEdge(2 ,3);
//       graph.addEdge(2 ,4);
//       
//       System.out.println(graph);
//    
//	
//	PropiedadesGrafo ds= new PropiedadesGrafo(graph);
//	
//	System.out.println(ds.girth());

	
	
	
//	
	

//	System.out.println(G.V()+"-----"+G.E());
//	
//	
//	for (int w : G.adj(sg.index(source)))
//		StdOut.println(" " + sg.nombre(w));
//	
//	System.out.println();
//	
	
//	
//	
//	
//	
//	
//	Cycle cycle= new Cycle(G);
//	
//	System.out.println("Es ciclico el grafo?: "+ cycle.esCiclico());
//	
//	Bipartido bi= new Bipartido(G);
//	
//	System.out.println("Es bipartido el grafo?: "+ bi.esBipartido());
//	
//	ComponentesConectados cc= new ComponentesConectados(G);
//	
//	System.out.print("Componentes conectados: "+cc.count()+"\n");
//	
//	Bag<Integer>[] componetes= new Bag[cc.count()]; 
//	
//	for(int i=0;i<cc.count();i++) {
//		
//		componetes[i]= new Bag<>();
//	}
//	
//	for(int i=0;i<G.V();i++) {
//		
//		componetes[cc.id(i)].add(i);
//	}
//	
//	for(int i=0;i<cc.count();i++) {
//		System.out.println("Componente: "+ i);
//		
//		for(int ss: componetes[i]) {
//			
//			System.out.print(ss+" ");
//			
//			
//		}
//		
//		System.out.println();
//		
//		
//	}
	
//	int s = 0;
//	
//	
//	BreathFirstSearch search = new BreathFirstSearch(G, s);
//	for (int v = 0; v < G.V(); v++)
//	if (search.marked(v))
//	StdOut.print(v + " ");
//	StdOut.println();
//	if (search.count() != G.V())
//	StdOut.print("NOT ");
//	StdOut.println("connected");
//	
//	Stack<Integer> hola= new Stack<>();
//	
//	hola=(Stack<Integer>) search.paths(6);
//	
//	for(int i:hola) {
//		
//		System.out.print(i+" ");
//		
//	}
//	
//	System.out.println();
//	System.out.println(search.distancia(2));
//	
	}
	
	public static void imprimir(int [][] matriz) {
		
		for(int i=0;i<matriz.length;i++) {
			for(int j=0;j<matriz.length;j++) {
				System.out.print(matriz[i][j]+" ");
			}
			System.out.println();
		}
		
	}
	
	
	
	
}
