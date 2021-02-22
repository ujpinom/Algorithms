package sorting;

public class InsertionSentinel {
	
	
	
	public static void sort(Comparable[] a) {
		
		int N=a.length;
		
		int min=0;
		for(int i=0;i<N-1;i++) {
			
			if(less(a[i+1],a[min])) {
				min=i+1;
			}
			
		}
		
		Comparable tm=a[0];
		a[0]=a[min];
		a[min]=tm;
		
		
		for(int i=1;i<N;i++) {
			
			for(int j=i;less(a[j],a[j-1]);--j) {
				
				intercambiar(j, j-1,a);
				
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
	
	
	private static boolean less(Comparable a,Comparable b) {
		return (a.compareTo(b)<0);
	}
	
	private static void intercambiar(int i,int j,Comparable []a) {
		
		Comparable tem=a[i];
		a[i]=a[j];
		a[j]=tem;
		
	}

}
