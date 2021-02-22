package analisisAlg;

import java.io.File;
import java.io.FileNotFoundException;
import java.security.SecureRandom;
import java.util.Arrays;
import java.util.Scanner;

import edu.princeton.cs.algs4.Stopwatch;

public class Exce1_1_15 {

	public static void main(String[] args) throws FileNotFoundException {
		
		SecureRandom numerosAleatorios = new SecureRandom();
		numerosAleatorios.setSeed(42);
		
    	
    	int [] numeros=new int [100000];
    	int MAX=100000;
    	
    	for(int i=0;i<100000;i++) {
    		numeros[i]=numerosAleatorios.nextInt(MAX)-50000;
    	}
    	Arrays.sort(numeros);
  
    	Stopwatch timer = new Stopwatch();
    	int twosum=twosumslow(numeros);
    	double tiempo=timer.elapsedTime();
       System.out.println(twosum+" en "+ tiempo);
		
		

	}
	
	
	public static int parejas(int [] arreglo ) {
		
		int low=0;int high=arreglo.length-1;
		int contador=0;
		int aux=0;
		
		if((arreglo[low]>0&&arreglo[high]>0)||(arreglo[low]<0&&arreglo[high]<0)) {
			return 0;
		}
		
		while(arreglo[low]<=0&&arreglo[high]>=0) {
			
			
			if(-arreglo[low]<arreglo[high]) {
					--high;
			}
			else if(-arreglo[low]>arreglo[high]) {
				++low;
			}
			else if(arreglo[low]==0&&arreglo[high]==0) {  //Nothing between array[low] and array[high] but zero;
				int temp=high-low+1;
				contador+=(temp-1)*temp/2; 
				break;
				
			}
			else if(-arreglo[low]==arreglo[high] &&(arreglo[low]!=0&&arreglo[high]!=0)) {
				++contador;
				if(arreglo[high-1]==arreglo[high]) {
					--high;
					aux++;
				}
				else {
					low++;
					high+=aux;
					aux=0;
					
				}
				
			}
		
		}
		
		return contador;
		
	}
	
	public static int twosumslow(int [] a) {
		 int N=a.length;
		int cnt=0;
		
		for (int i = 0; i < N; i++)
			for (int j = i+1; j < N; j++)
			if (a[i] + a[j] == 0)
			cnt++;
		
		return cnt;
	}

}
