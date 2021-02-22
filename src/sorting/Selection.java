package sorting;

public class Selection {


	public static void sort(Comparable [] a) {
		
		int longitud=a.length;
		
		
		for(int i=0;i<longitud;i++) {
			int min=i;
			for(int j=i+1;j<longitud;j++) {
				
				if(isless(a[j],a[min])) {
					min=j;
					
				}
			}
			exchenge(a, i, min);
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
