package searching;

public class BST_2_3_SinRestricciones <K extends Comparable<K>,V> {


	private Nodo1 root;
	
	private class Nodo  extends Nodo1{
		
		private K k1;
		private K k2;
		private V v1;
		private V v2;
		private Nodo1 leftChild;
		private Nodo1 middleChild;
		private Nodo1 rightChild;
		private int N;
		
		public Nodo(K k1, K k2, V v1, V v2, int n) {
			super(k2, v2, n);
			this.k1 = k1;
			this.k2 = k2;
			this.v1 = v1;
			this.v2 = v2;
			N = n;
		}
	}

	private class Nodo1{
		
		private K k;
		private V v;
		private int N;
	
		Nodo1(K k,V v,int N){
			
			this.k=k;
			this.v=v;
			this.N=N;
		}

	}
	
	public void put(K k,V v) {
		
		root=put(root,k,v);
	
	}
	
	private boolean isTwoNodo(Object x) {
		
		if(x instanceof BST_2_3_SinRestricciones.Nodo1) {
			return true;
		}
		return false;
	}
	
	
	private Nodo1 put(Nodo1 x,K k,V v) {
		
		if(x==null && isTwoNodo(x)) {
			return new Nodo1(k,v,1);
		}
		
		else if(x!=null && isTwoNodo(x)) {
			
			K temp= x.k;
			
			int comp=temp.compareTo(k);
			
			if(comp<0) {
				
				return new Nodo(temp,k,x.v,v,2);
			}
			else if(comp>0) {
				return new Nodo(k,temp,v,x.v,2);
			}
			
			else {
				x.v=v;
			}
		}
		
			
			Nodo temp=(BST_2_3_SinRestricciones.Nodo)x;
			
			int comp1=k.compareTo(temp.k1);
			int comp2=k.compareTo(temp.k2);
			
			if(comp1<0) {
				((BST_2_3_SinRestricciones.Nodo)x).leftChild=put(((BST_2_3_SinRestricciones.Nodo)x).leftChild,k,v);
			}
			
			else if(comp1>0 && comp2<0) {
				
				((BST_2_3_SinRestricciones.Nodo)x).middleChild=put(((BST_2_3_SinRestricciones.Nodo)x).middleChild,k,v);
			}
			else if(comp2<0) {
				((BST_2_3_SinRestricciones.Nodo)x).rightChild=put(((BST_2_3_SinRestricciones.Nodo)x).rightChild,k,v);
			}
			
			else if(comp1==0) {
				((BST_2_3_SinRestricciones.Nodo)x).v1=v;
			}
			else if(comp2==0) {
				((BST_2_3_SinRestricciones.Nodo)x).v2=v;
			}
			
			((BST_2_3_SinRestricciones.Nodo)x).N=size(((BST_2_3_SinRestricciones.Nodo)x).leftChild)+size(((BST_2_3_SinRestricciones.Nodo)x).middleChild)+
					size(((BST_2_3_SinRestricciones.Nodo)x).rightChild)+2;
		
		return x;
		
	}
	
	public int size() {
		return size(root);
	}
	
	
	private int size(Nodo1 x) {
		
		if(x==null) {
			
			return 0;
		}
		else {
		
			
			return x.N;
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
