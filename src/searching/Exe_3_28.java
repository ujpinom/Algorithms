package searching;

import java.util.Iterator;

import edu.princeton.cs.algs4.Queue;
import edu.princeton.cs.algs4.Stopwatch;

public class Exe_3_28 <K extends Comparable<K>,V> implements Iterable<K> {
	
	
	private K [] keys;private V[] valores;
	private int size; private final int defecto=2;
	private K maximo_actual=null;
	
	
	public Exe_3_28(int capacidad) {
		
		keys=(K[])new Comparable[capacidad];
		valores=(V[])new Object[capacidad];
	
	}
	
	public Exe_3_28() {
		
		keys=(K[])new Comparable[defecto];
		valores=(V[])new Object[defecto];
	
	}
	
	
	public void put(K k,V v) {
		
		if(k==null) {
			throw new IllegalArgumentException("Argumento nulo no permitido");
		}
		
		if(v==null && contiene(k)) {
			borrar(k);
			--size;
			return;
		}
		
		if(size==keys.length) {
			resize(size*2);
		}

		if(maximo_actual!=null) {
			
			if(k.compareTo(maximo_actual)>0) {
				keys[size]=k;
				valores[size]=v;
				maximo_actual=k;
				++size;
				
				
			}
			else {
				int j= rank(k);
				
				if(j<size && keys[j].compareTo(k)==0) {
					
					valores[j]=v;
					return;
				}
				
				for(int i=size;i>j;i--) {
					
					keys[i]=keys[i-1];
					valores[i]=valores[i-1];
					
				}
				
				keys[j]=k;valores[j]=v;
				++size;

			}

		}
		else {
			
			keys[0]=k;
			valores[0]=v;
			maximo_actual=k;
			++size;
		}
		

	}
	
	public void resize(int t) {
		
		K[] temp=(K[]) new Comparable[t];
		V[] temp1=(V[]) new Object[t];
		
		for(int i=0;i<size();i++) {
			temp[i]=keys[i];
			temp1[i]=valores[i];

		}
		
		keys=temp;valores=temp1;
		
	}
	
	public boolean contiene(K k) {
		return get(k)!=null;
	}
	
	public V get(K k) {
		
		if(k==null) {
			throw new IllegalArgumentException("Argumento nulo no permitido");
		}
		
		if(k.equals(maximo_actual)) {
			return valores[size-1];
		}
		
		int j=rank(k);
		
		if(j<size && keys[j].compareTo(k)==0) {
			return valores[j];
		}
		
		return null;

	}
	
	public void borrar(K k) {
		
		if(k==null) {
			throw new IllegalArgumentException("Argumento nulo no permitido");
		}
		
		if(k.equals(maximo_actual)) {
			valores[size-1]=null;
			keys[size-1]=null;
			return;
		}
		
		int j=rank(k);
		
		if(j<size && keys[j].compareTo(k)==0) {
			
			for(int i=j;i<size-1;i++) {
				
				keys[i]=keys[i+1];
				valores[i]=valores[i+1];

			}
			
			keys[size-1]=null;valores[size-1]=null;
			--size;
			
		}
		
	}
	
	
	public int rank(K k) {
		
		int low=0;int high=size-1;
		int medio=0;
		
		while(low<=high) {
			
			medio=low+(high-low)/2;
			
			int comp=keys[medio].compareTo(k);
			
			if(comp<0) {
				
				low=medio+1;
			}
			else if(comp>0) {
				
				high=medio-1;
				
			}
			
			else 
				return medio;
			
			
		}
		
		return low;
		
	}
	
	
	public int size() {
		return size;
		
	}
	
	
	public boolean isEmpty() {
		return size==0;
	}
	
	public Iterable<K> lista(){
		
		Queue<K> cola= new Queue<K>();
		
		for(int i=0;i<size();i++) {
			cola.enqueue(keys[i]);
		}
		
		return cola;
	}
	
	
	

	public static void main(String[] args) {

		Exe_3_28<Integer,String> hola= new Exe_3_28<>();
		
		Stopwatch temp=new Stopwatch();
		
		
		for(int i=5000;i>=0;i--) {
			
			String valor= "Valor"+i;
			
			hola.put(i, valor);
			
		}
		
		System.out.println(hola.size);
		
		System.out.println(temp.elapsedTime());
		

	}

	@Override
	public Iterator<K> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
