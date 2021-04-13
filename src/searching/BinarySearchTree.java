package searching;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

import java.security.SecureRandom;
public class BinarySearchTree<K extends Comparable<K>,V> {
	

	private Nodo root;
	
	public BinarySearchTree() {
		
	}
	
	
	public void put(K k,V v) {
		
		root=put(root,k,v);
		
	}
	
	private Nodo put(Nodo x,K k,V v) {
		
		if(x==null) {
			return new Nodo(k,v,1);
		}
		
		int comp=k.compareTo(x.key);
		
		if(comp>0) {
			
			x.rightChild=put(x.rightChild,k,v);
		}
		
		else if(comp<0) {
			x.leftChild=put(x.leftChild,k,v);
		}
		else {
			x.value=v;
		}
		
		x.N=size(x.leftChild)+size(x.rightChild)+1;
		
		return x;
		
		
	}
	
	
	public K min() {
		
		Nodo min=min(root);
		return min.key;
		
	}
	
	
	private Nodo min(Nodo x) {
		
		if(x.leftChild==null) {
			return x;
		}
		return min(x.leftChild);
		
		
	}
	
	private  Nodo max(Nodo x) {
		
		if(x.rightChild==null) {
			return x;
		}
		
		return max(x.rightChild);
		
		
	}
	
	
	public K floor(K k) {
		
		Nodo x=floor(root,k);
		
		if(x.key==null) {
			return null;
		}
		return x.key;
	
		
	}
	
	private Nodo floor(Nodo x,K k) {
		
		if(x==null) {
			return null;
		}
		
		int comp=x.key.compareTo(k);
		
		if(comp==0) {
			return x;
		}
		
		if(comp<0) {
			return floor(x.rightChild,k);
		}
		
		Nodo t=floor(x.leftChild,k);
		
		if(t!=null) {
			return t;
		}
		
		return x;

	}

	public K max() {
		
		return max(root).key;
		
	}
	
	
	public V get(K k) {
		
		
		return get(root,k);
	}
	
	private V get(Nodo r,K k) {
		
		if(r==null) {
			return null;
		}
		
		int comp=k.compareTo(r.key);
		
		if(comp>0) {
			
			return get(r.rightChild,k);
			
		}
		else if(comp<0) {
			
			return get(r.leftChild,k);
		}
		else 
			return r.value;
		
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
	
	public K select(int k) {
		
		return select(root,k).key;
		
	}
	
	private Nodo select(Nodo x,int k ) {
		
		if(x==null ) return null;
		
		int t=size(x.leftChild);

		
		if(t>k) {
			
			return select(x.leftChild,k);
		}
		
		if(t<k) {
			return select(x.rightChild,k-t-1);
		}
		
		else {
			return x;
		}
	
	}
	
	public int rank(K k) {
		
		return rank(root,k);
	}
	
	
	private int rank(Nodo x,K k) {
		
		if(x==null) {
			return 0;
		}
		
		int comp=k.compareTo(x.key);
		
		if(comp>0) {
			
			return size(x.leftChild)+rank(x.rightChild,k)+1;
			
		}
		
		else if(comp<0) {
	
			return rank(x.leftChild,k);
			
		}
		
		else {
			
			return size(x.leftChild);
		}
		
	}
	
	
	public void borrarMin() {
		root= borrarMin(root);
	}
	 
	
	private Nodo borrarMin(Nodo x) {
		
		if(x.leftChild==null) {
			return x.rightChild;
		}
		
		x.leftChild=borrarMin(x.leftChild);
		
		x.N=size(x.leftChild)+size(x.rightChild)+1;
		
		return x;

	}
	
	public void borrarMax() {
		
		root=borrarMax(root);
		
	}
	
	private Nodo borrarMax(Nodo x) {
		
		if(x.rightChild==null) {
			return x.leftChild;
		}
		
		x.rightChild=borrarMax(x.rightChild);
		
		x.N=size(x.leftChild)+size(x.rightChild)+1;
		
		return x;
		
	}
	
	public void borrar(K k) {
		
		root=borrar(root,k);
	}
	
	
	private Nodo borrar(Nodo x,K k) {
		
		if(x==null) {
			return null;
		}
		
		int comp=k.compareTo(x.key);
		
		if(comp>0) {
			x.rightChild=borrar(x.rightChild,k);
		}
		
		else if(comp<0) {
			x.leftChild=borrar(x.leftChild,k);
		}
		
		else {
			
			if(x.rightChild==null) {
				return x.leftChild;
			}
			
			if(x.leftChild==null) {
				return x.rightChild;
			}
			
			Nodo t=x;
			
			x=min(t.rightChild);
			x.rightChild=borrarMin(t.rightChild);
			x.leftChild=t.leftChild;
			
		}
		
		x.N=size(x.leftChild)+size(x.rightChild)+1;
		return x;
		
	}
	
	public Iterable<K> lista(){
		
		return lista(min(),max());
		
	}
	
	public Iterable<K> lista(K min,K max){
		
		Queue<K> cola = new Queue<K>();
		
		lista(root,cola,min,max);
		
		return cola;
		
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
	
	
	public K randomKey() {
		
		SecureRandom random= new SecureRandom();
		
		int rand=random.nextInt(root.N);
		
		return select(rand);
	}
	

	
	
	private void lista(Nodo x,Queue q,K min,K max) {
		
		if(x==null) {
			return;
		}
		
		int compMin=min.compareTo(x.key);
		int compMax=max.compareTo(x.key);
		
		if(compMin<0) {
			lista(x.leftChild,q,min,max);
		}
		
		if(compMin<=0 && compMax>=0) {
			q.enqueue(x.key);
		}
		
		if(compMax>0) {
			lista(x.rightChild,q,min,max);
		}
	}
	
	public void clear() {
		root=null;
	}

	class Nodo{
		
		private int N;
		
		private K key;
		private V value;
		private Nodo leftChild;
		private Nodo rightChild;
		
		public Nodo(K key,V value, int N) {
			this.key=key;
			this.value=value;
			this.N=N;
		}
		
	}
	
    private static int totalHeights;

    private static void doExperiment() {
        int[] binaryTreeSizes = {10000, 100000};
        int numberOfExperiments = 100;

        for(int i = 0; i < binaryTreeSizes.length; i++) {
            totalHeights = 0;

            for(int j = 0; j < numberOfExperiments; j++) {
                computeBSTHeight(binaryTreeSizes[i]);
            }

            double averageBSTHeight = totalHeights / (double) numberOfExperiments;
            double expectedAverageBSTHeight = 2.99 * (Math.log(binaryTreeSizes[i]) / Math.log(2));

            StdOut.println("Experiments with N = " + binaryTreeSizes[i]);
            StdOut.printf("Average BST height: %.2f\n", averageBSTHeight);
            StdOut.printf("Expected average BST height: %.2f\n\n", expectedAverageBSTHeight);
        }
    }

    private static void computeBSTHeight(int treeSize) {
        int maxValue = 10000000;
        BinarySearchTree<Integer, Integer> binarySearchTree = new BinarySearchTree<>();

        for(int i = 0; i < treeSize; i++) {
            int randomValue = StdRandom.uniform(maxValue);
            binarySearchTree.put(randomValue, randomValue);
        }

        totalHeights += binarySearchTree.heigth();
    }

    public static void main(String[] args) {
    	doExperiment();
    }
		
}
