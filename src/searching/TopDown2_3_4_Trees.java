package searching;

import java.security.SecureRandom;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdRandom;
import searching.RedBlackSinRestriccion.Nodo;

public class TopDown2_3_4_Trees <K extends Comparable<K>,V> {
	
	
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
		
		
		root=put(root,k,v);
		root.color=BLACK;
		
	}
	
	private boolean isRed(Nodo x) {
		if(x==null) {
			return false;
		}
		return x.color==RED;
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
	
	private Nodo rotarIzquierda(Nodo h) {
		
		Nodo x= h.rightchild;
		h.rightchild=x.lefchild;
		x.lefchild=h;
		
		x.color=h.color;
		h.color=RED;
		x.N=h.N;
		h.N=size(h.lefchild)+size(h.rightchild)+1;
		return x;
		
	}
	
	
	
	private Nodo rotarDerecha(Nodo h) {
		
		Nodo x=h.lefchild;
		h.lefchild=x.rightchild;
		x.rightchild=h;
		x.color=h.color;
		h.color=RED;
		h.N=size(h.lefchild)+size(h.rightchild)+1;
		return x;
		
	}
	
	
	private Nodo put(Nodo x,K k,V v) {
		
		if(x==null) {
			return new Nodo(k,v,RED,1);
		}
		
		if(isRed(x.lefchild) && isRed(x.rightchild)) {
			cambiarColores(x);
		}
		
		int comp=k.compareTo(x.k);
		
		if(comp<0) {
			x.lefchild=put(x.lefchild,k,v);
		}
		else if(comp>0) {
			x.rightchild=put(x.rightchild,k,v);
			
		}
		
		else {
			x.v=v;
		}
		
		if(isRed(x.lefchild)&& isRed(x.lefchild.lefchild)) {
			
			x=rotarDerecha(x);
		}
		
		if(!isRed(x.lefchild) && isRed(x.rightchild)) {
			x=rotarIzquierda(x);
		}
		
		x.N=size(x.lefchild)+size(x.rightchild)+1;
		return x;
		
		
	}
	
	
	public V get(K k) {
		return get(root,k).v;
	}
	
	private Nodo get(Nodo x, K k) {
		
		if(x==null) {
			return null;
		}
		
		int comp=k.compareTo(x.k);
		
		if(comp>0) {
			return get(x.rightchild,k);
			
		}
		
		else if(comp<0) {
			return get(x.lefchild,k);
		}
		
		else {
			return x;
		}
	}
	
	public K getMinimo() {
		return getMinimo(root).k;
	}
	
	private Nodo getMinimo(Nodo x) {
		
		if(x.lefchild==null) {
			return x;
		}
		
		return getMinimo(x.lefchild);
	
	}
	
	public K getMaximo() {
		return getMaximo(root).k;
	}
	
	
	private Nodo getMaximo(Nodo x) {
		
		if(x.rightchild==null) {
			return x;
		}
		
		return getMaximo(x.rightchild);
	}
	
	
	
	private void cambiarColores(Nodo x) {
		
		x.color=RED;
		x.lefchild.color=BLACK;
		x.rightchild.color=BLACK;
		
	}
	
	public int rank(K k) {
		
		if(root==null) {
			return -1;
		}
		
		return rank(root,k);
	}
	
	private int rank(Nodo x,K k) {
		
		if(x==null) {
			return 0;
		}
		
		int comp=k.compareTo(x.k);
		
		if(comp<0) {
			return rank(x.lefchild,k);
		}
		
		else if(comp>0) {
			return 1+size(x.lefchild)+rank(x.rightchild,k);
		}
		else {
			return size(x.lefchild);
		}
		
	}
	
	public Iterable<K> lista(){
		
		return lista(getMinimo(),getMaximo());
		
	}
	
	public Iterable<K> lista(K min,K max){
		
		Queue<K> cola= new Queue<K>();
		
		lista(root,cola,min,max);
		
		return cola;
	}
	
	private void lista(Nodo x,Queue q,K min,K max) {
		
		if(x==null) {
			return;
		}
		
		int compMin=min.compareTo(x.k);
		int compMax=max.compareTo(x.k);
		
		if(compMin<0) {
			lista(x.lefchild,q,min,max);
		}
		
		if(compMin<=0 && compMax>=0) {
			q.enqueue(x.k);
		}
		
		if(compMax>0) {
			lista(x.rightchild,q,min,max);
		}
		
		
	}
	
	public int heigth() {
		return heigth(root)-1;
	}
	
	private int heigth(Nodo x) {
		
		if (x== null) {
			return 0;
		}
		
		int i=1+heigth(x.lefchild);
		int j=1+heigth(x.rightchild);
		
		return Math.max(i, j);
		

	}
	
	
	

	public static void main(String[] args) {

		int arbolsize=10000;
		
		SecureRandom random=new SecureRandom();
		
		TopDown2_3_4_Trees<Integer,Integer> arbol=new TopDown2_3_4_Trees<>();
		
		
//		arbol.put(5, 5);
//		arbol.put(1, 1);
//		arbol.put(9, 9);	
//		arbol.put(2, 2);
//		arbol.put(0, 2);
//		arbol.put(99, 2);
//		arbol.put(-1, 2);
//		arbol.put(-2, 2);
//		arbol.put(3, 2);
//		arbol.put(-5, 2);
		
		for(int i=0;i<arbolsize;i++) {
			
			int randomKey = random.nextInt(1000);
			arbol.put(randomKey, randomKey);
		}
		
		Queue<Integer> cola= (Queue<Integer>) arbol.lista();
		
		for(Integer i:cola) {
			
			System.out.print(i+ " ");
		}
		System.out.println();
		
		System.out.println(arbol.heigth());
		
		
	}

}
