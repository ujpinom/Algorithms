package sorting;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class QuickSortSentinels {

	
	public static void sort(Comparable []a) {
		StdRandom.shuffle(a);
		int N=a.length;
		int max=0;
		for(int i=1;i<N;i++) {
			
			if(a[i].compareTo(a[max])>0) {
				
				max=i;
			}
			
		}
		
		Comparable tem=a[max];
		a[max]=a[N-1];
		a[N-1]=tem;
	
		sort(a,0,N-1);
		
	}
	
	
	private static void sort(Comparable []a,int low,int high) {
		
		if(high-low<=15) {
			insertion(a,low,high);
			return;
		}
		
		int j=particion(a,low,high);
		
		sort(a,low,j-1);
		sort(a,j+1,high);
		
	}
	
	private static void insertion(Comparable [] a ,int low,int high) {
		
		for(int i=low;i<high;i++) {
			
			for(int j=i+1;j>0&&a[j].compareTo(a[j-1])<0;--j) {
				
				intercambiar(a,j,j-1);
				
			}
			
		}
		
	}
	
	
	
	
	private static int particion(Comparable []a ,int low, int high) {
		Comparable pivote=a[low];
		int i=low;
		int j=high+1;
		
		while(true) {
			
			while(pivote.compareTo(a[++i])>0);
			
			while(pivote.compareTo(a[--j])<0);
			
			
			if(j<=i) {
				break;
			}
			
			intercambiar(a,i,j);
			
		}
		
		intercambiar(a,low,j);
		return j;
		
	}
	
	
	
	private static void intercambiar(Comparable []a,int i,int j) {
		
		Comparable temp=a[i];
		a[i]=a[j];
		a[j]=temp;
		
	}
	
	public static void show(Comparable[] a) {
		
		for(Comparable i:a) {
			System.out.print(i +" ");
		}
		
		System.out.println();
		
	}
	
	public static void main(String args[]) {
		
		int size=10000000;
		double tiempo=0;
		Comparable[] arreglo= GeneradorArreglos.generador(size);
		Stopwatch timer = new Stopwatch();
	
		sort(arreglo);
	
		tiempo=timer.elapsedTime();
		
		System.out.println(tiempo);
	}

}
