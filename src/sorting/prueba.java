package sorting;


import java.util.ArrayList;
import java.util.Map;

import edu.princeton.cs.algs4.Heap;
import edu.princeton.cs.algs4.Merge;
import edu.princeton.cs.algs4.Quick;
import edu.princeton.cs.algs4.Shell;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class prueba {

	
		
		
		
		  private enum MergeSortType {
		        CREATE_AUX_IN_SORT, CREATE_AUX_IN_MERGE;
		    }

		    public static void main(String[] args) {
		        int numberOfExperiments = Integer.parseInt(args[0]); // 4
		        int initialArraySize = Integer.parseInt(args[1]); // 131072

		        sortCompare(numberOfExperiments, initialArraySize);
		    }

		    public static void sortCompare(int numberOfExperiments, int initialArraySize) {

		        Map<Integer, Comparable[]> allInputArrays = generateAllArrays(numberOfExperiments, initialArraySize, 2);

		        double timeCreateAuxInSort = timeRandomInput(MergeSortType.CREATE_AUX_IN_SORT, allInputArrays, numberOfExperiments);
		        double timeCreateAuxInMerge = timeRandomInput(MergeSortType.CREATE_AUX_IN_MERGE, allInputArrays, numberOfExperiments);

		        StdOut.printf("For %d experiments with random double arrays of sizes from %d to %d\n creating aux[] in Sort is",
		                numberOfExperiments, initialArraySize, initialArraySize * 16);
		        StdOut.printf(" %.1f times faster than creating aux[] in Merge.", timeCreateAuxInMerge / timeCreateAuxInSort);
		    }
		    
		    
		    
		    
		    public static Map<Integer,Comparable[]> generateAllArrays(int experimentos, int size,int tipos){
		    	
		    	
		    }
		    	
		    	
		    	
		    	
		    	
		    

		    private static double timeRandomInput(MergeSortType mergeSortType, Map<Integer, Comparable[]> allInputArrays, int numberOfExperiments) {
		        double total = 0;

		        for(int experiment = 0; experiment < numberOfExperiments; experiment++) {
		            Comparable[] originalArray = allInputArrays.get(experiment);
		            Comparable[] array = new Comparable[originalArray.length];
		            System.arraycopy(originalArray, 0, array, 0, originalArray.length);

		            total += time(mergeSortType, array);
		        }

		        return total;
		    }

		    public static double time(MergeSortType mergeSortType, Comparable[] array) {
		        Stopwatch timer = new Stopwatch();

		        if (mergeSortType == MergeSortType.CREATE_AUX_IN_SORT) {
		            TopDownMergeSort.mergeSort(array);
		        } else if (mergeSortType == MergeSortType.CREATE_AUX_IN_MERGE) {
		            Exercise26_ArrayCreationMergeSort.mergeSort(array);
		        }

		        return timer.elapsedTime();
		    }
		    
		    
		  
		    	
		    
}

 





class Exercise26_ArrayCreationMergeSort {

    public static void mergeSort(Comparable[] array) {
        sort(array, 0, array.length - 1);
    }

    private static void sort(Comparable[] array, int low, int high) {

        if (high <= low) {
            return;
        }

        int middle = low + (high - low) / 2;

        sort(array, low, middle);
        sort(array, middle + 1, high);

        merge(array, low, middle, high);
    }

    @SuppressWarnings("unchecked")
    private static void merge(Comparable[] array, int low, int middle, int high) {
        Comparable[] aux = new Comparable[array.length];

        for (int i = low; i <= high; i++) {
            aux[i] = array[i];
        }

        int indexLeft = low;
        int indexRight = middle + 1;
        int arrayIndex = low;

        while (indexLeft <= middle && indexRight <= high) {
            if (aux[indexLeft].compareTo(aux[indexRight]) <= 0) {
                array[arrayIndex] = aux[indexLeft];
                indexLeft++;
            } else {
                array[arrayIndex] = aux[indexRight];
                indexRight++;
            }
            arrayIndex++;
        }

        while (indexLeft <= middle) {
            array[arrayIndex] = aux[indexLeft];

            indexLeft++;
            arrayIndex++;
        }
    }

}
		
		
//		Integer [] a= {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,-1,-10,-5,89,-6};
//		
//		Merge.sort(a);
//		
//		
//		Insertion.show(a);
		
		
//		int size=10000000;
//		Double [] arreglo= new Double[size];
//		int veces=1;
//	
//		
//		double tiempo=0;
//		
//		for(int i=0;i<veces;i++) {
//			for (int j=0;j<size;j++) {
//				arreglo[j]=StdRandom.uniform();
//				
//			}
//			
//			Stopwatch timer = new Stopwatch();
//		Merge.sort(arreglo);
//			tiempo+=timer.elapsedTime();
//		}
//		
//		
//	System.out.println(tiempo);
//		for(int i=1000000;i<1000050;i++) {
//			System.out.println(arreglo[i]+" ");
//		}
		

		
		
//		double insertion=trial("Insertion",2000,1000);
//		double sentinel=trial("S",2000,1000);
		
//		String alg1="Selection";
////		String alg2= "Shell";
//		int times=50;
//		int size=10000;
//		
//		
//		double insertion=trial(alg1,times,size);
////		double selection=trial(alg2,times,size);
//		
//		System.out.println("Tiempo para Insertion: "+insertion);
//		System.out.println("Tiempo para Sentinel: "+sentinel);
		
		
		



