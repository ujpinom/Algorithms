package stacksandqueue;
import java.util.Scanner;

import analisisAlg.BSv_2;
import union_find.BinarySerch;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Iterator;
import edu.princeton.cs.algs4.*;
import edu.princeton.cs.algs4.Queue;
public class pruebaRstack {


    // Parametes example: 5 10
    public static void main(String[] args) throws FileNotFoundException {
    	
    	
    	int[] testArray1 = {3, 4, 4, 5, 6, 10, 15, 20, 20, 20, 20, 21};
    	
    	
    	System.out.println(BSv_2.BynarySerch(testArray1, 10));
    	
    	
    	
    	
    	
    	
//    	File file = new File("C:\\Users\\SONY\\Desktop\\NumPy\\8Kints.txt");
//    	Scanner input = new Scanner(file);
//    	int [] numeros=new int [8000];
//    	int i=0;
//    	while(input.hasNext()) {
//    		
//    		int numero=Integer.parseInt(input.next());
//    		numeros[i]=numero;
//    		++i;
//    		
//    	}
//    	
//    	input.close();
//    	Stopwatch timer = new Stopwatch();
//    	int threesum=fast3sum(numeros);
//    	double tiempo=timer.elapsedTime();
//       System.out.println(threesum+" en "+ tiempo);
       
       
    	
    }
    public static int fast3sum(int [] N) {
    	
    	int count=0;
    	int longitud=N.length;
    	Arrays.sort(N);
    	
    	for(int i=0;i<longitud;i++) {
    		for(int j=i+1;j<longitud;j++) {
    			
    			if(BinarySerch.binarySerch(N,-(N[i]+N[j]))>j) {

    				count++;
    			}
    			
    		}
    	}
    	
    	return count;
      	
    }
    
    public static int count(int[] a)
    { // Count triples that sum to 0.
    int N = a.length;
    int cnt = 0;
    for (int i = 0; i < N; i++)
    for (int j = i+1; j < N; j++)
    for (int k = j+1; k < N; k++)
    if (a[i] + a[j] + a[k] == 0)
    cnt++;
    return cnt;
    }
}
	
