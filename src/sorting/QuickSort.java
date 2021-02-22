package sorting;
import edu.princeton.cs.*;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.algs4.Quick;
import edu.princeton.cs.algs4.StdOut;
public class QuickSort {
	
 /**
  * 
  * @param arreglo Arreglo de elementos que implementan la interfaz Comparable
  */
public static void sort(Comparable [] arreglo) {
		
		StdRandom.shuffle(arreglo);
		
		sort(arreglo,0,arreglo.length-1);
		
	}
	
	
	private	 static void sort(Comparable [] a, int low,int high) {
		
		
		if(high-low<=15) {
			insertion(a,low,high);
			return;
		}
		
		int j=particion(a,low,high); 
		sort(a,low,j-1);
		sort(a,j+1,high);
	}
	
	
	public static void sortBesCase(Comparable [] arreglo) {
		
		sort(arreglo,0,arreglo.length-1);
		
		
	}
		
	
	
	private static void insertion(Comparable [] a,int low, int high) {
		
		for(int i=low;i<high;i++) {
		
			for(int j=i+1;j>0&&a[j].compareTo(a[j-1])<0;--j) {
				
				intercambiar(a,j,j-1);
			}
			
		}
	
	}
	
	
	private static int particion(Comparable[] a , int low,int high)
	{
		Comparable partidor=a[low];
		
		int i=low;
		int j=high+1;
		
		while(true) {
			
			while(partidor.compareTo(a[++i])>0) {
				
				if(i==high)break;
			}
		
			while(partidor.compareTo(a[--j])<0) {
				
			}
	
			if(i>=j) {
				break;
			}
			
			intercambiar(a,i,j);
		}
		
		intercambiar(a,low,j);
	
		return j;
	}
	
	
	
	
	private static void intercambiar(Comparable[] arreglo,int a,int b) {
		
		Comparable temp=arreglo[a];
		arreglo[a]=arreglo[b];
		arreglo[b]=temp;
		
	}
	
	/**
	 * 
	 * @param a Imprime el arreglo ordenado a
	 */
	
	public static void show(Comparable[] a) {
		
		for(Comparable i:a) {
			System.out.print(i +" ");
		}
		
		System.out.println();
		
	}
	
	public static void sort2(Comparable []a ) {
		StdRandom.shuffle(a);
		
		sort2(a,0,a.length-1);
		
	}
	
	public static void sort2(Comparable[] a,int lo,int hi) {
		
		
		if(hi-lo<=15) {
			insertion(a,lo,hi);
			return;
		}
		int lt = lo, i = lo+1, gt = hi;
		Comparable v = a[lo];
		while (i <= gt)
		{
		int cmp = a[i].compareTo(v);
		if (cmp < 0) intercambiar (a, lt++, i++);
		else if (cmp > 0) intercambiar(a, i, gt--);
		else i++;
		}
		sort2(a, lo, lt - 1);
		sort2(a, gt + 1, hi);
	}
		
	
	
	public static void main(String args[]) {
		
		int size=10000000;
		double tiempo=0;
		Comparable[] arreglo= GeneradorArreglos.generador(size);
		Stopwatch timer = new Stopwatch();
		bestArray(arreglo);
	
		 
		sortBesCase(arreglo);
		tiempo=timer.elapsedTime();
		
		System.out.println(tiempo);
		
		for(int i=0;i<100;i++) {
			System.out.print(arreglo[i]+" ");
		}

	}
	
	public static void bestArray(Comparable [] a) {
		
		producirBestCase(a, 0, a.length-1);
		
	}
	
	public static void producirBestCase(Comparable[] a , int low,int high) {
		
		if(high<=low) {
			return;
		}
		
		int medio=low+(high-low)/2;
		
		
		producirBestCase(a, low, medio-1);
		producirBestCase(a, medio+1, high);
		
		Comparable temp=a[low];
		a[low]=a[medio];
		a[medio]=temp;
	}

}
