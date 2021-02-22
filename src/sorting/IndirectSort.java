package sorting;

import java.util.HashMap;
import java.util.Map;

public class IndirectSort {

	public static Comparable [] index;
	public static Comparable[] aux;
	public static Map<Comparable,Integer> k_v=new HashMap<>();
	
	public static void main(String[] args) {
		
		Comparable[] arreglo= {2,4,3,0,1,5};
		index=new Comparable[arreglo.length];
		
		sort(arreglo);
	
		int N_index=index.length;
		for(int i=0;i<N_index;i++) {
			System.out.println(index[i]+" ");
		}
		
		for(int i=0;i<N_index;i++) {
			System.out.println(arreglo[i]+" ");
		}
	
	}
	
	
	public static void sort(Comparable [] a) {
		aux=new Comparable[a.length];
		Comparable [] aux1=new Comparable[a.length];
		int n=a.length;
		for(int i=0;i<n;i++) {
			k_v.put(a[i], i);
			aux1[i]=a[i];
		}
		
		
		
		int low=0;
		int high=a.length-1;
		
		sort(aux1,low,high);
		
	}
	
	
	public static void sort(Comparable []a, int low,int high) {
		
		int medio=0;
		
		if(high<=low) {
			return;
		}
		
		medio=low+(high-low)/2;
		
		sort(a,low,medio);
		sort(a,medio+1,high);
		
		merge(a,low,medio,high);
		
		
	}
	
	public static void merge(Comparable []a , int low,int medio,int high) {
		
		
		int i=low;
		int j=medio+1;
		
		for(int k=low;k<=high;k++) {
			aux[k]=a[k];
		}
		
	
		int contador=0;
		for(int k=low;k<=high;k++) {
			Comparable izquierda=aux[i];
			Comparable derecha=aux[j];
			
		
			if(i>medio) {
				a[k]=aux[j++];
				index[contador++]=k_v.get(derecha);
				
			}
			
			else if(j>high) {
				
				a[k]=aux[i++];
				index[contador++]=k_v.get(izquierda);
			}
			
			else if(derecha.compareTo(izquierda)<0) {
				a[k]=aux[j++];
				index[contador++]=k_v.get(derecha);				
			}
			
			
			else {
				a[k]=aux[i++];
				index[contador++]=k_v.get(izquierda);
			}	
			
		}
		
	}	

}
