package sorting;

import java.util.ArrayList;

public class Shellsort {

	
	public static void sort(Comparable[]a) {
		 int N=a.length;
		 
		int h=1;
		 
		 while(h<N/3) {
			 h=3*h+1;
		 }
		 
		 while(h>=1) {
			 
			 for(int i=h;i<N;i++) {
				 
				 for(int j=i;j>=h&&isless(a[j],a[j-h]);j-=h) {
					 exchenge(a,j,j-h);
				 }
				 
			 }
			 
			 h=h/3; 
		 }
		 
	}
	
	public static void sort2(Comparable[]a ,ArrayList<Integer> incremento) {
		 int N=a.length;
		
		for(Integer h:incremento) {
			
			
			for(int i=h;i<N;i++) {
				
				while(i>=h&&isless(a[i],a[i-h])) {
					exchenge(a,i-h,i);
					
					i-=h;
					
				}
			}
		
		}
	
	}
	
	
	public static void show(Comparable []a) {
		
		int l=a.length;
		
		for(int i=0;i<l;i++) {
			System.out.print(a[i]+" ");
			if(i%10==0 && i>0) {
				System.out.println();
			}
		}
	}
	
	
	private static boolean isless(Comparable v,Comparable u) {
		
		return(v.compareTo(u)<0);
		
	}
	
	private static void exchenge(Comparable[]a,int i,int j ) {
		
		Comparable temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}
	
	
}
