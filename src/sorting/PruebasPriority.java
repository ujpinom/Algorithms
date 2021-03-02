package sorting;

import edu.princeton.cs.algs4.Stack;
import edu.princeton.cs.algs4.Stopwatch;

public class PruebasPriority {

	public static void main(String[] args) {
		
		
		
		Comparable [] vectorPueba=  {0,12,56,7,34,23,-1,34,-35,-5465,323,1,34,-2,34,535,-3,-5,56,-4354};
		
		
		Heap.sort(vectorPueba);
		
		Insertion.show(vectorPueba);
//		double tiempo =0;
//		 Stopwatch timer = new Stopwatch();
//		
//		
//		
//		int maximoElementos=5;vec
//		
//		HeapSort<Double> entradas= new HeapSort<>(maximoElementos+1);
//		
//		
//		
//		for(int i=0;i<vectorPueba.length;i++) {
//			
//			entradas.insertar(vectorPueba[i]);
//			
//			if(entradas.size()>maximoElementos) {
//				entradas.removerMaximo();
//			}
//			
//			
//		}
//		
//	
//		
//		Stack<Double> recolector=new Stack<>();
//		
//	
//		
//		while(!entradas.isEmpty()) {
//			
//			recolector.push(entradas.removerMaximo());
//			
//		}
//
//		
//		
////		
////		int contador=2500;
////		
//		for(Double i:recolector) {
//			System.out.print(i+" ");
//			
//			
//		}
		
	
		
		// TODO Auto-generated method stub

	}

}
