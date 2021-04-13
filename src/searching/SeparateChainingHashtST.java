package searching;


public class SeparateChainingHashtST<K extends Comparable<K>, V> {
	
	
	private int N; //Numero de pares K-V;
	
	private int M; // Tamaño de la tabla hash;
	
	private SequentialSearch<K, V> [] st;
	
	public SeparateChainingHashtST() {
		this(997);
	}
	
	

	@SuppressWarnings("unchecked")
	public SeparateChainingHashtST(int M) {
		
		this.M=M;
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
		
		SequentialSearch<K,V> temp=st[hash(k)];
		
		temp.put(k, v);
		
		if(temp.esta!=1) {
			N+=temp.size();
		}
		temp.esta=0;
		
	
	
	}
	
	public int size() {
		return N;
	}
	

	public static void main(String[] a) {
		
		SeparateChainingHashtST<String,Integer> hash=new SeparateChainingHashtST<>();
		
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
		
		System.out.println(hash.size());
	
	}
}
