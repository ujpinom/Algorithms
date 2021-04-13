package searching;

import java.util.Iterator;

import edu.princeton.cs.algs4.Merge;
import edu.princeton.cs.algs4.Queue;


public class BinarySearchSTItem <K extends Comparable<K>,V > implements Iterable<K> {

	private Item item[];
	private int N=0;
	private final int capaciad_por_defecto=2;
	class Item implements Comparable<Item>{
		
		K key;V value;
		
		Item(K key,V value) {
			this.key=key;
			this.value=value;
		}

		@Override
		public int compareTo(Item o) {
			
			if(this.key.compareTo(o.key)<1)
			{
				return -1;
			}
			
			else if (this.key.compareTo(o.key)>1) {
				return 1;
			}
			else 
				return 0;
		}

	}
	
	@SuppressWarnings("unchecked")
	public BinarySearchSTItem(int  capacidad) {
		this.item=new BinarySearchSTItem.Item[capacidad];
	}
	public BinarySearchSTItem() {
		
		this.item=new BinarySearchSTItem.Item[capaciad_por_defecto];
	}
	
	
	
	
	public BinarySearchSTItem(Item [] item) {
		
		Merge.sort(item);
		this.item=item;
		N+=item.length;
	}
	
	
	public int size() {
		return N;
	}
	
	public boolean isEmpty() {
		return N==0;
	}
	
	public void put(Item item) {
		
		put(item.key,item.value);
		
	}
	
	public void put(K k,V v) {
		
		if(v==null && contiene(k)) {
			borrar(k);
			return;
		}
	
		int j=rank(k);
		
		if(j<N  && k.compareTo(item[j].key)==0) {
			item[j].value=v;
			return;
		}
		
		if(item.length==N) {
			resize(item.length*2);
		}

		
		for(int i=N;i>j;--i) {
			
			item[i]=item[i-1];
			
		}
		
		item[j]=new Item(k,v);
		++N;
	}
	
	public void resize(int size) {
		
		Item[] temp= new BinarySearchSTItem.Item[size];
		
		for(int i=0;i<size();i++) {
			
			temp[i]=item[i];
			
		}
		
		item=temp;
		
		
	}
	
	public int rank(K k) {
		
		int low=0;
		int high=N-1;
		int medio=0;
		
		while(high>=low) {
			
			medio=low+(high-low)/2;
			
			int comp=item[medio].key.compareTo(k);
			
			if(item[medio].key.compareTo(k)<0) {
				low=medio+1;
				
			}
			else if(item[medio].key.compareTo(k)>0) {
				high=medio-1;
			}
			
			else 
				return medio;
	
		}
		
		return low;

	}
	

	public boolean contiene(K k) {
		
		return get(k)!=null;
	}
	
	public V get(K k) {
		
		if(k==null) {
			throw new IllegalArgumentException("El valor de busqueda no puede ser nulo");
		}
		
		if(isEmpty()) {
			return null;
		}
		
		int j = rank(k);
		
		if(j<N && item[j].key.compareTo(k)==0) {
			return item[j].value;
		}
		else 
			return null;
	
		
	}
	
	public void borrar(K k) {
		
		if(k==null) {
			throw new IllegalArgumentException("El valor de busqueda no puede ser nulo");
		}
		
		if(isEmpty() || !contiene(k)) {
			return;
		}
		
		int j= rank(k);
		
		
		if(j<N && item[j].key.compareTo(k)==0) {
			
			for(int i=j;i<size()-1;i++) {
				item[i]=item[i+1];
				
			}
			
			item[N-1]=null;
			--N;
		}
		
		
	}

	
	public static void main(String[] args) {
		
		BinarySearchSTItem.Item[] items=new BinarySearchSTItem.Item[5];
		
		
		  	items[0] = new BinarySearchSTItem().new Item(5, "Value 5");
	        items[1] = new BinarySearchSTItem().new Item(1, "Value 1");
	        items[2] = new BinarySearchSTItem().new Item(9, "Value 9");
	        items[3] = new BinarySearchSTItem().new Item(2, "Value 2");
	        items[4] = new BinarySearchSTItem().new Item(0, "Value 0");
		
	        
	        BinarySearchSTItem<Integer, String> lista= new BinarySearchSTItem<>(items);
	        
	        System.out.println(lista.size());
	        
	        lista.put(99,"Hola perro");
	        lista.put(99,"Hola perro");
	        lista.put(99,"Hola perro");
	        lista.put(99,"Hola perro");


	}
	
	
	public Iterable<Item> lista(){
		Queue<Item> cola= new Queue<Item>();
		
		for(int i=0;i<size();i++) {
			cola.enqueue(item[i]);
		}
		
		return cola;
		
	}

	@Override
	public Iterator<K> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	

}
