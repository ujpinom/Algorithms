package sorting;

import java.util.Arrays;

public class Merge {
	
//	private static Comparable[] aux;
	
	private  static void merge(Comparable [] a ,Comparable [] aux,int comienzo,int medio,int fin) {
		
	int i=comienzo;
	int j=medio+1;
	
//	int contador=0;
//	
//	for(int k=0;k<=fin;k++) {
//		if(k<=medio)
//		aux[k]=a[k];
//		else {
//			aux[k]=a[fin-contador++];
//		}
//	}
	
	
	for(int k=comienzo;k<=fin;k++) {
		
		if(isMenor(aux[j],aux[i])) {
			a[k]=aux[j++];
		}
		else if(j>fin) {
			a[k]=aux[i++];
		}
		
		else if(i>medio) {
			a[k]=aux[j++];
		}
		else {
			a[k]=aux[i++];
		}
	}
	
	}
	
	public static void sort(Comparable[]a) {
		Comparable [] aux=new Comparable[a.length];
		int low=0;
		int high=a.length-1;
		sort(a,aux,low,high);
		
	}
	
	private static void sort(Comparable []a,Comparable [] aux,int low,int high) {
		int medio=0;
		
		if(high-low==15) {
			insertionSort(aux, low, high);
			return;
		}
		
		if(high<=low)return;
		
		medio=low+(high-low)/2;
		
		sort(aux,a,low,medio);
		sort(aux,a,medio+1,high);
		if((a[medio].compareTo(a[medio + 1]) <= 0)) {
			 System.arraycopy(a, low, aux, low, high - low + 1);
		        return;	
		}
		 merge(a, aux, low, medio, high);
			
	}
	
    private static void insertionSort(Comparable[] array, int low, int high) {
        for(int i = low; i <= high; i++) {
            for(int j = i; j > low && array[j - 1].compareTo(array[j]) > 0; j--) {
                Comparable temp = array[j - 1];
                array[j - 1] = array[j];
                array[j] = temp;
            }
        }
    }
	
	
	private static boolean igual(Comparable a,Comparable b) {
		return a.compareTo(b)==0;
	}
	
	
	private static boolean isMenor(Comparable a,Comparable b) {
		
		return a.compareTo(b)<0;
	}
	


}
