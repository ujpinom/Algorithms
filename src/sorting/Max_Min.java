package sorting;

public class Max_Min <T extends Comparable<T>> {
	
	public T [ ] arregloMax;
	public T[] arregloMin;
	
	public int N;
	
	private T min;
	private T max;

	@SuppressWarnings("unchecked")
	public Max_Min(int max) {
		
		this.arregloMax=(T[]) new Comparable[max];
		this.arregloMin=(T[]) new Comparable[max];
	}
	
	
	public void insert(T item) {
		
		arregloMax[++N]=item;
		nadar(N);
	
		arregloMin[N]=item;
		nadar2(N);
	}
	
	
	
	public T delMax() {
		
		T item= arregloMax[1];
		intercambiar(arregloMax,1,N);
		arregloMax[N--]=null;
		
		int borrado=indexElementoBorrado(item,1);
		
		while(borrado<N+1) {
			
			arregloMin[borrado]=arregloMin[borrado+1];
			++borrado;
		
		}
		arregloMin[N+1]=null;
		
		sink(arregloMax,1);
		return item;
	
	}
	
	
	private int indexElementoBorrado(T item,int n) {
		
		int k=0;
		int index=0;
		if(n==1) {
		while(2*k<=N) {
			k++;
			int j=2*k;
			
			if(arregloMin[j]==item) {
				index=j;
				break;
			}
			else if(arregloMin[j+1]==item) {
				index=j+1;
				break;
			}
			
			
		}
	}
		
		else {
			while(2*k<=N) {
				k++;
				int j=2*k;
				
				if(arregloMax[j]==item) {
					index=j;
					break;
				}
				else if(arregloMax[j+1]==item) {
					index=j+1;
					break;
				}
				
				
				
			}
		}
		
		return index;
		
	}
	
	
	public T delMin() {
		
		T item= arregloMin[1];
		intercambiar(arregloMin,1,N);
		arregloMin[N--]=null;
		
		
	int borrado=indexElementoBorrado(item,0);
	

		while(borrado<N+1) {
			
			arregloMax[borrado]=arregloMax[borrado+1];
			++borrado;
		
		}
		arregloMax[N+1]=null;
		
			
		sink2(arregloMin,1);
		return item;
		
	}
	
	
	private void sink(Comparable [] a,int k) {
		
		while(2*k<=N) {
			
			int j= 2*k;
			
			if(j<N  && a[j].compareTo(a[j+1])<0) {
				++j;
			}
			
			if(a[k].compareTo(a[j])>0) {
				break;
			}
			
			intercambiar(a,k,j);
			
			k=j;
			
			
		}
		
	}
	
	
	private void sink2(Comparable [] a,int k) {
	
		
		while(2*k<=N) {
			
			int j= 2*k;
			
			if(j<N  && a[j+1].compareTo(a[j])<0) {
				++j;
			}
			
			if(a[k].compareTo(a[j])<0) {
				break;
			}
			
			intercambiar(a,k,j);
			
			k=j;
			
			
		}
	}
	
	public T min() {
		return arregloMin[1];
	}
	
	public T max() {
		return arregloMax[1];
	}
	
	
	private void nadar(int k) {
		
		while(k>1&&arregloMax[k/2].compareTo(arregloMax[k])<0) {
			
			intercambiar(arregloMax,k,k/2);
			k=k/2;
		}
		
	}
	
	public T peekMax() {
		return arregloMax[1];
	}
	public T peekMin() {
		
		return arregloMin[1];
	}
	
	private void nadar2(int k) {
		
	while(k>1&&arregloMin[k/2].compareTo(arregloMin[k])>0) {
			
			intercambiar(arregloMin,k,k/2);
			k=k/2;
		}
		
		
	}
	
	private void intercambiar (Comparable [] a,int i,int j) {
		
		Comparable tem= a[i];
		a[i]= a[j];
		a[j]=tem;
		
		
	}

}
