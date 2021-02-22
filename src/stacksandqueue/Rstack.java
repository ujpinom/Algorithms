package stacksandqueue;

import java.util.Iterator;

public class Rstack<T> implements Iterable<T> {
	
	private T[] stack=((T[])new Object[1]);
	
	private int N=0;
	
	
	public int size() {
		return N;
	}
	
	public boolean isEmpty() {
		return N==0;
	}
	
	public T peek() {
		/* Retorna el último elemento agregado a la pila sin removerlo*/
		return stack[N];
	}
	
	public void push(T item) {
		
		if(N==stack.length) {
			resize(2*stack.length);
				
		}
		
		stack[N++]=item;

		
	}
	private void resize(int size) {
		
		T[] temp=((T[])new Object[size]);
		
		for(int i=0;i<N;i++) {
			temp[i]=stack[i];
		}
		stack=temp;
	}
	
	public T pop() {
		
		T item=stack[--N];
		stack[N]=null;
		
		if(N>0 && N<=stack.length/4) {
			resize(stack.length/4);
		}
		
		return item;
		
	}
	
	public Iterator<T> iterator(){
		return new StackIterator();
	}
	
	private class StackIterator implements Iterator<T>{
		
		private int i=N;

		@Override
		public boolean hasNext() {
			
			return i>0;
		}

		@Override
		public T next() {
			
			
			return stack[--i];
			
		}
		
	}

}
