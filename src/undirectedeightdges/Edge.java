package undirectedeightdges;

public class Edge implements Comparable<Edge> {
	
	private int v,w;
	private double weight;
	

	public Edge(int v, int w, double weight) {
		
		this.v=v;
		this.w=w;
		this.weight=weight;
		
		
	}
	
	
	public double weight() {
		return weight;
	}
	
	public int either() {
		return v;
	}

	public int other(int vertex) {
		
		if(vertex==v) {
			return w;
		}
		else if(vertex==w) {
			return v;
		}
		else {
			
			throw new IllegalArgumentException("vertex not found");
		}
		
		
	}
	
	@Override
	public int compareTo(Edge o) {
		if(this.weight<o.weight) {
			return -1;
		}
		
		else if(this.weight>o.weight) {
			return 1;
		}
		else
		return 0;
	}
	
	
	public String toString()
	{ return String.format("%d-%d %.2f", v, w, weight); }
	
	
	

}
