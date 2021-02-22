package stacksandqueue;

import java.util.Iterator;

public class Lstack<T> implements Iterable<T> {

	private Node primero;
	private int N=0;
	
	private class Node{
		
		T item;
		Node siguiente;
		
	}
	
	public void push(T o) {
		
		Node viejo=primero;
		primero=new Node();
		primero.item=o;
		primero.siguiente=viejo;
		
		++N;
		
	}
	
	public T pop() {
		
		T item=primero.item;
		primero=primero.siguiente;
		--N;
		return item;
	
	}
	
	public T peek() {
		
		return primero.item;
	}
	
	public boolean isEmpty() {
		return N==0;
	}
	
	public int size() {
		return N;
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	private class listIterator implements Iterator<T>{

			Node actual=primero;
		
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return actual!=null;
		}

		@Override
		public T next() {
			
			T item= actual.item;
			actual=primero.siguiente;
			return item;
		}
		
	}
	
	
	
	

}
