package sorting;

public class PriorityQ_Links<T extends Comparable <T>> {
	
	private int N=0;
	private Nodo primero;
	
	
	
	class Nodo{
		
		T item;
		
		Nodo padre;
		Nodo hijoIzquierda;
		Nodo hijoDerecha;
		int indexHijoIz;
		int indexHijoDe;
		int indexPadre;
	}
	
	
	public void insertar(T item) {
		Nodo actual= new Nodo();
		if(N==0) {
			
			actual.item=item;
			actual.padre=null;
			actual.indexHijoIz=2*N;
			actual.indexHijoDe=2*N+1;
			++N;			
		}
		else {
			
			actual= new Nodo();
			actual.item=item;
			
			
			
		}
		
		
		Nodo viejo=primero;
		Nodo actual= new Nodo();
		actual.item=item;
		actual.padre=primero;
		primero=actual;
		
		
		

	}
	
	
	public Nodo obtenerPadreNodoActual() {
		
		
		
	}
	
	

}
