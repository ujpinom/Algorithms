package analisisAlg;

public class BSv_2 {
	
	public static int BynarySerch(int [] a,int k) {
		
		int low=0;int high=a.length-1;
		int mid=0;
		
		
		while(low<=high) {
			
			mid=low+(high-low)/2;
			
			if(a[mid]==k) {
		
				
				if(mid==0) {
					return mid;
				}
				
				else {
				
				if(a[mid-1]==k ) {
					high=mid-1;
				}
				else {
					return mid;
				}
				
				}
			}
			
			else if(a[mid]>k) {
				high=mid-1;
			}
			
			else if(a[mid]<k) {
				low=mid+1;
			}
			
		}
		
		return -1;
		
	}
}
