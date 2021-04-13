package searching;

import edu.princeton.cs.algs4.Queue;
import searching.BinarySearchTree.Nodo;

public class Exe_3_2_13<K extends Comparable<K>,V> {

	private Nodo root;
	
	public void put(K k, V v) {
		
		if(root==null) {
			root=new Nodo(k,v,1);
			return;
			
		}
		
		if(get(k)!=null) {
			return;
		}
		
		
		Nodo actual=root;
		Nodo padre=null;
		
		while(actual!=null) {

			int comp=k.compareTo(actual.k);
			
			if(comp<0) {
				actual.N=actual.N+1;
				padre=actual;
				actual=actual.leftChild;
			}
			else if (comp>0) {
				actual.N=actual.N+1;
				padre=actual;
				actual=actual.rightchild;
				
			}
		}
		
		if(k.compareTo(padre.k)>0){
			padre.rightchild=new Nodo(k,v,1);
			
		}
		
		else if(k.compareTo(padre.k)<0) {
			padre.leftChild=new Nodo(k,v,1);
		}

	}
	
	public Iterable<K> lista(){
	
		return lista(min(),max());
	}
	
	
	public Iterable<K> lista(K min,K max){
		
		Queue<K> cola= new Queue<K>();
		
		lista(root,cola,min,max);
		
		return cola;
		
		
	}
	
	public K max() {
		
		
		Nodo actual =root;
		
		while(actual.rightchild!=null) {
			
			actual=actual.rightchild;
			
			
		}
		
		return actual.k;
	}

	public K min() {
		
		Nodo actual=root;
		
		while(actual.leftChild!=null) {
			
			actual=actual.leftChild;
		}
		
		
		return actual.k;
	}

	private void lista(Nodo x,Queue q, K min,K max) {
		
		if(x==null) {
			return;
		}
		
		int compmin=min.compareTo(x.k);
		int compmax=max.compareTo(x.k);
		
		
		if(compmin<0) {
			
			lista(x.leftChild,q,min,max);
		}
		
		if(compmin<=0 && compmax>=0) {
			q.enqueue(x.k);
			System.out.println(x.N);
		}
		
		if(compmax>0) {
			lista(x.rightchild,q,min,max);
		}
		
	

	}
	
	public int size() {
		return size(root);
	}
		
	
	private int size(Nodo x) {
		
		if(x==null) {
			return 0;
		}
		else {
			return x.N;
		}
		
	}
	
	public int heigth() {
		return heigth(root)-1;
	}
	
	private int heigth(Nodo x) {
		
		if (x== null) {
			return 0;
		}
		
		int i=1+heigth(x.leftChild);
		int j=1+heigth(x.rightchild);
		
		return Math.max(i, j);
		

	}
	
	
	public V get(K k) {
		
		Nodo actual=root;
		
		while(actual!=null) {
			
			int comp=k.compareTo(actual.k);
			
			if(comp<0) {
				actual=actual.leftChild;
			}
			else if(comp>0) {
				actual=actual.rightchild;
			}
			
			else {
				return actual.v;
			}
		}
		
		
		return null;
	}
	
	
	public void borrarMin() {
		
		if(root==null) {
			return;
		}
		
		Nodo actual=root;
		Nodo padre=null;
		
		if(actual.leftChild==null) {
			root=actual.rightchild;
			root.N=size(root.leftChild)+size(root.rightchild)+1;
			return;
		}
		
		while(actual.leftChild!=null) {
			actual.N=actual.N-1;
			padre=actual;
			actual=actual.leftChild;
	
		}

			actual=actual.rightchild;
			padre.leftChild=actual;
		
	}
	
	public K select(int m) {
		
		if(m==root.N) {
			throw new IllegalArgumentException("Indice fuera de límites");
		}
		
		Nodo x=root;
		int auxi=m;
		
		while(x.leftChild!=null||x.rightchild!=null) {
			
			int t=size(x.leftChild);
			
			if(t>auxi) {
				
				x=x.leftChild;
				
			}
			
			else if(t<auxi) {
				
				x=x.rightchild;
				auxi=auxi-t-1;
				
			}
			else {
				break;
				
			}
			
		}
		
		return x.k;
		
	}
	
	
	public void borrarMax() {
		
		
		if(root==null) {
			return;
		}
		
		
		Nodo actual=root;
		Nodo padre=null;
		
		if(actual.rightchild==null) {
			root=actual.leftChild;
			root.N=size(root.leftChild)+size(root.rightchild)+1;
			return;
		}
		
		while(actual.rightchild!=null) {
			actual.N=actual.N-1;
			padre=actual;
			actual=actual.rightchild;
			
		}
		
		actual=actual.leftChild;
		padre.rightchild=actual;
		
	}
	
	public int rank(K k) {
		
		if(root==null) {
			return -1;
		}
		
		
		Nodo x= root;
		int indice=0;
		
		
		while(x!=null) {
			
			int comp=k.compareTo(x.k);
			
			if(comp>0) {
				
				indice=indice+size(x.leftChild)+1;
				x=x.rightchild;
				
			}
			
			else if(comp<0) {
				
				x=x.leftChild;
			}
			
			else {
				indice=indice+size(x.leftChild);
				break;
			}
			
		}
	
		return indice;
		
	}
	
	
	public boolean checkRank() {
		
		for(int i=0;i<root.N;i++) {
			
			if(i!=rank(select(i))) {
				return false;
			}
			
		}
		
		return true;
		
	}
	

	

	private class Nodo{
		
		K k;V v;
		Nodo leftChild;
		Nodo rightchild;
		int N;
		
		Nodo(K k,V v,int N){
			
			this.k=k;
			this.v=v;
			this.N=N;
		}
		

	}
	

	public static void main(String[] args) {

		Exe_3_2_13<Integer,Integer> hola= new Exe_3_2_13<>();
		
		
		
	
//		
	}

}
