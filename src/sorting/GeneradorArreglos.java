package sorting;
import edu.princeton.cs.algs4.*;
public class GeneradorArreglos {

	public static Comparable [] generador(int size) {
		
		Comparable [] resultado= new Comparable[size];
		
		for(int i=0;i<size;i++) {
			resultado[i]=StdRandom.uniform();
		}
		
		return resultado;
	}

	
	public static double[] generador_double(int size) {
		
		double [] resultado= new double[size];
		
		for(int i=0;i<size;i++) {
			resultado[i]=StdRandom.uniform();
		}
		
		return resultado;
	}
}
