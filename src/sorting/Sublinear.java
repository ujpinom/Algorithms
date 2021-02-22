package sorting;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class Sublinear {

	public static void main(String[] args) {
//		
//		int size_array=Integer.parseInt(args[0]);
		int size_blocks=4000;
//		
//		if(size_array%size_blocks!=0) {
//			throw new IllegalArgumentException("El tamaño de los bloques no es multiplo del tamaño del arreglo");
//		}
		
		
		
		Comparable [] arreglo= new Comparable[1000000];
		arreglo(arreglo);
		
		
		Comparable [] aux=new Comparable[size_blocks];
		int size_array=arreglo.length;
		
		double tiempo=0;
		Stopwatch timer = new Stopwatch();
			
		for(int i=0;i<size_array;i+=size_blocks) {
			
			selectionSort(arreglo, i, i+size_blocks-1);
					
		}
	
		
		for(int i=0;i<=size_array/size_blocks-2;i++) {
			for(int j=i+1;j<size_array/size_blocks;j++) {
				
				int inferior1=i*size_blocks;
				int inferior2=i*size_blocks+size_blocks-1;
				int superior=size_blocks*j+size_blocks-1;
				int superior1=size_blocks*j;
				int medio=inferior1+(superior-inferior1)/2;
				merge(arreglo,aux,inferior1,inferior2,superior1,superior,medio);
				
			}
		}
		tiempo+=timer.elapsedTime();
		
		System.out.println(tiempo);

	}
	
	
	public static void merge(Comparable []a,Comparable [] aux,int low1,int low2,int high1,int high2,int middle) {
	
		
		int contador=0;
		for(int k=low1;k<=low2;k++) {
			aux[contador]=a[k];
			++contador;
		}
		
		int i=0;
		int medio=aux.length-1;
		int j=high1;
		int cont=0;
		
		
		while(j<=high2 && i<=medio) {
		
		if(a[j].compareTo(aux[i])<0) {
				
			if(cont<=medio) {
				a[low1+cont]=a[j++];
				++cont;
			}
			else {
				a[high1++]=a[j++];
			}
			
			}
			else {
				if(cont<=medio) {
				a[low1+cont]=aux[i++];
				++cont;
				}
				else {
					a[high1++]=aux[i++];
				}
			}
	
		}
		
		if(j>high2) {
			
			while(i<=medio) {
				a[high1++]=aux[i++];
			}
			
		}
	}
	
	
	public static void arreglo(Comparable [] arreglo) {
		
		int N=arreglo.length;
		
		for(int i=0;i<N;i++) {
			
			arreglo[i]=StdRandom.uniform();
		}
		
		
	}
	
	public static void selectionSort(Comparable [] a, int low,int high) {
		
		for(int i=low;i<=high;i++) {
			int min=i;
			
			for(int j=i+1;j<=high;j++) {
				
				if(a[j].compareTo(a[min])<0) {
					min=j;
				}
				
			}
			
			Comparable temp=a[i];
			a[i]=a[min];
			a[min]=temp;
			
		}
		
	}

}
