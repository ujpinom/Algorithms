package stacksandqueue;

import java.util.Iterator;

public class Queue <T> implements Iterable<T> {
	
	private Node first;
	private Node last;
	private int N;
	
	
	
	private class Node{
		T item;
		Node siguiente;
	}
	
	public void push(T o)
	{
		
		Node viejo=last;
		last= new Node();
		last.item=o;
		last.siguiente=null;
		if(isEmpty()) {
			first=last;
		}
		else {
			viejo.siguiente=last;
			
		}
		++N;
		
	}
	
	public T pop() {
		T item=first.item;
		first=first.siguiente;
		if(isEmpty())
			last=null;
		--N;
		
		return item;
	}
	
	
	public boolean isEmpty() {
		return first==null;
	}
	
	public int size() {
		return N;
	}

	
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new listIterator();
	}
	
	private class listIterator implements Iterator<T>{

		private Node actual=first;
		
		public boolean hasNext() {
			
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
