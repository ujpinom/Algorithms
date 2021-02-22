package sorting;
import edu.princeton.cs.algs4.*;
public class SortedQueue {
	
	
	public static void main(String args[]) {
		
		Queue<Comparable> c1=new Queue<>();
		c1.enqueue(-1);c1.enqueue(4);c1.enqueue(5);c1.enqueue(6);c1.enqueue(13);
		Queue<Comparable> c2=new Queue<>();
		c2.enqueue(3);c2.enqueue(4);c2.enqueue(6);c2.enqueue(8);c2.enqueue(15);
		
		if(c1.size()!=c2.size()) {
			throw new IllegalArgumentException("El tamaño de ambas colas debe ser el mismo. ");
		}
		
		
		Queue<Comparable> re=sortQueue(c1, c2);
		
		for(Comparable n:re) {
			System.out.println(n+" ");
		}
		
		
		
	}
	
	public static Queue<Comparable> sortQueue(Queue<Comparable> c1,Queue<Comparable> c2){
		
		Queue<Comparable > resultado=new Queue<>();
		
		
		while(c1.size()>0&& c2.size()>0) {
			Comparable izquierda=c1.peek();
			Comparable derecha=c2.peek();
			
			if(derecha.compareTo(izquierda)<0) {
				
				Comparable item=c2.dequeue();
				resultado.enqueue(item);
			}
			else {
				
				Comparable item=c1.dequeue();
				resultado.enqueue(item);
			}
		
		}
		
		
		if(c2.size()==0) {
			
			while(c1.size()>0) {
				Comparable item=c1.dequeue();
				resultado.enqueue(item);
			}
			
		}
		else if(c1.size()==0) {
			
			while(c2.size()>0) {
				Comparable item=c2.dequeue();
				resultado.enqueue(item);
			}
		}
		
		return resultado;
	}
	


}
