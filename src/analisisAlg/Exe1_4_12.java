package analisisAlg;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class Exe1_4_12 {

	public static void main(String[] args) {
		
		
		for(int i=250;i<=1024000;i+=i) {
			
			double time=timeTrial(i);
			
			System.out.print(i+"    "+time+'\n');
		}
		
		
	     
	}
	
	public static int sol2(int []array1,int [] array2) {
        int array1Index = 0;
        int array2Index = 0;
        Integer recentMatchedValue = null;
        int contador=0;

        while (array1Index < array1.length && array2Index < array2.length) {
            if (array1[array1Index] < array2[array2Index]) {
                array1Index++;
            } else if (array2[array2Index] < array1[array1Index]) {
                array2Index++;
            } else {
                if(recentMatchedValue == null || recentMatchedValue != array1[array1Index]) {
                    ++contador;
                    recentMatchedValue = array1[array1Index];
                }
                array1Index++;
                array2Index++;
            }
        }
        
        return contador;
	}
	
	public static int parejas(int [] array1,int [] array2) {
	
		Map<Integer,Integer> map=new TreeMap<>();
		
	     int l1=array1.length;
	     int l2=array2.length;
	     
	     for(int i=0;i<l2;i++) {
	    	 
	    	 
	    	 if(!map.containsKey(array2[i])) {
	    		 map.put(array2[i], 1);
	    	 }
	    	 
	     }
	     
	     int contador=0;
	     
	     for(int i=0;i<l1;i++) {
	    	 
	    	 int value=array1[i];
	    	 if(map.containsKey(value)) {
	    		 
	    		 if(i==0||(array1[i-1]!=array1[i])) {
	    			 ++contador;
	    			 
	    		 }
	    		    		 
	    	 }
	     }
	     
	     return contador;
	}
	
	public static double timeTrial(int N)
	{ // Time ThreeSum.count() for N random 6-digit ints.
		SecureRandom numerosAleatorios = new SecureRandom();
		numerosAleatorios.setSeed(142);
	int MAX = 1000000;
	int[] a = new int[N];
	int []b=new int[N];
	for (int i = 0; i < N; i++) {
		a[i] = numerosAleatorios.nextInt(MAX);
		b[i] = numerosAleatorios.nextInt(MAX);
	}
		
	Stopwatch timer = new Stopwatch();
	int numero=sol2(a,b);
	return timer.elapsedTime();
	}

}
