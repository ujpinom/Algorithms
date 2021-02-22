package analisisAlg;

import java.security.SecureRandom;
import java.util.Arrays;

import edu.princeton.cs.algs4.Stopwatch;

public class ClosestPairs {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		SecureRandom numerosAleatorios = new SecureRandom();
		numerosAleatorios.setSeed(2);
		
		double [] numeros=new double[1000000];
		
		for(int i=0;i<100000;i++) {
    		numeros[i]=Math.random()*100000+1;
    	}
		
		
		Arrays.sort(numeros);
		Stopwatch timer = new Stopwatch();
    	
		int[] resultado=closestPair(numeros);
    	double tiempo=timer.elapsedTime();
		System.out.println("Puntos mas cercanos: "+"( "+numeros[resultado[0]]+","+numeros[resultado[1]]+")");
		
		System.out.println(tiempo);
		
	}
	

	public static int [] closestPair(double [] arreglo) {
		
		int resultado [] = new int[2];
		
		
		int N=arreglo.length-1;
		
		if(arreglo[0]==arreglo[N]) {
			resultado[0]=-1;
			resultado[1]=-1;
			
			return resultado;
		}
		
		
		
		double distanciaActual=Math.abs(arreglo[0]-arreglo[N]);
		resultado[0]=0;
		resultado[1]=N;
		
		for(int i=0;i<N-1;i++) {
			
			if(arreglo[i]!=arreglo[i+1]) {
				
				double distanciaActual_temp=Math.abs(arreglo[i]-arreglo[i+1]);
				
				if(distanciaActual_temp==0) {
					continue;
				}
				else if(distanciaActual_temp<distanciaActual) {
					distanciaActual=distanciaActual_temp;
					resultado[0]=i;
					resultado[1]=i+1;
					
				}
			}
		}

		return resultado;
	}

}
