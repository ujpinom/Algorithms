package searching;

import edu.princeton.cs.algs4.Queue;

public class SeparateChaining<K,V> {
	
	
	private int N;
	private int M;
	
	private SequentialSearch<K ,V>[] arreglos_listas;
	
	
	public SeparateChaining() {
		this(997);
	}
	
	public SeparateChaining(int M) {
		
		this.M=M;
		
		arreglos_listas=(SequentialSearch<K,V>[]) new SequentialSearch[M];
		
		
		for(int i=0;i<M;i++) {
			arreglos_listas[i]=new SequentialSearch<>();
		}
		
		
	}
	
	private int hash(K k) {
		return (k.hashCode() & 0x7fffffff) % M; 

	}
	
	public void put(K k, V v) {
		
		if(k==null) {
			throw new IllegalArgumentException("Argumento nulo no permitido");
		}
		
		if(v==null) {
			
			if(!contains(k)) {
				return;
			}
			
			else {
				
				borrar(k);
				return;
				
			}
			
		}
		
		int i=hash(k);
		
		arreglos_listas[i].put(k, v);
		
		if(arreglos_listas[i].esta!=1) {
			
			N++;
			
		}
		
		arreglos_listas[i].esta=0;
		
	}
	
	
	public boolean contains(K k) {
		
		return get(k)!=null;
		
	}
	
	public void borrar(K k) {
		
		if(k==null) {
			throw new IllegalArgumentException("Argumento nulo no permitido");
		}
		
		if(!contains(k)) {
			return;
		}
		
		
		int i=hash(k);
		
		N-=arreglos_listas[i].size();
		
		arreglos_listas[i].delete(k);
		
		N+=arreglos_listas[i].size();

	}
	

	
	public V get(K k) {
		
		if(k==null) {
			throw new IllegalArgumentException("Argumento nulo no permitido");
		}
		
		int i=hash(k);
		
		return arreglos_listas[i].get(k);
	}
	
	public Iterable<K> lista(){
		
		Queue<K> cola = new Queue<>();
		
		for(int i=0;i<M;i++) {
			
			for(SequentialSearch.Node x=arreglos_listas[i].first;x!=null;x=x.next) {
				
				cola.enqueue((K)x.key);		
				
			}
			
		}
		
		return cola;
	
	}
	
	public int size() {
		return N;
	}
	

	public static void main(String[] args) {
		
		SeparateChaining<String,Integer> hash=new SeparateChaining<>();
		
		hash.put("S", 2);
		hash.put("E", 2);
		hash.put("A", 2);
		hash.put("R", 2);
		hash.put("C", 2);
		hash.put("H", 2);
		hash.put("E", 2);
		hash.put("X", 2);
		hash.put("A", 2);
		hash.put("M", 2);
		hash.put("P", 2);
		hash.put("L", 2);
		hash.put("E", 2);
		
		
		for(String s: hash.lista()) {
			
			System.out.print(s+" ");
		}
		
		System.out.println();
		System.out.println(hash.size());
		
		hash.borrar("E");
		hash.borrar("X");
		
		for(String s: hash.lista()) {
			
			System.out.print(s+" ");
		}
		
		System.out.println();
		
		
		System.out.println(hash.size());

		hash.put("E",1);
		hash.put("X",1);
		
		System.out.println(hash.size());
		
		
		
		
		
	}

}
