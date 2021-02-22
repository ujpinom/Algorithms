package sorting;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class QuickMedian {
	
	
	public static void sort(Comparable []a) {
		StdRandom.shuffle(a);
		sort(a,0,a.length-1);
		
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
		
		int medio=low+(high-low)/2;
		
		if(a[low].compareTo(a[high])>0) {
			intercambiar(a,low,high);
		}
		
		if(a[low].compareTo(a[medio])>0) {
			intercambiar(a,low,medio);
		}
		if(a[medio].compareTo(a[high])>0) {
			intercambiar(a,high,medio);
		}
		
		Comparable pivote=a[medio];
		intercambiar(a,low,medio);
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
	
	public static void main(String args[]) {
		
		int size=10000000;
		double tiempo=0;
		Comparable[] arreglo= GeneradorArreglos.generador(size);
		Stopwatch timer = new Stopwatch();
	
		sort(arreglo);
	
		tiempo=timer.elapsedTime();
		
		System.out.println(tiempo);
		
		for(int i=5000000;i<5000050;i++) {
			System.out.print(arreglo[i]+" ");
		}
	}
	
	
	

}
