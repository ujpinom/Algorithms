package searching;

import edu.princeton.cs.algs4.Queue;

public class Exe_3_2_12 <K extends Comparable<K>,V> {
	
	private int N;
	
	private Nodo root;
	
	private class Nodo{
		
		K k;
		V v;
		Nodo leftChild;
		Nodo rightChild;
		
		public Nodo(K k,V v) {
			this.k=k;
			this.v=v;
		}
		
	}
	
	public int size() {
		return N;
	}
	

	public void put(K k,V v) {
		
		root=put(root,k,v);
		
	}
	
	private Nodo put(Nodo raiz,K k, V v) {
		
		if(raiz==null) {
			++N;
			return new Nodo(k,v);
		}
		
		int comp=k.compareTo(raiz.k);
		
		if(comp<0) {
			
			raiz.leftChild=put(raiz.leftChild,k,v);
			
		}
		else if(comp>0) {
			
			raiz.rightChild=put(raiz.rightChild,k,v);
		}
		
		else{
			
			raiz.v=v;
			
		}
		
		return raiz;	
	}
	
	public V get(K k) {
		
		return get(root,k).v;
		
	}
	
	private Nodo get(Nodo x,K k) {
		
		if(x==null) {
			return null;
		}
		
		int comp=k.compareTo(x.k);
		
		if(comp<0) {
			
			return get(x.leftChild,k);
		}
		
		else if(comp>0) {
			return get(x.rightChild,k);
		}
		
		else {
			return x;
		}
		
	}
	
	public Iterable<K> lista(){
		
		Queue<K> cola= new Queue<>();
		
		lista(root,cola);
		
		return cola;
		
	}
	
	public void lista(Nodo x,Queue q){
		
		if(x==null) {
			return;
		}
	
		lista(x.leftChild,q);
		q.enqueue(x.k);
		lista(x.rightChild,q);
		
		
	}
	
	public K getMin() {
		
		
		return getMin(root).k;
		
	}
	
	private Nodo getMin(Nodo x) {
		
		if(x.leftChild==null) {
			return x;
		}
		
		return getMin(x.leftChild);

	}
	
	public void delMin() {
		
		root= delMin(root);
		
	}
	
	private Nodo delMin(Nodo x) {
		
		if(x.leftChild==null) {
			--N;
			return x.rightChild;
		}
		
		x.leftChild= delMin(x.leftChild);
		
		return x;
		
	}
	
	public void delMax() {
		
		root=delMax(root);
	}
	
	private Nodo delMax(Nodo x) {
		
		if(x.rightChild==null) {
			--N;
			return x.leftChild;
		}
		
		x.rightChild=delMax(x.rightChild);
		return x;
		
	}
	
	public void borrar(K k) {
		
		root=borrar(root,k);
		
	}
	
	
	private Nodo borrar(Nodo x,K k) {
		
		if(x==null) {
			return null;
		}
		
		int comp=k.compareTo(x.k);
		
		if(comp<0) {
			
			x.leftChild=borrar(x.leftChild,k);
			
		}
		else if(comp>0) {
			
			
			x.rightChild=borrar(x.rightChild,k);
			
		}
		
		else {
			--N;
			
			if(x.leftChild==null) {
				return x.rightChild;
			}
			else if(x.rightChild==null) {
				return x.leftChild;
			}
			else {
			
			
			Nodo t=x;
			
			
			Nodo min=getMin(t.rightChild);
			
			x=min;
			
			x.rightChild=delMin(t.rightChild);
			
			x.leftChild=t.leftChild;}
			
		}
		
		return x;
		
		
	}
	
	public K getMax() {
		return getMax(root).k;
	}
	
	public Nodo getMax(Nodo x) {
		if(x.rightChild==null) {
			return x;
		}
		
		return getMax(x.rightChild);
		
		
	}

	public static void main(String[] args) {
		
		Exe_3_2_12<Integer,Integer> as=new Exe_3_2_12<>();
		as.put(0, 5);
		as.put(1, 2);
		as.put(2, 3);
		as.put(3, 5);
		as.put(-2, 5);
		as.put(-1, 5);
		as.put(-10, 5);
		as.put(-7, 5);
		as.put(-11, 5);
		

		Queue<Integer> cola=(Queue<Integer>) as.lista();
		
		for(Integer i:cola) {
			System.out.print(i +" ");
		}
		
		as.borrar(-10);
		
		System.out.println();
		
	 cola=(Queue<Integer>) as.lista();
		
		for(Integer i:cola) {
			System.out.print(i +" ");
		}


	}

}
