package searching;

import java.util.Iterator;

import edu.princeton.cs.algs4.Queue;

public class SelfOrganizigSearch<K,V> implements Iterable<K>{
	
	private K [] keys;
	private V [] valores;
	private int N;
	private final  int tamanioDefecto=2;
	
	
	public SelfOrganizigSearch(int capacidad) {
		
		keys=(K[])new Object[capacidad];
		
		valores=(V[]) new Object[capacidad];

	}
	
	public SelfOrganizigSearch() {
		
		keys=(K[])new Object[tamanioDefecto];
		
		valores=(V[]) new Object[tamanioDefecto];
		
	}
	
	
	public void put(K k,V v) {
		
		if(k==null) {
			throw new IllegalArgumentException("Argumento nulo no permitido");
		}
		
		
		if(N==keys.length) {
			resize(N*2);
		}
		
		int j=contiene(k);
		
		if(j<0) {
			
			for(int i=N;i>0;--i) {
				
				keys[i]=keys[i-1];
				valores[i]=valores[i-1];
				
			}
			
			keys[0]=k;
			valores[0]=v;	
			++N;
			
		}
		else {
			
			valores[j]=v;
			
		}
		
	}
	
	public void resize(int tamanio) {
		
		K [] temp1= (K[])new Object[tamanio];
		V [] temp2= (V[])new Object[tamanio];
		
		
		for(int i=0;i<size();i++) {
			temp1[i]=keys[i];
			temp2[i]=valores[i];
		}
		
		
		keys=temp1;
		valores=temp2;
		
		
	}
	
	public int contiene(K k) {
		
		for(int i=0;i<N;i++) {
			
			if(keys[i].equals(k)) {
				return i;
			}
		}
		
		
		return -1;
	}
	
	public V get(K k) {
		
		int j=contiene(k);
		
		if(j<0) {
			return null;
		}
		else {
			
			K temp=keys[j];
			V temp1=valores[j];
			
			for(int i=j;i>0;i--) {
				
				keys[i]=keys[i-1];
				valores[i]=valores[i-1];
				
			}
			
			keys[0]=temp;
			valores[0]=temp1;
			
			return valores[0];

		}
		

	}
	
	
	public void borrar(K k) {
		
		if(k==null) {
			throw new IllegalArgumentException("Argumento nulo no permitido");
		}
		
		int j=contiene(k);
		
		if(j<0) {
			return;
		}
		else {
			
			if(N>1 && N==keys.length/4) {
				resize(keys.length/4);
			}
			
			for(int i=j;i<N-1;i++) {
				
				keys[i]=keys[i+1];
				valores[i]=valores[i+1];
				
			}
			
			valores[N]=null;
			keys[N]=null;
			--N;
			
		}
	}

	public int size() {
		return N;
	}
	
	public boolean isEmpty() {
		return N==0;
	}
	

	public static void main(String[] args) {

		SelfOrganizigSearch<Integer,String> hola= new SelfOrganizigSearch<>();
		
			hola.put(10, "Valor1");
			hola.put(11, "Valor2");
			hola.put(12, "Valor3");
			hola.put(13, "Valor4");
			hola.put(14, "Valor5");
			hola.put(14, "Valor5");
		
		System.out.println("Numero de elementos: "+hola.size());
		
		hola.borrar(14);
		hola.borrar(12);
		hola.borrar(13);
		hola.borrar(111);
		
		System.out.println("Numero de elementos: "+hola.size());
		
		Queue<Integer> saludo= (Queue<Integer>) hola.lista();
		
		for(Integer i:saludo) {
			
			System.out.println(hola.get(i));
		}
			
	}
	
	public Iterable<K> lista(){
		
		Queue<K> cola=new Queue<>();
		
		for(int i=0;i<N;i++) {
			cola.enqueue(keys[i]);
		}
		
		return cola;
		
	}


	@Override
	public Iterator<K> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

}
