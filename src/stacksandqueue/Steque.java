package stacksandqueue;

import java.util.Iterator;

public class Steque<T> implements Iterable<T> {
	
	private Node last;
	private Node first;
	private int N;
	
	public int size() {
		return N;
	}
	
	public boolean isEmpty() {
		return N==0;
	}
	
	public void push(T object) {
		Node oldfirst=first;
		first=new Node();
		first.item=object;
		first.next=oldfirst;
		if(isEmpty()) {
			last=first;
		}
		++N;
		
	}
	
	public void enqueue(T object) {
		
		Node oldlast=last;
		last=new Node();
		last.item=object;
		last.next=null;
		if(isEmpty()) {
			first=last;
		}
		else {
			oldlast.next=last;
		}
		
		++N;
		
	}
	
	
	public T pop() {
		
		if(first==null) {
			throw new IndexOutOfBoundsException("Todos los elemetos ya extraidos");
		}
		else {
		
		
		T item=first.item;
		first=first.next;
		--N;
		return item;}
	}
	
	
	private class Node{
		Node next;
		T item;
		
	}

	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return new listIterator();
	}
	
	private class listIterator implements Iterator<T>{

		private int i=N;
		private Node temp=first;

		
		@Override
		public boolean hasNext() {
			// TODO Auto-generated method stub
			return i>0;
		}

		@Override
		public T next() {
			// TODO Auto-generated method stub
			T item=temp.item;
			temp=temp.next;
			--i;
			return item;
		}
		
	}

}
