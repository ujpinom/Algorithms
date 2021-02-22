package union_find;
import java.util.Arrays;

public class BinarySerch {
	
	public static int binarySerch(int [] arreglo,int key) {
		
		int low=0;
		int high=arreglo.length-1;
		int medio=0;
		
		while(low<=high) {
			
			medio=low+(high-low)/2;
		
			if(arreglo[medio]==key) {
				return medio;
			}
			else if(key>arreglo[medio]) {
				low=medio+1;
			}
			else if(key<arreglo[medio]) {
				high=medio-1;
			}

		}
		
		return -1;
		
	}
	

}
