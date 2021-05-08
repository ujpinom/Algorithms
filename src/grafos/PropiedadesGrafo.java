package grafos;

import edu.princeton.cs.algs4.BreadthFirstDirectedPaths;
import edu.princeton.cs.algs4.Queue;

public class PropiedadesGrafo {

	private UndirectedGraph g;
	
	private BreathFirstSearch conectado;
	
	private int diametro;
	
	private int radio=Integer.MAX_VALUE;
	
	private int [] excentri;
	
	private int girth= Integer.MAX_VALUE;
	
	
	
	
	public PropiedadesGrafo(UndirectedGraph g) {
		
		if(g==null) {
			throw new IllegalArgumentException("Argumento nulo no permitido");
		}
		
		conectado=new BreathFirstSearch(g, 0);
		
		if(conectado.count()!=g.V()) {
			throw new IllegalArgumentException("Grafo no conectado");
		}
		
		this.g=g;
		
		excentri= new int[g.V()];
		
		
		
		propiedadesGrafo();
		

	}
	
	public void propiedadesGrafo() {
		
	for(int i=0;i<g.V();i++) {
			
			girth=Math.min(bfs(g,i), girth);
				
			int t=eccentricity(i);
			
			excentri[i]=t;
			
			if(t>diametro) {
				diametro=t;
			}
			
			if(t<radio) {
				radio=t;
			}
		}
		
	}
	
	
	private int bfs(UndirectedGraph g, int s) {
		
		boolean marked[] = new boolean[g.V()];
		
		int distancia[]=new int[g.V()];
		int [] conexion= new int[g.V()];
		
		marked[s]= true;
		
		conexion[s]=-1;
		
		
		int cicloLegnth= Integer.MAX_VALUE;
		
		
		Queue<Integer> cola= new Queue<>();
		
		cola.enqueue(s);
		
		while(!cola.isEmpty()) {
			
			int v= cola.dequeue();
			
			for(int w: g.adj[v]) {
				
				if(!marked[w]) {
					
					marked[w]=true;
					cola.enqueue(w);
					
					distancia[w]= distancia[v]+1;
					conexion[w]= v;
					
				}
				else if( conexion[v]!=w) {
					
					int ciclo= distancia[v]+distancia[w]+1;
					
					cicloLegnth= Math.min(cicloLegnth, ciclo);
			
				}
			}
			
		}
	return cicloLegnth;
	
	}
	
	
	public int diametro() {
	
		return diametro;
		
		
	}
	
	public int radio() {
	
		return radio;
	}
	
	
	public int vertice() {
		
		int n=g.V();
		
		int vertice=0;
		
		for(int i=0;i<n;i++) {
			
			if(excentri[i]==radio) {
				vertice=i;
				break;
			}
			
		}
		return vertice;
		
	}
	
	public int girth() {
		return girth;
	}
	
	public int eccentricity(int v) {
		
		BreathFirstSearch conectado= new BreathFirstSearch(g, v);
		
		return conectado.maxDist();
		
	}
	
	
}
