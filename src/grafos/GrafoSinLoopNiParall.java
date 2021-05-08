package grafos;

import java.util.Scanner;

import edu.princeton.cs.algs4.In;

public class GrafoSinLoopNiParall extends UndirectedGraph {

	public GrafoSinLoopNiParall(int v) {
		super(v);
	}
	
	@Override
	public void addEdge(int v,int w) {
		
		if(v==w || hasEdge(v, w)) {
			return;
		}
		
		adj[v].add(w);
		adj[w].add(v);
		++E;
	}
	
	
	private boolean hasEdge(int v, int w) {
		
		for(int s:adj[v]) {
			
			if(s==w) {
				return true;
			}
		}
		return false;
		
		
	}

}
