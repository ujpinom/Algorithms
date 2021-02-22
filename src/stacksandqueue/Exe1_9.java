package stacksandqueue;

import edu.princeton.cs.algs4.StdIn;

public class Exe1_9 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Lstack<String> valores= new Lstack<>();
		Lstack<String>operadores= new Lstack<>();
		
		while (!StdIn.isEmpty())
		{
			
			String s=StdIn.readString();
			
			if(s.equals("*")||s.equals("+")||s.equals("-")||s.equals("/")) {
				operadores.push(s);
				
			}
			else if(s.equals(")")) {
				String val1=valores.pop();
				String val2=valores.pop();
				String nuevoOperador="("+val2+" "+operadores.pop()+" "+val1+")";
				valores.push(nuevoOperador);
			}
			else {
				valores.push(s);
			}
		
		}
		
		String 	resultado=valores.peek();
		System.out.println(resultado);

	}

}
