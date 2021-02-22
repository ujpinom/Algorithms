package sorting;

public class Insertion {
	
	
	public static void sort(Comparable[]a) {
		
		int N=a.length;
		
		for(int i=0;i<N;i++) {
			
			for(int j=i;j>0&&!isless(a[j-1],a[j]);j--) {
				exchenge(a, j-1, j);
			}
		}
		
	}
	
	
	public static void sortSinExc(Comparable[]a) {
		
		
		int N=a.length;
		
		for (int i=1;i<N;i++) {
			
			Comparable min=a[i];
			int temp=i;
			
			for(int j=i;j>0&&isless(min,a[j-1]);--j) {
				
				a[j]=a[j-1];
				
				temp--;
			}
			
			a[temp]=min;
		
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
