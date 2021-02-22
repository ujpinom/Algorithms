package stacksandqueue;

import java.util.Iterator;

public class Deque<T> implements Iterable<T> {
	
	
	private Node last;
	private Node first;
	private int N;

	
	
	public boolean isEmpty() {
		return N==0;
	}
	
	public int size() {
		return N;
	}
	
	
	public void pushLeft(T object) {
		
		Node oldfirst=first;
		first=new Node();
		first.item=object;
		first.izquierda=oldfirst;
		
		
		if(isEmpty()) {
			last=first;
		}
		else {
			oldfirst.derecha=first;
			
		}
		
		++N;
		
	}
	
	public void pushRight(T object) {
		
		Node oldLast=last;
		last=new Node();
		last.item=object;
		last.izquierda=null;
		if(isEmpty()) {
			first=last;
		}
		else {
			last.derecha=oldLast;
			oldLast.izquierda=last;
		}
		
			++N;		
	}
	
	public T popLeft() {
		
		T item=first.item;
		first=first.izquierda;
		--N;
		return item;
	}
	
	public T popRight() {
		
		T item=last.item;
		last=last.derecha;
		--N;
		return item;
	}
	
	private class Node{
		T item;
		Node izquierda;
		Node derecha;
	}
	


	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
