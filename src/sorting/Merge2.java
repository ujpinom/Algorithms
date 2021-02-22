package sorting;

import java.util.Arrays;

public class Merge2 {

	public static void merSort(Comparable [] lista,Comparable longitud) {
		
		
		
		if(lista.length>1) {
			
			Comparable [] lista1=Arrays.copyOfRange(lista, 0, lista.length/2);
			
			merSort(lista1,longitud);
		
			Comparable [] lista2=Arrays.copyOfRange(lista,lista.length/2 , lista.length);
			
			merSort(lista2,longitud);
			
			
			Comparable [] tem= merge(lista1,lista2);
			System.arraycopy(tem, 0, lista, 0, tem.length);
			
		}

	
	}
	
	
	public static Comparable [] merge (Comparable []lista1,Comparable [] lista2) {
		
		Comparable [] tem= new Comparable [lista1.length+lista2.length];
		
		
		int actual1=0;
		int actual2=0;
		int actual3=0;
		
		
		while(actual1<lista1.length && actual2<lista2.length) {
			
			if(lista1[actual1].compareTo(lista2[actual2])<0) {
				tem[actual3]=lista1[actual1];
				++actual3;
				++actual1;
			}
			else {
				tem[actual3]=lista2[actual2];
				++actual3;
				++actual2;
			}
			
		}
		
		while(actual1<lista1.length) {
			tem[actual3]=lista1[actual1];
			++actual3;
			++actual1;
		}
		
		while(actual2<lista2.length) {
			tem[actual3]=lista2[actual2];
			++actual3;
			++actual2;
		}
		
		return tem;
		
		
	}
	
	
}
