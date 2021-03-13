package sorting;

public class HeapSort<T extends Comparable<T>> {
	
	
	private  T [] arreglo;
	
	private int N;
	
	private T min;
	
	@SuppressWarnings("unchecked")
	public HeapSort(int max) {
		
		arreglo=(T[]) new Comparable[max+1];
	}
	
	
	public void insertar(T key) {
	
		
		arreglo[++N]=key;
		
		haciaarriba(N);
		if(N==1) {
			min=key;
		}
		else {
			if(key.compareTo(min)<0) {
				min= key;
			}
		}

	}
	
	public T removerMaximo() {
		
		T item = arreglo[1];
		intercambiar(1,N--);
		arreglo[N+1]=null;
	
		haciaabajo(1);
		return item;
	}
	
	public boolean isEmpty() {
		return N==0;
	}
	
	public int size() {
		return N;
	}
	
	public T min () {
		return min;
	}
	

	
	
	
	private void haciaarriba(int k) {
		
		while(k>1 && arreglo[k/2].compareTo(arreglo[k])<0) {
			intercambiar(k/2,k);
			k=k/2;
		}
		
	}
	
	
	private void haciaabajo(int k) {
		
		while(2*k<=N) {
			
			
			int j=2*k;
			
			if(j<N && arreglo[j+1].compareTo(arreglo[j])>0) {
				++j;
			}
			if(arreglo[k].compareTo(arreglo[j])>0) {
				break;
			}
			
			intercambiar(k,j);
			
			k=j;
						
		}
		
	}
	

	private void intercambiar( int x,int y) {
		
		T temp=arreglo[x];
		arreglo[x]=arreglo[y];
		arreglo[y]=temp;
		
	}
	

	
	
	
	
}
