package stacksandqueue;

import java.util.Iterator;

public class Bag<T> implements Iterable<T> {

	private Node first;
	private  int N;
	
	
	
	private class Node{
		T item;
		Node siguiente;
	}
	
	
	private void add(T o) {
		
		Node oldNode=first;
		first=new Node();
		first.item=o;
		first.siguiente=oldNode;
		++N;
	
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

		Node actual= first;
		
		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return actual==null;
		}

		@Override
		public T next() {
			
			
			T item=actual.item;
			actual=first.siguiente;
			
			return item;
		}
		
		
	}
	

}
