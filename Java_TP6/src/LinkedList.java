import java.util.Iterator;
import java.util.NoSuchElementException;

//Question 4.1, 4.2, 5

public class LinkedList<T>{


	private Node <T> head ;
	private Node <T> last ;
	private int size = 0;


	public LinkedList() {

	}

	public int size() {
		return size;
	}

	public void addFirst(T o) {
		Node<T> e = new Node(o);

		if (size == 0){
			head = last = e;

		}	        
		else{
			e.next=head;
			head.previous=e;
			head = e;
		}
		size++;
	}
	public void addLast(T o) {
		Node<T> e = new Node(o);
		if (size == 0){
			head = last;
			last = e;
		}
		else{
			e.previous = last;
			last.next = e;
			last = e;
		}
		size++;

	}

	public T get(int index){
		checkIndex(index);
		return getNode(index).data;
	}
	Node<T> getNode(int index) {		
		Node<T> e;
		if (index < size / 2)
		{
			e = head;
			while (index-- > 0)
				e = e.next;
		}
		else
		{
			e = last;
			while (++index < size)
				e = e.previous;
		}
		return e;		    
	}
	
	private void checkIndex(int index)  {
		if (index < 0 || index >= size)
			throw new IndexOutOfBoundsException("Index: " + index + ", Size:"+ size);
	}
	
	public T pop() {
		return removeFirst();
	}
	
	public T removeFirst()   {
		if (size == 0)
			throw new NoSuchElementException();
		size--;
		T t = head.data;
		if (head.next != null){
			head.next.previous=null;
		}
		else{
			last = null;
		}
		head = head.next;
		return t;
	}
	
	public T poll() {
		if (size == 0)
			return null;
		return removeFirst();
	}
	
	public T peekFirst(){
		return peek();
	}
	
	public T peek()  {
		if (size == 0)
			return null;
		return getFirst();
	}
	
	public T getFirst() {
		if (size == 0)
			throw new NoSuchElementException();
		return head.data;
	}
	
	public T peekLast() {
		if (size == 0)
			return null;
		return getLast();
	}
	
	public T getLast(){
		if (size == 0)
			throw new NoSuchElementException();
		return last.data;
	}
	
	public boolean remove(Object o){
		Node<T> e = head;
		while (e != null)
		{
			if (o.equals(e.data))
			{
				removeNode(e);
				return true;
			}
			e = e.next;
		}
		return false;
	}

	void removeNode(Node<T> e){
		size--;
		if (size == 0)
			head = last = null;
		else
		{
			if (e == head)
			{
				head = e.next;
				e.next.previous=null;
			}
			else if (e == last)
			{
				last = e.previous;
				e.previous.next=null;
			}
			else
			{
				e.next.previous=e.previous;
				e.previous.next=e.next;
			}
		}
	}
	public T remove(int index) {
		checkIndex(index);
		Node<T> e = getNode(index);
		removeNode(e);
		return e.data;
	}

	//Q5
	public Iterator<T> iterator() {
		return new IteratorLinkedList(head);
	}
	public class IteratorLinkedList implements Iterator<T> {

		Node<T> cursor_node;

		public IteratorLinkedList(Node<T> start_head){
			cursor_node = start_head;
		}

		public boolean hasNext() {
			return (cursor_node != null);
		}

		public T next() {
			if (!hasNext())
				throw new NoSuchElementException();
			Node<T> t_node  = cursor_node;
			cursor_node=cursor_node.next;
			return t_node.data;
		}


	}
}
