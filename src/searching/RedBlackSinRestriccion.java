package searching;

public class RedBlackSinRestriccion <K extends Comparable<K>,V>{

	private Nodo root;
	private static final boolean RED=true;
	private static final boolean BLACK=false;
	
	class Nodo{
		
		private K k;
		private V v;
		private Nodo lefchild;
		private Nodo rightchild;
		private int N;
		private boolean color;
		
		Nodo(K k,V v,boolean color,int N){
			this.color=color;
			this.k=k;
			this.N=N;
			this.v=v;
		}
	}
	
	public void put(K k,V v) {
		
		
		root=put(root,root,k,v);
		
	}
	
	private Nodo put(Nodo actual,Nodo padre,K k,V v) {
		
		if(actual==null) {
			
			boolean colorActual=BLACK;
			
			
			
			
			
		}
		
		
		
	}
	
	private boolean isRed(Nodo x) {
		
		return x.color==RED;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
