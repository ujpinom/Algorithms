package analisisAlg;

import java.security.SecureRandom;
import java.util.Arrays;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;

public class Eggs_1 {
	
	
	public static void main (String a[]) {
		
		
		SecureRandom numerosAleatorios = new SecureRandom();
		numerosAleatorios.setSeed(2);
		
		int [] array3=new int[500];
		
		for(int i=0;i<500;i++) {
			array3[i]=numerosAleatorios.nextInt(2);
		}
		
		Arrays.sort(array3);
		
		Stopwatch timer = new Stopwatch();
		 int resultado=floor(array3);
		 double tiempo=timer.elapsedTime();
		   
		   System.out.println("El huevo se rompe si es lanzado desde o un piso superior a :"+ resultado+" tiempo: "+tiempo);
		   
		
		
	}
	
	
	public static int floor(int array[]) {
		
		int k=1;
		int middle=0;
		int low=0;int high=array.length-1;
		
		if(array[0]==0&&array[high]==0) {
			return -1;
		}
		else if(array[0]==1&&array[high]==1) {
			return 0;
		}
		
		while(low<=high) {
			
			middle=low+(high-low)/2;
			
			if(array[middle]==k) {
				
				if(array[middle-1]==k)
					high=middle-1;
				else {
					return middle;
				}
				
			}
			
			else if(array[middle]<k) {
				low=middle+1;
			}
			
		}
		
		return middle;
		
			
	}
}
