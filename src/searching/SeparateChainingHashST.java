package searching;

import edu.princeton.cs.algs4.Queue;

public class SeparateChainingHashST  <K ,V> {
	
	
	
	private int N;
	private int M;
	private Nodo[] nodos;
	
	
	class Nodo{
		
		private K k;
		private V v;
		private Nodo siguiente;
		private Nodo first;
		
		
		Nodo(K k,V v, Nodo siguiente){
			
			this.k=k;
			this.v=v;
			this.siguiente=siguiente;
			
			
		}
		
	}
	
	public SeparateChainingHashST() {
		this(997);
	}

	@SuppressWarnings("unchecked")
	public SeparateChainingHashST(int M) {
		
		this.M=M;
		this.nodos=(SeparateChainingHashST.Nodo[])new SeparateChainingHashST.Nodo[M];
		
		for(int i=0;i<M;i++) {
			
			nodos[i]= new Nodo(null, null,null);
		}
		
		
		
	}
	
	
	private int hash(K k) 
	{ return (k.hashCode() & 0x7fffffff) % M; }
	
	
	
	public void put(K key, V val) {
		
		  if (key == null) throw new IllegalArgumentException("El primer argumento ingresado es null"); 
	        if (val == null) {
	            return;
	        }
	        
	        int hash=hash(key);
	        
	        for(Nodo x=nodos[hash].first;x!=null;x=x.siguiente) {
	        	
	        	
	        	if(key.equals(x.k)) {
	        		
	        		x.v=val;
	        		return;
	        	}
	    
	        }

	        nodos[hash].first=new Nodo(key,val,nodos[hash].first);
	        ++N;
		
	}
	
	public V get(K key) {
		
		if (key == null) throw new IllegalArgumentException("Argumento ingresado es null"); 
		
		int hash=hash(key);
		
	    for(Nodo x=nodos[hash].first;x!=null;x=x.siguiente) {
        	
        	
        	if(key.equals(x.k)) {
        		
        		return x.v;
        	}
    
        }
	    
	    return null;
		
	}
	
	public int size() {
		return N;
	}
	
	public Iterable<K> lista(){
		
		
		Queue<K> cola= new Queue<>();
		
		for(int i=0;i<M;i++) {
			
			if(nodos[i]!=null) {
				
				for(Nodo x=nodos[i].first;x!=null;x=x.siguiente) {
					
					cola.enqueue(x.k);
					
				}
			}
			
		}
		
		return cola;
		
	}
	
	public void borrar(K k) {
		
		if(k==null) {
			throw new IllegalArgumentException("Argumento nulo no permitido");
		}
		
		if(!contiene(k)) {
			return;
		}
		
		int hash=hash(k);
		
		nodos[hash].first= borrar(nodos[hash].first,k);
		
		
		
	}
	
	private Nodo borrar(Nodo x, K k) {
		
		if(x==null) {
			return null;
		}
		
		if(k.equals(x.k)) {
			--N;
			return x.siguiente;
		}
		
		x.siguiente=borrar(x.siguiente,k);
		return x;
		
	}
	
	
	public boolean contiene(K k) {
		
		if(get(k)!=null) {
			return true;
		}
		
		return false;
	}
	
	
	public static void main(String[] a) {
		
		SeparateChainingHashST<String,Integer> hash=new SeparateChainingHashST<>(16);
		
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
			System.out.print(s+ " ");
		}
		
		
		hash.borrar("L");
		System.out.println();
		
		for(String s: hash.lista()) {
			System.out.print(s+ " ");
		}
		
	
	}
	
	
	
	

}
