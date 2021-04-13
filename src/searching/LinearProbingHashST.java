package searching;

import edu.princeton.cs.algs4.Queue;

public class LinearProbingHashST <K,V> {
	
	private int N;
	private int M=16;
	private K [] keys;
	private V [] values;
	
	public LinearProbingHashST() {
		
		keys=(K[])new Object[M];
		
		values=(V[]) new Object [M];
		
	}
	
	public LinearProbingHashST(int M) {
		
		keys=(K[])new Object[M];
		
		values=(V[]) new Object [M];
		
		this.M=M;
		
	}
	
	
	
	private int hash(K k) {
		
		return (k.hashCode() & 0x7fffffff) % M; 
		
	}
	
	public void put(K k, V v) {
		
		if(N>=M/2) {
			resize(2*M);
		}
	
		int i;
		for(i=hash(k);keys[i]!=null;i=(i+1)%M) {
			
			if(keys[i].equals(k)){
				values[i]=v;
				return;
			}

		}
		
		keys[i]=k;
		values[i]=v;
		++N;
		
	}
	
	public int size() {
		return N;
	}
	
	
	private void resize(int tamanio) {
		
		LinearProbingHashST<K, V> t;
		t = new LinearProbingHashST<K, V>(tamanio);
		
		for(int i=0;i<M;i++) {
			
			if(keys[i]!=null) {
				t.put(keys[i], values[i]);
			}
		}
		
		keys=t.keys;
		values=t.values;
		M=t.M;
		
	}
	
	public V get(K k) {
		
			for(int i=hash(k);keys[i]!=null;i=(i+1)%M) {
				
				if(keys[i].equals(k)) {
					return values[i];
				}
				
			}
			
			return null;
	}
	
	public boolean  contains(K k) {
		
		if(get(k)!=null) {
			return true;
		}
		else {
			return false;
		}
		
		
	}
	
	
	public void borrar(K k) {
		
		if(!contains(k)) {
			return;
		}
		
		int i=hash(k);
		
		while(!k.equals(keys[i])){
			i=(i+1)%M;
		}
		
		keys[i]=null;
		values[i]=null;
		i=(i+1)%M;
		
		while(keys[i]!=null) {
			
			K r=keys[i];
			V v= values[i];
			
			keys[i]=null;
			values[i]=null;
			N--;
			put(r,v);
			i=(i+1)%M;
		
		}
		N--;
		
		if(N>0 && 	N==M/8)
			resize(M/2);
		
	}
	
	public Iterable<K> lista(){
		
		Queue<K> cola= new Queue<K>();
		
		
		for(int i=0;i<M;i++) {
			
			if(keys[i]!=null) {
				
				cola.enqueue(keys[i]);
				
			}
			
		}
		
		return cola;
		
	}
	
	
	
	

	public static void main(String[] args) {


		LinearProbingHashST<String, Integer> lr= new LinearProbingHashST<>();
		
		lr.put("S",1);
		lr.put("E",1);
		lr.put("A",1);
		lr.put("R",1);
		lr.put("C",1);
		lr.put("H",1);
		lr.put("E",1);
		lr.put("X",1);
		lr.put("A",1);
		lr.put("M",1);
		lr.put("P",1);
		lr.put("L",1);
		lr.put("E",1);
		
		System.out.println(lr.size());
		
		for(String s:lr.lista()) {
			
			System.out.print(s +" ");
		}
		
		lr.borrar("L");
		
		System.out.println(lr.size());
		
	for(String s:lr.lista()) {
			
			System.out.print(s +" ");
		}
		
		
		

	}

}
