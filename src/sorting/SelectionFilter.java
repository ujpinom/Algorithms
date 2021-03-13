package sorting;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;


public class SelectionFilter {
	
	class puntos implements Comparable<puntos>{
		
		double x;
		double y;
		double z;
		
		public puntos(double x,double y,double z)
		{
			this.x=x;
			this.y=y;
			this.z=z;
		}
		
		public puntos() {
			
		}

		@Override
		public int compareTo(puntos o) {
			
			double valorIzquierdo= Math.sqrt(Math.pow(x, 2)+Math.pow(y, 2)+Math.pow(z, 2));
			double valorDerecho=Math.sqrt(Math.pow(o.x, 2)+Math.pow(o.y, 2)+Math.pow(o.z, 2));
			
			
			if(valorIzquierdo<valorDerecho) {
				return -1;
			}
			else if(valorIzquierdo>valorDerecho) {
				return 1;
			}
			else 
				return 0;

		}
		
		@Override
		public String toString() {
			return String.format("( %.2f , %.2f , %.2f )",x,y,z);
					
		}
		
	}
	
	public static void main(String args[]) {
		
		
		int M=10000; // M puntos más cercanos al origin
		
		
		HeapSort<puntos> punto= new HeapSort<>(M+1);
		SelectionFilter xx= new SelectionFilter();
		
		Stopwatch timer= new Stopwatch();
		
		for (int i=0;i<100000000;i++) {
			
			double x= StdRandom.uniform()*10;
			double y= StdRandom.uniform()*10;
			double z= StdRandom.uniform()*10;
			punto.insertar(xx.new puntos(x,y,z));
			
			if(punto.size()>M) {
				punto.removerMaximo();
			}
			
		}
		
		Stack<puntos> recolector= new  Stack<>();
		
		while(punto.size()>0) {
			recolector.push(punto.removerMaximo());
			
		}
		
		System.out.println(timer.elapsedTime());
	
		System.out.println();
		int contador=0;
		for(puntos p:recolector) {
			System.out.print(p+" ");
			if(contador==7) {
				break;
			}
			++contador;
		}
		
		
	}
	

}
