package searching;

import edu.princeton.cs.algs4.StdOut;

public class LinearProbingHashSTLazyDelete <k,v> extends LinearProbingHashST<k,v> {
	
	protected int nulos=0;
	

	public LinearProbingHashSTLazyDelete() {
		super();
	}

	public LinearProbingHashSTLazyDelete(int M) {
		super(M);
	}
	
	@Override
	public void put(k k, v v) {
		
		if(k==null) {
			throw new IllegalArgumentException("Valor nulo no permitido");
			
		}
		
		if(contains(k) && v==null) {
			
			lazyDelete(k);
			return;

		}
	
		
		int hash=hash(k);
		
		int i;
		
		for(i=hash;keys[i]!=null;i=(i+1)%M) {
			
			if(k.equals(keys[i])) {
			
				if(values[i]==null) {
					
					values[i]=v;
					++N;
					--nulos;
					return;
					
				}
				
				values[i]=v;
				return;
	
			}
			
		}
		
		keys[i]=k;
		values[i]=v;
		
		++N;
		
		if(N+nulos>=M/(double)2) {
			resize(2*M);
		}
		
		
	}
	
	
	private void resize(int t) {
		 StdOut.println("Deleting tombstone items");
		LinearProbingHashSTLazyDelete <k,v> temp= new LinearProbingHashSTLazyDelete <k,v>(t);
		nulos=0;
		
		for(int i=0;i<M;i++) {
			
			if(values[i]!=null) {
				
				temp.put(keys[i], values[i]);
				
			}
			
		}
		
		keys=temp.keys;
		values=temp.values;
		M=temp.M;
	
	}
	
	@Override
	public void borrar(k k) {
		
		if(k==null) {
			throw new IllegalArgumentException("Valor nulo no permitido");
			
		}
		
		if(!contains(k)) {
			return;
		}
		
		lazyDelete(k);
		
	}
	
	private void lazyDelete(k k) {
		
		int hash=hash(k);
		
		while(!k.equals(keys[hash])) {
			
			hash=(hash+1)%M;
		}
		
		values[hash]=null;
		
		++nulos;
		N--;
		
		if(N<=M/(double)8) {
			resize(M/2);
		}
		
	
	}
	
	

	public static void main(String[] args) {
		
		LinearProbingHashSTLazyDelete<Integer,Integer> hash=new LinearProbingHashSTLazyDelete<>(16);
		
		
		for(int i=4;i<8;i++) {
			hash.put(i, i);
			
		}
		
		  	StdOut.println("\nLazy delete 3");
		  	hash.borrar(3);
	        StdOut.println("Lazy delete 4");
	        hash.borrar(4);
	        StdOut.println("Lazy delete 5");
	        hash.borrar(5);
	        StdOut.println("Put 3");
	        hash.put(3, 3);
	        StdOut.println("Lazy delete 6");
	        hash.borrar(6);
	        StdOut.println("Lazy delete 7");
	        hash.borrar(7);
	
	        
	        
	        for(Integer i: hash.lista()) {
	        	
	        	
	        	System.out.println(i +" ");
	        }
		
		

	}

}
