package searching;

public class SymbolTable <Key extends Comparable<Key>,Value > {
	
	private int N;
	
	/**
	 * Crea una Symbol_Table
	 */
	
	public SymbolTable() {
		
	}
	
	/**
	 * Inserta en la tabla el par Key-Value
	 * @param k Key
	 * @param v Valor asociado con k
	 */

	public void put(Key k, Value v) {
		
	}
	
	/**
	 * Retorna el valor asociado con k
	 * @param k
	 * @return Valor asociado con K
	 */
	public Value get(Key k) {
		
	}
	
	/**
	 * Borra k de la tabla y su correspodiente valor asociado
	 * @param k Key
	 */
	
	public void delete(Key k) {
		
	}
	
	public boolean contains(Key k) {
		return get(k)!=null;
	}
	
	
	
	public boolean isEmpty() {
		return size()==0;
		
	}
	
	public int size() {
		return N;
	}
	
	public Key min() {
		
	}
	
	public Key max() {
		
	}
	
	public Key floor() {
		
	}
	
	
	public Key ceiling() {
		
	}
	
	/**
	 * 
	 * @return Numero de keys menores que k
	 */
	
	public int rank(Key k) {
		return 0;
	}
	
	/**
	 * Borra la Key mas pequeña y su correspondiente valor asociado
	 */
	
	public void deleteMin() {
		
		
		
	}
	/**
	 * Borra la key mas grande y su correspodiente valor asociado
	 */
	public void deleteMax() {
		
	}
	
	
	/**
	 * 
	 * @param lo
	 * @param hi
	 * @return El numero de keys entre lo-hi
	 */
	public int size(Key lo, Key hi) {
		return 0;
	}
	
	public Iterable<Key> keys(Key lo, Key hi){
		
	}
	
	public Iterable<Key> keys(){
		
	}
}
