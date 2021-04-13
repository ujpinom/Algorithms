package searching;

import java.security.SecureRandom;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;
import searching.BinarySearchTree.Nodo;

public class RedBlackTree<K extends Comparable<K>,V> {
	
	private static final boolean RED=true;
	private static final boolean BLACK=false;
	private Nodo root;
	private Nodo ultimoAcceso;
	private class Nodo{
		
		K key;
		V value;
		Nodo leftChild;
		Nodo rightChild;
		boolean color;
		int N;
		
		Nodo(K key,V value,boolean color,int N){
			
			this.color=color;
			this.key=key;
			this.value=value;
			this.N=N;
			
		}

	}
	
	private boolean isRed(Nodo x) {
		
		if(x==null) {
			return false;
		}
		
		if(x.color==RED) {
			return true;
		}
		else {
			return false;
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
	
	
	private Nodo rotarIzquierda(Nodo h) {
		
		Nodo x= h.rightChild;
		h.rightChild=x.leftChild;
		x.leftChild=h;
		x.color=h.color;
		h.color=RED;
		x.N=h.N;
		h.N=1+size(h.leftChild)+size(h.rightChild);
		return x;
		
	}
	
	
	private Nodo rotarDerecha(Nodo h) {
		
		Nodo x= h.leftChild;
		h.leftChild=x.rightChild;
		x.rightChild=h;
		x.color=h.color;
		h.color=RED;
		x.N=h.N;
		h.N=1+size(h.leftChild)+size(h.rightChild);
		return x;

	}
	
	private void cambiarColor(Nodo h) {
		
		h.color=RED;
		h.leftChild.color=BLACK;
		h.rightChild.color=BLACK;
	}
	
	public void put(K k, V v) {
				
		root=put(root,k,v);
		
		root.color=BLACK;
		
		
	}
	
	private Nodo put(Nodo h, K k, V v) {
		
		if(h==null) {
			
			Nodo temp= new Nodo(k,v,RED,1);
			ultimoAcceso=temp;
			
			return temp;
		}
		
		int comp=k.compareTo(h.key);
		
		if(comp<0) {
			
			h.leftChild=put(h.leftChild,k,v);		}
		else if(comp>0) {
			h.rightChild=put(h.rightChild,k,v);
		}
		else {
			h.value=v;
			ultimoAcceso=h;
		}
		
		if(isRed(h.rightChild)&& !isRed(h.leftChild)) {
			h=rotarIzquierda(h);
		}
		
		if(isRed(h.leftChild)&& isRed(h.leftChild.leftChild)) {
			h=rotarDerecha(h);
		}
		
		if(isRed(h.leftChild)&& isRed(h.rightChild)) {
			cambiarColor(h);
		}
		
		h.N=size(h.leftChild)+size(h.rightChild)+1;
		return h;
	}
	
	public V get(K k) {
		
		if(k==null) {
			throw new IllegalArgumentException("Valor nulo no permitido");
		}
		
		if(ultimoAcceso!=null && k.compareTo(ultimoAcceso.key)==0) {
			
			return ultimoAcceso.value;
		}
		
		
		
		return get(root,k).value;
	}
	
	
	public boolean is23() {
		
		
		if(root==null) {
			return true;
		}
		
		return is23(root);
		
		
	}
	
	private boolean is23(Nodo x) {
		
		
		if((isRed(x.leftChild)&& isRed(x.rightChild)) || isRed(x.rightChild)) {
			return false;
		}
		else if(isRed(x.leftChild)&&!isRed(x.rightChild)) {
			return true;
		}
		
		boolean comp1= is23(x.leftChild);
		boolean comp2=is23(x.rightChild);
		
		return comp1&& comp2;
		
		
	}
	
	
	
	
	
	
	private Nodo get(Nodo x,K k) {
		
		if(x==null) {
			return null;
		}
		
		int comp=k.compareTo(x.key);
		
		if(comp<0) {
			
			return get(x.leftChild,k);
			
		}
		
		else if(comp>0) {
			return get(x.rightChild,k);
		}
		
		else {
			ultimoAcceso=x;
			return x;
		}
			
	}
	
	public K getMinimo() {
		
		if(root==null) {
			return null;
		}
		
		return getMinimo(root).key;
		
	}
	
	private Nodo getMinimo(Nodo x) {
		
		if(x.leftChild==null) {
			return x;
		}
		
		return getMinimo(x.leftChild);

	}
	
	public K getMaximo() {
		if(root==null) {
			return null;
		}
		
		return getMaximo(root).key
				;
		
	}
	
	private Nodo getMaximo(Nodo x) {
		
		if(x.rightChild==null) {
			return x;
		}
		
		return getMaximo(x.rightChild);
		
	}
	
	public K select(int k) {
		
		return select(root,k).key;
		
	}
	
	private Nodo select(Nodo x,int k) {
		
		if(x==null) {
			return null;
		}
		
		int t= size(x.leftChild);
		
		if(t>k) {
			
			return select(x.leftChild,k);
			
		}
		else if(t<k) {
			
			return select(x.rightChild,k-t-1);
			
		}
		else {
			return x;
		}
		
		
	}
	
	public K floor(K key)
	{
	Nodo x = floor(root, key);
	if (x == null) return null;
	return x.key;
	}
	
	private Nodo floor(Nodo x, K key)
	{
		
		if (x == null) return null;
		
	int cmp = key.compareTo(x.key);
	if (cmp == 0) return x;
	if (cmp < 0) return floor(x.leftChild, key);
	Nodo t = floor(x.rightChild, key);
	if (t != null) return t;
	else return x;
	
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
		
		int comp=k.compareTo(x.key);
		
		if(comp>0) {
			
			return size(x.leftChild)+1+rank(x.rightChild,k);
		}
		else if(comp<0) {
			return rank(x.leftChild,k);
		}
		else {
			return size(x.leftChild);
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
		int j=1+heigth(x.rightChild);
		
		return Math.max(i, j);
		

	}
	
	public boolean isBalanced() {
		
		
		Nodo actual=root.leftChild;
		int blackNodos=0;
		
		while(actual!=null) {
			
			if(!isRed(actual)) {
				blackNodos++;
			}
			
			actual=actual.leftChild;
			
			
		}
		
		return isBalanced(root,blackNodos+1);
	
	}
	
	
	public boolean isBalanced(Nodo x,int blackNodos) {
		
		if(x==null) {
			return blackNodos==0;
		}
		
		if(!isRed(x)){
			blackNodos--;
		}
		
		
		return isBalanced(x.leftChild,blackNodos) && isBalanced(x.rightChild,blackNodos);
		
		
		
	}
	
	
	
	public Iterable<K> getLista(){
		
		
		return getLista(getMinimo(),getMaximo());
		
	}
	
	public Iterable<K> getLista(K min,K max){
		
		Queue<K> cola= new Queue<>();
		
		getLista(root,cola,min,max);
		
		return cola;
		
	}
	
	private void getLista(Nodo x,Queue cola,K min,K max) {
		
			if(x==null) {
				return;
			}
			
			int c1=min.compareTo(x.key);
			int c2=max.compareTo(x.key);
			
			if(c1<0) {
				
				getLista(x.leftChild,cola,min,max);
			}
			
			if(c1<=0 && c2>=0) {
				cola.enqueue(x.key);
			}
		
			
			if(c2>0) {
				
				getLista(x.rightChild,cola,min,max);
				
			}
	}
	
	
	
	public void deletMin() {
		
		if(!isRed(root.leftChild) && ! isRed(root.rightChild)) {
			
			root.color=RED;
			
		}
		
		root=deletMin(root);
		
		if(!isEmpty()) {
			root.color=BLACK;
		}
		
		
	}
	
	
	private Nodo moverNodoRed(Nodo h) {
		
			cambiarColores(h);
			
			if(isRed(h.rightChild.leftChild)) {
				
				h.rightChild=rotarDerecha(h.rightChild);
				
				h=rotarIzquierda(h);
				
				
			}
			
			return h;
	}
	
	
	private Nodo deletMin(Nodo h) {
		
		if(h.leftChild==null) {
			return null;
		}
		
		if(!isRed(h.leftChild) && !isRed(h.leftChild.leftChild)) {
			
			h=moverNodoRed(h);
			
		}
		
		h.leftChild=deletMin(h.leftChild);
		
		return balance(h);
		
		
	}
	
	
	private Nodo balance(Nodo x) {
		
		if(x==null) {
			return null;
		}
		
		
		if(!isRed(x.leftChild)&& isRed(x.rightChild)) {
			
			x=rotarIzquierda(x);
			
		}
		
		if(isRed(x.leftChild)&& isRed(x.leftChild.leftChild)) {
			
			x=rotarDerecha(x);
			
		}
		
		if(isRed(x.rightChild) && isRed(x.leftChild)) {
			
			cambiarColores(x);
		}
		
		
		x.N=1+size(x.leftChild)+size(x.rightChild);
		
		return x;
		
		
	}
	
	
	public void deleteMax() {
		
		if(!isRed(root.leftChild)&& !isRed(root.rightChild)) {
			
			root.color=RED;
			
		}
		
		root=deleteMax(root);
		
		if(!isEmpty()) {
			
			root.color=BLACK;
		}
		
	}
		
		
	private Nodo deleteMax(Nodo h) {
		
		if(isRed(h.leftChild)) {
			
			h=rotarDerecha(h);
			
		}
	
		if(h.rightChild==null) {
			         return null;
		}
		
		if (!isRed(h.rightChild) && !isRed(h.rightChild.leftChild))
			h = moveRedRight(h);
			h.rightChild = deleteMax(h.rightChild);
			return balance(h);
	
		
	}
	
	private Nodo moveRedRight(Nodo h) {
		
		cambiarColores(h);
		if (!isRed(h.leftChild.leftChild))
		h = rotarDerecha(h);
		return h;
		
	}
	

	private void cambiarColores(Nodo h) {
		
		if(h!=null) {
			
			h.color=!h.color;
			
			if(h.leftChild!=null) {
				
				h.leftChild.color=!h.leftChild.color;
			}
			
			if(h.rightChild!=null) {
				h.rightChild.color=!h.rightChild.color;
			}

		}
	
	}
	
	public void delete(K key)
	{
		if (!isRed(root.leftChild) && !isRed(root.rightChild))
			root.color = RED;
			root = delete(root, key);
		if (!isEmpty()) root.color = BLACK;
	}
	
	
	private Nodo delete(Nodo h, K key)
	{
	if (key.compareTo(h.key) < 0)
	{
	if (!isRed(h.leftChild) && !isRed(h.leftChild.leftChild))
	h = moverNodoRed(h);
	h.leftChild = delete(h.leftChild, key);
	}
	else
	{
	if (isRed(h.leftChild))
	h = rotarDerecha(h);
	if (key.compareTo(h.key) == 0 && (h.rightChild == null))
	return null;
	if (!isRed(h.rightChild) && !isRed(h.rightChild.leftChild))
	h = moveRedRight(h);
	if (key.compareTo(h.key) == 0)
	{
	h.value = get(h.rightChild, getMinimo(h.rightChild).key).value;
	h.key = getMinimo(h.rightChild).key;
	h.rightChild = deletMin(h.rightChild);
	}
	else h.rightChild = delete(h.rightChild, key);
	}
	return balance(h);
	}
	
	
	public boolean isEmpty() {
		
		if(root==null) {
			return true;
		}
		
		return root.N==0;
		
	}
	
	
	
	
	
	public static void main(String a[]) {
		
	        RedBlackTree<Integer, Integer> redBlackBST = new RedBlackTree<>();
	        
	        redBlackBST.put(10, 10);
	        redBlackBST.put(4, 4);
	        redBlackBST.put(6, 6);
	        redBlackBST.put(1, 1);
	        redBlackBST.put(2, 2);
	        redBlackBST.put(15, 15);
	        redBlackBST.put(12, 12);
	        
	        
	        
	        

	            for(Integer key : redBlackBST.getLista()) {
	                StdOut.println(key);
	            }

	   
	            redBlackBST.delete(6);
	            
	            for(Integer key : redBlackBST.getLista()) {
	                StdOut.println(key);
	            }
	        
	        
//	        RedBlackTreeCertification.put("S", "s");
//	        RedBlackTreeCertification.put("E", "s");
//	        RedBlackTreeCertification.put("A", "s");
//	        RedBlackTreeCertification.put("R", "s");
//	        RedBlackTreeCertification.put("C", "s");
//	        RedBlackTreeCertification.put("H", "s");
//	        RedBlackTreeCertification.put("X", "s");
//	        RedBlackTreeCertification.put("M", "s");
//	        RedBlackTreeCertification.put("P", "s");
//	        RedBlackTreeCertification.put("L", "s");
//	        
//	        System.out.println(RedBlackTreeCertification.isBalanced());

//	        RedBlackTree.Nodo root = new RedBlackTree().new Nodo(10, "Value 10", false, 7);
//	        root.leftChild = new RedBlackTree().new Nodo(5, "Value 5", true, 4);
//	        root.leftChild.leftChild = new RedBlackTree().new Nodo(2, "Value 2", false, 1);
//	        root.leftChild.rightChild = new RedBlackTree().new Nodo(9, "Value 9", false, 2);
//	        root.leftChild.rightChild.leftChild = new RedBlackTree().new Nodo(7, "Value 7", true, 1);
//
//	        root.rightChild = new RedBlackTree().new Nodo(14, "Value 14", false, 2);
//	        root.rightChild.leftChild = new RedBlackTree().new Nodo(11, "Value 11", true, 1);
//
//	        StdOut.println("Test 1");
//	        StdOut.println(RedBlackTreeCertification.is23(root) + " Expected: true");
//	        StdOut.println(RedBlackTreeCertification.isBalanced(root, 2) + " Expected: true");
//	
//	        
//	        RedBlackTree.Nodo root2 = new RedBlackTree().new Nodo(20, "Value 20", false, 7);
//	        root2.leftChild = new RedBlackTree().new Nodo(5, "Value 5", true, 4);
//	        root2.leftChild.leftChild = new RedBlackTree().new Nodo(2, "Value 2", false, 1);
//	        root2.leftChild.rightChild = new RedBlackTree().new Nodo(9, "Value 9", false, 2);
//	        root2.leftChild.rightChild.leftChild = new RedBlackTree().new Nodo(1, "Value 1", true, 1); //Not a BST
//
//	        root2.rightChild = new RedBlackTree().new Nodo(24, "Value 24", false, 2);
//	        root2.rightChild.leftChild = new RedBlackTree().new Nodo(21, "Value 21", true, 1);
//
//	        StdOut.println("Test 2");
//	        StdOut.println(RedBlackTreeCertification.is23(root2) + " Expected: true");
//	        StdOut.println(RedBlackTreeCertification.isBalanced(root2, 2) + " Expected: true");
//		
//	        
//	        RedBlackTree.Nodo root3 = new RedBlackTree().new Nodo(10, "Value 10", false, 7);
//	        root3.leftChild = new RedBlackTree().new Nodo(5, "Value 5", true, 4);
//	        root3.leftChild.leftChild = new RedBlackTree().new Nodo(2, "Value 2", false, 1);
//	        root3.leftChild.rightChild = new RedBlackTree().new Nodo(9, "Value 9", false, 2);
//	        root3.leftChild.rightChild.leftChild = new RedBlackTree().new Nodo(7, "Value 7", true, 1);
//
//	        root3.rightChild = new RedBlackTree().new Nodo(14, "Value 14", true, 2); //Not 2-3 tree, not balanced
//	        root3.rightChild.leftChild = new RedBlackTree().new Nodo(11, "Value 11", true, 1);
//
//	        StdOut.println("Test 3");
//	        StdOut.println(RedBlackTreeCertification.is23(root3) + " Expected: false");
//	        StdOut.println(RedBlackTreeCertification.isBalanced(root3, 2) + " Expected: false");
	}
	
}
