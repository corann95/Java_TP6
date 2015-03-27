import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;



//cours 6 and TP6
////Question 3 and 5


public class ArrayList <T> {
	
	static final int DEFAULT_CAPACITY = 10;
	private T [] data ;
	private int size = 0;
	
	public ArrayList () { 
		data = (T[]) new Object [ DEFAULT_CAPACITY ]; 
	}
	public int size () { 
		return size ; 
	}
	public void add (T e) {
		if (size == data.length)
			 ensureCapacity (size + 1);
		data [ size ] = e;
		++ size ;
	}
	public T get( int i) {
		/*if(i < 0 || i >= size ) {
		// OutOfBoundException doesn't work (cours 6 pdf)
		}*/
		return data [i];
	}
	
	private void ensureCapacity (int min_capacity) {
		int current_capacity = data.length;
		
		    if (min_capacity > current_capacity)
		       {
		         T[] new_data = (T[]) new Object[Math.max(current_capacity * 2, min_capacity)];
		         System.arraycopy(data, 0, new_data, 0, size);
		         data = new_data;
		       }
	}
   
	public int indexOf(Object o){
		if (o == null) {
	        for (int i = 0; i < size; i++)
				 if (data[i]==null)
	                  return i;
		}
		else{
	      for (int i = 0; i < size; i++)
	        if (o.equals( data[i]))
	          return i;
		}
	     return -1;
	}
	public T remove(int index){
	      checkIndex(index);
	      T t = data[index];
	      if (index != --size)
	        System.arraycopy(data, index + 1, data, index, size - index);
	      data[size] = null;
	      return t;
    }
	
	private void checkIndex(int index) {
		      if (index >= size)
		        throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);		 		
	} 
	public boolean remove(Object o) {
		 if (o == null) {
			 for (int index = 0; index < size; index++)
				 if (data[index] == null) {
					 removeByIndex(index);
					 return true;
				 }
		 } else {
			 for (int index = 0; index < size; index++)
				 if (o.equals(data[index])) {
					 removeByIndex(index);
					 return true;
				 }
		 }
		 return false;
	 }
	 private void removeByIndex(int index) {
	       int num_moved = size - index - 1;
		    if (num_moved > 0)
		        System.arraycopy(data, index+1, data, index, num_moved);
		    data[--size] = null; 
	 }
	 
	//Q5
	 public Iterator<T> iterator() {
		      return new IteratorArrayList();
	 }


  public class IteratorArrayList implements Iterator<T> {

	 public int cursor_index;   
	 
	 public IteratorArrayList(){
		 cursor_index=0;
	 }
	 
	 public boolean hasNext() {
		    return (cursor_index != size);

	  }
	 public T next() {
		 if (cursor_index >= size)
			 throw new NoSuchElementException();
		 return data[cursor_index++];
	 }
	 
		
  }
		  
}
