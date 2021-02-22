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
}
