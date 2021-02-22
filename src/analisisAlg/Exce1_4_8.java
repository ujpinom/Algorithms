package analisisAlg;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;
//(n - 1) * n / 2
public class Exce1_4_8 {
	
	public static void main (String a[]) throws FileNotFoundException {
	
	int [] numeros={1, 2, 4, 1, 2, 1, 2, 4, 5, 1, 2, 4, 5, 1, 2 ,5, 6, 7, 7, 8, 2, 1, 2, 4, 5};
	
	
	Arrays.sort(numeros);
	
	
	int contador=0;
	int contador1=1;
	int longitud=numeros.length;
	
	for(int j=0;j<longitud-1;j++) {
		
		if(numeros[j]==numeros[j+1]) {
			contador1++;
			if(j==longitud-2) {
				contador1=contador1*(contador1-1)/2;
				contador+=contador1;
			}
		}
		else {
			
			if(contador1>1) {
				contador1=contador1*(contador1-1)/2;
				contador+=contador1;
				contador1=1;
			}
			
		}
		
	}
	
	
	System.out.println("El número de parejas iguales es: "+contador);
	
	
	sol2(numeros);
	
}
	
	public static void sol2(int [] arreglo) {
		
		Map<Integer,Integer> map= new TreeMap<>();
		
		int contador=0;
		
		for(int i=0;i<arreglo.length;i++) {
			
			if(!map.containsKey(arreglo[i])) {
				map.put(arreglo[i], 1);
			}
			else {
				int con=map.get(arreglo[i]);
				++con;
				map.put(arreglo[i], con);
			}
		}
		

		 for(int numberKey : map.keySet()) {
			   if (map.get(numberKey) > 1) {
	                int n = map.get(numberKey);
	                contador += (n - 1) * n / 2;
	            }
			 
		 }
		 
		 System.out.println(contador);
		
	}
	
}
