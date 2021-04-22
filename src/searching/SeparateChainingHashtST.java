package searching;

import edu.princeton.cs.algs4.Queue;

public class SeparateChainingHashtST<K extends Comparable<K>, V> {
	
    private final int[] PRIMES = {
            1, 1, 3, 7, 13, 31, 61, 127, 251, 509, 997,1021, 2039, 4093, 8191, 16381,
            32749, 65521, 131071, 262139, 524287, 1048573, 2097143, 4194301,
            8388593, 16777213, 33554393, 67108859, 134217689, 268435399,
            536870909, 1073741789, 2147483647
    };
	
	private int N; //Numero de pares K-V;
	
	private int M; // Tamaño de la tabla hash;
	
	private int probes;
	
	private int contador=0;
	
	private SequentialSearch<K, V> [] st;
	
	public SeparateChainingHashtST() {
		
		this.M=997;
		this.probes=2;
		this.st=(SequentialSearch<K, V>[] ) new SequentialSearch[M];
		
		for(int i=0;i<M;i++) {
			st[i]=new SequentialSearch<>();
		}
	
	}
	
	

	@SuppressWarnings("unchecked")
	public SeparateChainingHashtST(int M,int probes) {
		
		this.M=M;
		this.probes=probes;
		this.st=(SequentialSearch<K, V>[] ) new SequentialSearch[M];
		
		for(int i=0;i<M;i++) {
			st[i]=new SequentialSearch<>();
		}
		
		
	}
	

	
	private int hash(K key)
	{ return (key.hashCode() & 0x7fffffff) % M; }
	
	
	public V get(K k) {
		
		return (V)st[hash(k)].get(k);
	}
	
	public void put(K k,V v) {
		
		int hash=hash(k);
		System.out.println(hash);
	
		st[hash].put(k, v);
		

		if(st[hash].esta!=1) {
			N++;;
		}
		st[hash].esta=0;
		
		if(st[hash].size()>probes) {
			
	
			
			while(PRIMES[contador]<=M) {
				++contador;
			}
			
			M=PRIMES[contador];
			System.out.println("esta es "+M);
			
			resize(M);
			
		}

	}
	
	private void resize(int nuevo) {
		
		SequentialSearch<K, V> [] temp=(SequentialSearch<K, V>[])new SequentialSearch[nuevo];
		
		for(int i=0;i<nuevo;i++) {
			temp[i]=new SequentialSearch<>();
		}
		
		
		int size=st.length;
		
		for(int i=0;i<size;i++) {
			
			if(st[i]!=null) {
				
				for(SequentialSearch.Node x=st[i].first;x!=null;x=x.next) {
					
					int hash=hash((K)x.key);
					
					temp[hash].put((K)x.key, (V)x.val);

				}
				
			}
			
		}
		
		st=temp;
	
	}
	
	
	public Iterable<K> lista(){
		Queue<K> cola= new Queue<>();
		
		
		for(int i=0;i<M;i++) {
			
			if(st[i]!=null) {
				
				for(SequentialSearch.Node x=st[i].first;x!=null;x=x.next) {
					
					cola.enqueue((K) x.key);
					
				}
				
			}
			
		}
		
		return cola;
		
	}
	
	
	
	public void borrar(K k) {
		
		if(k==null) {
			throw new IllegalArgumentException("El argumento no puede ser nulo");
			
		}
		
		int hash=hash(k);
		
		if(!st[hash].contains(k)) {
			return;
		}
		
		N-=st[hash].size();
		
		st[hash].delete(k);
		
		N+=st[hash].size();
		
		
	}
	
	public int size() {
		return N;
	}
	

	public static void main(String[] a) {
		
		SeparateChainingHashtST<String,Integer> hash=new SeparateChainingHashtST<>(1,2);
		
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
		
		hash.borrar("L");
		hash.borrar("P");
		
		System.out.println();
		
		for(String s: hash.lista()) {
			
			System.out.print(s+" ");
		}
		
		System.out.println(hash.size());
		
		hash.put("P",2);
		hash.put("L",2);
		
		System.out.println(hash.size());
		
	for(String s: hash.lista()) {
			
			System.out.print(s+" ");
		}
	System.out.println();
	
	System.out.println(hash.M);
	
	
	}
	
	
}
