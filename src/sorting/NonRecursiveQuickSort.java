package sorting;

import java.util.Iterator;

import edu.princeton.cs.algs4.*;

public class NonRecursiveQuickSort {
	
	class indices {
		
		int low;
		int high;
		
		public indices(int low,int high) {
			
			this.low=low;
			this.high=high;
		}
		
	}
	
	public static Stack<indices> pilas= new Stack<>();
	
	
	public static void sort(Comparable[]a ) {
		NonRecursiveQuickSort x= new NonRecursiveQuickSort();
		StdRandom.shuffle(a);
	
		int low=0;
		int high=a.length-1;
		pilas.push(x.new indices(low,high));
		
		
		while(pilas.size()>0) {
			
			indices index=pilas.pop();
			
			low=index.low;
			high=index.high;
			
			if(high>low) {
				
				
				int j= particion(a,low,high);
				
				if(j==high) {
					pilas.push(x.new indices(low,j-1));
				}
				else if(j==low) {
				
					pilas.push(x.new indices(j+1,high));
				}
				else {
				
				if(Math.abs(j-1-low)>Math.abs(high-j+1)) {
					pilas.push(x.new indices(low,j-1));
					pilas.push(x.new indices(j+1,high));
				}
				else {
					pilas.push(x.new indices(j+1,high));
					pilas.push(x.new indices(low,j-1));
				}
				
				}				
			
		}
			
		}
		
	}
		
	private  static int particion(Comparable a[], int low,int high) {
		
		Comparable pivote=a[low];
		int i=low;
		int j=high+1;
		
		while(true) {
			
			while(pivote.compareTo(a[++i])>0) {
				if(i==high)break;
			}
			
			while(pivote.compareTo(a[--j])<0) {
				
			}
			
			if(j<=i) {
				break;
			}
			
			intercambiar(a,i,j);
			
			
		}
		
		intercambiar(a,low,j);
		
		return j;
		
		
	}
	
	private static void intercambiar(Comparable [] a, int x,int y) {
	
		Comparable temp=a[x];
		a[x]=a[y];
		a[y]=temp;
		
	}
	
	
	public static void main(String args[]) {
		
		
//		int size=10000000;
//		double tiempo=0;
//		Comparable[] arreglo= GeneradorArreglos.generador(size);
//		Stopwatch timer = new Stopwatch();
//	
//		sort(arreglo);
//	
//		tiempo=timer.elapsedTime();
//		
//		System.out.println(tiempo);
		
		Comparable []a = {1,3,5,6,2,3,7,3,-2,-1,-23,46,22,12,-1,324};
		
		sort(a);
		
		for(int i=0;i<a.length;i++) {
			System.out.print(a[i]+" ");
		}
		
	
	}
	
}


