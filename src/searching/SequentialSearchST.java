package searching;

import edu.princeton.cs.algs4.Queue;

public class SequentialSearchST<K extends Comparable<K>,V> {
	
	private Nodo actual;
	private int N;
	
	
	class Nodo{
		
		K key;
		V value;
		Nodo siguiente;
		
		Nodo(K key,V value,Nodo siguiente){
			
			this.key=key;
			this.value=value;
			this.siguiente=siguiente;
		}
		
	}
	
	
	public void put(K k,V v) {
		
		if(N==0) {
			actual=new Nodo(k,v,null);
			++N;
			return;
		}
		
		if(actual.key.compareTo(k)>0) {
			
			actual=new Nodo(k,v,actual);
			++N;
			return;
				
		}
		else if(actual.key.compareTo(k)==0) {
			actual.value=v;
			return;
			
		}
		
		if(v==null) {
			
			if(get(k)==null) {
				return;
			}
			else {
				borrar(k);
				return;
			}
		}
		
		
		for(Nodo x=actual;x!=null;x=x.siguiente) {
			
			if(x.siguiente!=null) {
				
				if(x.siguiente.key.compareTo(k)>0) {
					
					Nodo temp=new Nodo(k,v,x.siguiente);
					x.siguiente=temp;
					++N;
					return;
					
				}
				else if (x.siguiente.key.compareTo(k)==0) {
					
					x.siguiente.value=v;
					return;
					
				}

			}
			else {
				
				Nodo temp= new Nodo(k,v,null);
				x.siguiente=temp;
				++N;
				return;
				
			}
			
		}
		
	}

	public V get(K k) {
	
		for(Nodo x=actual;x!=null;x=x.siguiente) {
			
			if(k.equals(x.key)) {
				return x.value;
			}
		}	
		
		return null;
	
	}
	
	public int size() {
		return N;
	}
	
	
	public void borrar(K k) {
		
		if(size()==0) {
			return;
		}
		
		
		if(actual.key.equals(k)) {
			
			actual=actual.siguiente;
			--N;
			return;
		}
		
		for(Nodo x=actual;x!=null;x=x.siguiente) {

				if(x.siguiente!=null&& x.siguiente.key.compareTo(k)==0) {
				
					x.siguiente=x.siguiente.siguiente;
					--N;
					return;
			}
			

		}

	}
	
	
	public Iterable<K> keys(){
		Queue<K> cola= new Queue<>();
		
		
		for(Nodo x=actual;x!=null;x=x.siguiente) {
			
			cola.enqueue(x.key);
		}
		
		return cola;

	}
	
	public static void main (String [] args) {
		
		SequentialSearchST<String,Integer> hola= new SequentialSearchST<>();
		
		hola.put("Vaca2", 2);hola.put("Vaca1", 2);
		
		hola.put("Perro", 2);
		hola.put("Perro1", 2);
		hola.put("Perro2", 2);
		hola.put("Perro3", 2);
		hola.put("Perro4", 2);
		hola.put("Perro5", 2);hola.put("Perro6", 2);
		
		
		for(String s:hola.keys()) {
			
			System.out.print(s+" ");
			
		}
		
		System.out.println();
		
		hola.borrar("Perro63");
		
		for(String s:hola.keys()) {
			
			System.out.print(s+" ");
			
		}
		
	}

}
