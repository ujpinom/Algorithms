package sorting;

import edu.princeton.cs.algs4.Stopwatch;

public class Heap{


	public static void sort(Comparable []a) {
		
		int n=a.length-1;
		
		
		for(int k=n/2;k>=0;k--) {
			
			sink(a,k,n);
			
		}
		
		while(n>0) {
			intercambiar(a, 0, n--);
			sink(a,0,n);
		}
		
		
		
	}
	
	private static void sink(Comparable [] a, int k,int N) {
		
		while(2*k+1<=N) {
			
			int j=2*k+1;
						
			if(j<N&&a[j+1].compareTo(a[j])>0) {
				++j;
			}
			
			if(a[(k)].compareTo(a[j])>0) {
				break;
			}
			
			intercambiar(a,k,j);
			
			k=j;
		}

	}
	
	private static  void intercambiar(Comparable [] arreglo,int x,int y) {
		
		Comparable temp=arreglo[x];
		arreglo[x]=arreglo[y];
		arreglo[y]=temp;
		
	}

}
