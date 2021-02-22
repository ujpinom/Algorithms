package stacksandqueue;

import java.util.Iterator;

public class Exe1_14 <T> implements Iterable<T> {
	
	
	private int low=0;
	private int high=0;
	private int  N=0;
	private T[] cola=(T[])new Object[1];
	
	
	public int size() {
		return N;
	}
	
	
	public void queue(T o) {
		
		
		if(high==cola.length) {
			crecer(2*cola.length);
		}
		cola[high++]=o;	
		++N;
	}
	
	public int col() {
		return cola.length;
		
	}
	
	private void crecer(int tamanio) {
		
		T [] temp=(T[]) new Object[tamanio];
		
		for(int i=0;i<high;i++) {
			temp[i]=cola[i];
		}
		
		cola=temp;
	}
	
	public boolean isEmpty() {
		return N==0;
	}
	
	public T dequeue() {
		int tem=low;
		
		T item=cola[low++];
		cola[tem]=null;
		
		if(high-tem+1<=cola.length/4) {
			decrecer(cola.length/4);
		}
		
		--N;
		return item;
		
	}
	
	public void decrecer(int tamanio) {
		
		T[] temp=(T[])new Object[tamanio];
		
		
		for(int i=low;i<=high;i++) {
			temp[i-low]=cola[i];
		}
		
		cola=temp;
		high=high-low;
		low=0;
	}
	
	

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new listIterator();
	}
	
	private class listIterator implements Iterator<T>{

		private int i=0;
			
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return i<high;
		}

		@Override
		public T next() {
			
		T item=cola[i];
		++i;
		return item;
		}
		
	}
	
}
