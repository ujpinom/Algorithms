package searching;

import java.util.Iterator;

import edu.princeton.cs.algs4.Merge;
import edu.princeton.cs.algs4.Queue;

public class BinarySearchST <K extends Comparable <K>,V> implements Iterable<K> {
	
	private K[] keys;
	private V[] valores;
	private int N;
	private  Item [] item; 
	
	public BinarySearchST(int capacidad) {
		
		keys= (K[]) new Comparable[capacidad];
		valores=(V[]) new Object[capacidad];
		
	}
	
	
	private class Item implements Comparable<Item> {

		
		K key; V value;
		
		Item(K key,V value) {
			
			this.key=key;
			this.value=value;
		}

		@Override
		public int compareTo(Item o) {
			
			if(this.key.compareTo(o.key)<1) {
				return -1;
			}
			else if(this.key.compareTo(o.key)>1) {
				return 1;
			}
			else
				return 0;
		}

		
	}
	
	
	
	public BinarySearchST(Item[] item) {
		
		this.item=item;
		
		Merge.sort(item);
		
	}

	/**
	 * 
	 * @return El número de pares K-V presentes simultaneamente en los arreglos
	 */
	public int size() {
		return N;
	}
	
	/**
	 * 
	 * @param key parámetro de busqueda.
	 * @return Retorna el valor asociado al parámetro de busqueda si este último existe en la tabla, de lo contrario retorna {@code null}
	 */
	
	
	public V get(K key) {
		
		if(isEmpty())return null;
		
		int i=rank(key);
		
		if(i<N && keys[i].compareTo(key)==0) {
			return valores[i];
		}
		else return null;
		
	}
	
	
	/**
	 * 
	 * @return Retorna {@code true} si la tabla de símbolos está vacía. Retorna {@code false} en caso contrario. 
	 */
	
	public boolean isEmpty() {
		return N==0;
	}
	
	
	public int rank(K key) {
		
		int low=0;int high=N-1;
		
		while(high>=low) {
			
			int medio=low+(high-low)/2;
			
			int comparacion= key.compareTo(keys[medio]);
			
			if(comparacion>0) {
				low=medio+1;
			}
			else if(comparacion<0) {
				high=medio-1;
			}
			else return medio;
			
			
		}
		
		return low;
		
	}
	
	
	public void put(K key,V value) {
		
		int i= rank(key);
		
		if(i<N&& key.compareTo(keys[i])==0) {
			valores[i]=value;
			return;
		}
		
		for(int j=N;j>i;--j) {
			
			keys[j]=keys[j-1];
			valores[j]=valores[j-1];
		
		}
		
		keys[i]=key;
		valores[i]=value;
		++N;
	}
	
	public K max() {
		return keys[N-1];
	}
	
	public K min() {
		return keys[0];
	}
	
	public K ceiling(K key) {
		int i= rank(key);
		return keys[i];
	}
	
	
	public K floor(K key) {
		int i= rank(key);
		
		return keys[i];
	}
	
	public boolean contains(K key) {
		
		return get(key)!=null;
		
	}


	public Iterable<K> keys(){
		
		  Queue<K> queue = new Queue<K>();
	        for (int x=0;x<N;x++)
	            queue.enqueue(keys[x]);
	        return queue;
		
	}
	
	
	
	@Override
	public Iterator<K> iterator() {
		// TODO Auto-generated method stub
	
		return new recorrerLista();
	}
	
	private class recorrerLista implements Iterator<K>{

		int i=N;
		
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return i>0;
		}

		@Override
		public K next() {
			// TODO Auto-generated method stub
			return keys[i--];
			
		}
		
	}
	
}
	