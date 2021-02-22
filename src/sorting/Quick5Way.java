package sorting;

import java.util.HashMap;
import java.util.Map;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class Quick5Way {
	
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
		
		construirmediana(a, low, high);
		
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
	
	public static void construirmediana(Comparable []a,int low,int high) {
		
		int medio=low+(high-low)/2;
		
		int mediaIzquierda=low+(medio-low)/2;
		
		int mediaDerecha= medio+(high-medio)/2;
		
		if(a[low].compareTo(a[high])>0) {
			intercambiar(a,low,high);
		}
		
		if(a[low].compareTo(a[mediaDerecha])>0) {
			intercambiar(a,low,mediaDerecha);
			
		}
		if(a[low].compareTo(a[medio])>0) {
			intercambiar(a,low,medio);
			
		}
		if(a[low].compareTo(a[mediaIzquierda])>0) {
			intercambiar(a,low,mediaIzquierda);
			
		}
		
		if(a[mediaIzquierda].compareTo(a[high])>0) {
			intercambiar(a,mediaIzquierda,high);
		}
		
		if(a[mediaIzquierda].compareTo(a[mediaDerecha])>0) {
			intercambiar(a,mediaIzquierda,mediaDerecha);
		}
		if(a[mediaIzquierda].compareTo(a[medio])>0) {
			intercambiar(a,mediaIzquierda,medio);
		}
		
		if(a[medio].compareTo(a[mediaDerecha])>0) {
			intercambiar(a,mediaDerecha,medio);
		}
		if(a[medio].compareTo(a[high])>0) {
			intercambiar(a,high,medio);
		}
		if(a[mediaDerecha].compareTo(a[high])>0) {
			intercambiar(a,mediaDerecha,high);
		}
	
		
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
		
//		for(int i=0;i<arreglo.length;i++) {
//			System.out.print(arreglo[i]+" ");
//		}
		
	
	}
}
