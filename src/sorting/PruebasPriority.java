package sorting;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.Stopwatch;

public class PruebasPriority {

	public static void main(String[] args) {
		
		
		
		double [] vectorPueba=  {0,12,56,7,34,23,-1,34,-35,-5465,323,1,34,-2,34,535,-3,-5,56,-4354};
		
		int n=vectorPueba.length;

		HeapSort<Double> entradas= new HeapSort<>(7);
		
		
		
		for(int i=0;i<vectorPueba.length;i++) {
			
			entradas.insertar(vectorPueba[i]);
			
			if(entradas.size()>6) {
				entradas.removerMaximo();
			}
			
			
		}
		
		System.out.println(entradas.min());
		
	
		
		Stack<Double> recolector=new Stack<>();
		
	
		
		while(!entradas.isEmpty()) {
			
			recolector.push(entradas.removerMaximo());
			
		}

		
		
//		
//		int contador=2500;
//		
		for(Double i:recolector) {
			System.out.print(i+" ");
			
			
		}
		
		System.out.println();
		
		// TODO Auto-generated method stub

	}

}
