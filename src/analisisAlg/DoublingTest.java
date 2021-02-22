package analisisAlg;

import java.util.Arrays;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;
import union_find.BinarySerch;

public class DoublingTest {
	
	public static void main(String args[] ) {
		
		double prev = timeTrial(125);
		for (int N = 250; N<=32000; N += N)
		{
		double time = timeTrial(N);
		StdOut.printf("%6d %7.1f ", N, time);
		StdOut.printf("%5.1f\n", time/prev);
		prev = time;
		}
	}
	
	public 	static double timeTrial(int N) {

		int MAX=1000000;
		int [] a=new int[N];
		
		
		for(int i=0;i<N;i++) {
			a[i] = StdRandom.uniform(-MAX, MAX);
		}
		
		Stopwatch timer = new Stopwatch();
		int cnt = fast3sum(a);
		return timer.elapsedTime();
		
		
	}
	
	public static  int count(int []a) {
		
	    int N = a.length;
	    int cnt = 0;
	    for (int i = 0; i < N; i++)
	    for (int j = i+1; j < N; j++)
	    for (int k = j+1; k < N; k++)
	    if (a[i] + a[j] + a[k] == 0)
	    cnt++;
	    return cnt;
		
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
	
}
