package sorting;

import java.util.Iterator;

public class PriorityQueue<Key extends Comparable<Key>> {

    enum Orientation {
        MAX, MIN;
    }

    private Key[] priorityQueue; // heap-ordered complete binary tree
    private int size = 0; // in priorityQueue[1..n] with pq[0] unused
    private Orientation orientation;

    public PriorityQueue(int size, Orientation orientation) {
        priorityQueue = (Key[]) new Comparable[size + 1];
        this.orientation = orientation;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int size() {
        return size;
    }

    public void insert(Key key) {
        if (size != priorityQueue.length - 1) {
            size++;

            priorityQueue[size] = key;
            swim(size);
        }
    }

    public Key peek() {
        if (size == 0) {
            throw new RuntimeException("Priority queue underflow");
        }
        return priorityQueue[1];
    }

    public Key deleteTop() {
        if (size == 0) {
            throw new RuntimeException("Priority queue underflow");
        }

        size--;

        Key topElement = priorityQueue[1];
        ArrayUtil.exchange(priorityQueue, 1, size + 1);

        priorityQueue[size + 1] = null;
        sink(1);

        return topElement;
    }

    private void swim(int index) {
        while(index / 2 >= 1) {
            if ((orientation == Orientation.MAX && ArrayUtil.less(priorityQueue[index / 2], priorityQueue[index]))
                    || (orientation == Orientation.MIN && ArrayUtil.more(priorityQueue[index / 2], priorityQueue[index]))) {
                ArrayUtil.exchange(priorityQueue, index / 2, index);
            } else {
                break;
            }

            index = index / 2;
        }
    }

    private void sink(int index) {
        while (index * 2 <= size) {
            int selectedChildIndex = index * 2;

            if (index * 2 + 1 <= size &&
                    (
                    (orientation == Orientation.MAX && ArrayUtil.less(priorityQueue[index * 2], priorityQueue[index * 2 + 1]))
                    || (orientation == Orientation.MIN && ArrayUtil.more(priorityQueue[index * 2], priorityQueue[index * 2 + 1]))
                    )
                    ) {
                selectedChildIndex = index * 2 + 1;
            }

            if ((orientation == Orientation.MAX && ArrayUtil.more(priorityQueue[selectedChildIndex], priorityQueue[index]))
                || (orientation == Orientation.MIN && ArrayUtil.less(priorityQueue[selectedChildIndex], priorityQueue[index]))) {
                ArrayUtil.exchange(priorityQueue, index, selectedChildIndex);
            } else {
                break;
            }

            index = selectedChildIndex;
        }
    }

}
 

class ArrayUtil {

    public static boolean less(Comparable value1, Comparable value2) {
        if (value1.compareTo(value2) < 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean more(Comparable value1, Comparable value2) {
        if (value1.compareTo(value2) > 0) {
            return true;
        } else {
            return false;
        }
    }

    public static void exchange(Comparable[] array, int position1, int position2) {
        Comparable temp = array[position1];
        array[position1] = array[position2];
        array[position2] = temp;
    }

    public static boolean isSorted(Comparable[] array) {
        for(int i = 0; i < array.length - 1; i++) {
            if (more(array[i], array[i+1])) {
                return false;
            }
        }

        return true;
    }

}



//public class PriorityQueue <T extends Comparable<T>> implements Iterable {
//
//	private Comparable [] arreglo;
//	
//	private int N=0;
//	
//	
//	public PriorityQueue() {
//		
//		arreglo=new Comparable[1];
//		
//	}
//	
//	public PriorityQueue(int max) {
//		
//		arreglo=new Comparable [max];
//	}
//	
//	public PriorityQueue(T[] a) {
//		
//		arreglo=a;
//		
//	}
//	
//	
//	public void insert(T v) {
//		
//		if(N==arreglo.length) {
//			resize(2*N);
//		}
//		
//		
//		arreglo[N++]=v;
//		
//		
//	
//	}
//	
//	private void resize(int nueviTamanio) {
//		
//		Comparable[] temp= new Comparable [nueviTamanio];
//		for(int i=0;i<N;i++) {
//			
//			temp[i]=arreglo[i];
//			
//		}
//		
//		arreglo=temp;
//	
//	}
//	
//	
//	public T max() {
//		
//		return (T) arreglo[N];
//		
//	}
//	
//	
//	public T delMin() {
//		
//		int min=0;
//		for(int i=0;i<N-1;i++) {
//			
//			if(arreglo[i+1].compareTo(arreglo[min])<0) {
//				min=i+1;
//			}
//		}
//		
//		intercambiar(N-1,min);
//		
//		T item=(T) arreglo[--N];
//		arreglo[N]=null;
//		
//		
//		if(N<=arreglo.length/4&& N>0) {
//			resize(arreglo.length/4);
//		}
//		int n=arreglo.length;		
//		
//		
//		return item;
//	}
//	
//	
//	public T delMax() {
//		
//		int max=0;
//		for(int i=0;i<N-1;i++) {
//			
//			if(arreglo[i+1].compareTo(arreglo[max])>0) {
//				max=i+1;
//			}
//		}
//		
//		intercambiar(N-1,max);
//		
//		T item=(T) arreglo[N];
//		arreglo[N]=null;
//		--N;
//		
//		if(N<=arreglo.length/4&& N>0) {
//			resize(arreglo.length/4);
//		}
//		
//		return item;
//		
//	}
//	
//	public boolean isEmpty() {
//		
//		return N==0;
//		
//	}
//	
//	public int size() {
//		
//		return N;
//		
//	}
//	
//	private void intercambiar(int i,int j) {
//		
//		Comparable temp=arreglo[i];
//		
//		arreglo[i]=arreglo[j];
//		
//		arreglo[j]=temp;
//		
//	}
//	
//
//	@Override
//	public Iterator iterator() {
//		
//		return null;
//	}
//	
//	class listaiterator implements Iterator<T>{
//		
//		
//		int i=N;
//
//		@Override
//		public boolean hasNext() {
//			// TODO Auto-generated method stub
//			return i>0;
//		}
//
//		@Override
//		public T next() {
//			
//			return (T) arreglo[--i];
//		}
//		
//	}
//				
//}
