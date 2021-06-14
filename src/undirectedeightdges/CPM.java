package undirectedeightdges;

import java.io.FileNotFoundException;
import java.util.Scanner;

import edu.princeton.cs.algs4.StdOut;

public class CPM {
	private static final String NEWLINE= System.getProperty("line.separator");
	private AcyclicLP lp;
	
	private int N;
	private int source;
	private int sink;
	
	public CPM(String dir) throws FileNotFoundException {
		
		java.io.File file = new java.io.File(dir);
		Scanner input = new Scanner(file);
		
		 N= input.nextInt();
		
		EdgeWeightedDigraph g= new EdgeWeightedDigraph(2*N+2);
		
		
		source= 2*N;
		sink= 2*N+1;
		
		input.nextLine();
		
		for(int i=0;i<N;i++) {
			
			String [] a = input.nextLine().split("\\s+");
			
			double duracion= Double.parseDouble(a[0]);
			
			g.addEdge(new DirectedEdge(source,i,0.0));
			g.addEdge(new DirectedEdge(i,N+i,duracion));
			g.addEdge(new DirectedEdge(N+i,sink,0.0));
			
			for(int j=1;j<a.length;++j) {
				
				int w= Integer.parseInt(a[j]);
				
				g.addEdge(new DirectedEdge(N+i,w,0.0));
				
			}
		}
		
		 lp= new AcyclicLP(g, source);

	}
	@Override
	public String toString() {
		
		 StringBuilder s = new StringBuilder();
	     s.append("INICIO TIEMPO" + NEWLINE);
		
		for (int i = 0; i < N; i++) {
			String tem= String.format("%4d: %5.1f\n", i, lp.distTo(i));
			s.append(tem);
			
		}
		
		s.append(String.format("Tiempo final: %5.1f\n",lp.distTo(sink)));
		
		
		return s.toString();
		
	}
	

}
