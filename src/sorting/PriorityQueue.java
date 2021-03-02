package sorting;

import java.util.Iterator;

public class PriorityQueue <T extends Comparable<T>> implements Iterable {

	private Comparable [] arreglo;
	
	private int N=0;
	
	
	public PriorityQueue() {
		
		arreglo=new Comparable[1];
		
	}
	
	public PriorityQueue(int max) {
		
		arreglo=new Comparable [max];
	}
	
	public PriorityQueue(T[] a) {
		
		arreglo=a;
		
	}
	
	
	public void insert(T v) {
		
		if(N==arreglo.length) {
			resize(2*N);
		}
		
		
		arreglo[N++]=v;
		
		
	
	}
	
	private void resize(int nueviTamanio) {
		
		Comparable[] temp= new Comparable [nueviTamanio];
		for(int i=0;i<N;i++) {
			
			temp[i]=arreglo[i];
			
		}
		
		arreglo=temp;
	
	}
	
	
	public T max() {
		
		return (T) arreglo[N];
		
	}
	
	
	public T delMin() {
		
		int min=0;
		for(int i=0;i<N-1;i++) {
			
			if(arreglo[i+1].compareTo(arreglo[min])<0) {
				min=i+1;
			}
		}
		
		intercambiar(N-1,min);
		
		T item=(T) arreglo[--N];
		arreglo[N]=null;
		
		
		if(N<=arreglo.length/4&& N>0) {
			resize(arreglo.length/4);
		}
		int n=arreglo.length;		
		
		
		return item;
	}
	
	
	public T delMax() {
		
		int max=0;
		for(int i=0;i<N-1;i++) {
			
			if(arreglo[i+1].compareTo(arreglo[max])>0) {
				max=i+1;
			}
		}
		
		intercambiar(N-1,max);
		
		T item=(T) arreglo[N];
		arreglo[N]=null;
		--N;
		
		if(N<=arreglo.length/4&& N>0) {
			resize(arreglo.length/4);
		}
		
		return item;
		
	}
	
	public boolean isEmpty() {
		
		return N==0;
		
	}
	
	public int size() {
		
		return N;
		
	}
	
	private void intercambiar(int i,int j) {
		
		Comparable temp=arreglo[i];
		
		arreglo[i]=arreglo[j];
		
		arreglo[j]=temp;
		
	}
	

	@Override
	public Iterator iterator() {
		
		return null;
	}
	
	class listaiterator implements Iterator<T>{
		
		
		int i=N;

		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return i>0;
		}

		@Override
		public T next() {
			
			return (T) arreglo[--i];
		}
		
	}
				
}
