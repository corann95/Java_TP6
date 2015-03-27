import java.util.Iterator;


//Main for test with console and log

public class MainTest {



	public static void main(String[] args) {		
		testArrayList();
		System.out.println(" ");
		testArrayListIterator();
		System.out.println(" ");
		testLinkedList();
		System.out.println(" ");
		testLinkedListIterator();
	}

	public static void  testArrayList(){
		ArrayList<String> array = new ArrayList<String>();
		System.out.println("-------------TEST ARRAYLIST-----------");
		array.add("firstElement");
		array.add("secondElement");
		array.add("thirdElement");

		System.out.println("ArrayList - result of get(0): "+array.get(0));
		System.out.println("ArrayList - result of get(1): "+array.get(1));
		System.out.println("ArrayList - result of get(2): "+array.get(2));

		System.out.println("ArrayList - result of indexOf('firstElement'): "+array.indexOf("firstElement"));
		System.out.println("ArrayList - result of get('secondElement'): "+array.indexOf("secondElement"));
		System.out.println("ArrayList - result of get('thirdElement'): "+array.indexOf("thirdElement"));

		System.out.println("ArrayList - result of size(): "+array.size());

		System.out.println("result of remove('thirdElement'): "+array.remove("thirdElement"));
		System.out.println("result of indexOf('thirdElement'), after removed: "+array.indexOf("thirdElement"));
		System.out.println("-------------TEST ARRAY END-----------");

	}
	public static void testArrayListIterator(){
		System.out.println("-------------TEST ARRAYLIST ITERATOR-----------");
		ArrayList<String> array_test = new ArrayList<String>();
		array_test.add("Toto");
		array_test.add("Tata");
		array_test.add("Tutu");
		for ( Iterator <String> i = array_test.iterator(); i. hasNext(); ){
			System .out . println (i.next());
		}
		System.out.println("-------------TEST ARRAYLIST ITERATOR END-----------");
	}

	public static void  testLinkedList(){
		LinkedList<String> linked_list = new LinkedList<String>();
		System.out.println("-------------TEST LINKKEDLIST-----------");
		linked_list.addFirst("first_Element");
		linked_list.addLast("second_Element");
		linked_list.addLast("third_Element");
		System.out.println("LinkedList - result of get(0): "+linked_list.get(0));
		System.out.println("LinkedList - result of get(1): "+linked_list.get(1));
		System.out.println("LinkedList - result of get(2): "+linked_list.get(2));

		System.out.println("LinkedList - result of size(): " +linked_list.size());

		System.out.println("LinkedList - result of pop(): " +linked_list.pop().toString());
		System.out.println("LinkedList - result of poll(): " +linked_list.poll().toString());
		System.out.println("LinkedList - result of peek(): " +linked_list.peek().toString());
		System.out.println("LinkedList - result of peekLast(): " +linked_list.peekLast().toString());

		System.out.println("LinkedList - result of remove('third_Element'): "+linked_list.remove("third_Element"));

		System.out.println("adding a Element at index 0");
		linked_list.addFirst("Test_Element");

		System.out.println("LinkedList - result of remove(0): "+linked_list.remove(0).toString());

		System.out.println("-------------TEST LINKKEDLIST END-----------");
	}
	public static void testLinkedListIterator(){
		System.out.println("-------------TEST LINKEDLIST ITERATOR-----------");
		LinkedList<String> linked_test = new LinkedList<String>();
		linked_test.addFirst("Yoyo");
		linked_test.addLast("Yaya");
		linked_test.addLast("Yuyu");
		for ( Iterator <String> i = linked_test.iterator(); i. hasNext(); ){
			System .out . println (i.next());
		}
		System.out.println("-------------TEST LINKEDLIST ITERATOR END-----------");
	}



}
