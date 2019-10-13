import java.util.NoSuchElementException;
//singly linked list with first reference only 

/**
A linked list is a sequence of links with efficient
element insertion and removal. This class 
contains a subset of the methods of the standard
java.util.LinkedList class.
*/

public class CP3LinkedList<E> {
	private class Node {
		public E data;
		public Node next;
		public Node previous;


	}
	Node first;
	Node last;

	/**
	 Constructs an empty linked list.
	 */
	public CP3LinkedList()
	{
		first = null;
		last = null;
	}

	/**
	 Adds an element to the front of the linked list.
	 @param element the element to add
	 */
	public void addFirst(E element)
	{
		Node newLink = new Node();
		newLink.data = element;
		newLink.next = first;
		newLink.previous = null;
		if(first == null){
			last = newLink;
			last.next = null;
		}else{
			first.previous = newLink;

		}

		first = newLink;
	}

	public E getFirst() {
		if (first == null)
			throw new NoSuchElementException();
		return first.data;
	}

	public E removeFirst() {
		if (first == null)
			throw new NoSuchElementException();
		E element = first.data;
		first = first.next;
		return element;
	}

	public void addLast(E element)
	{
		Node newLink = new Node();
		newLink.data = element;
		newLink.previous = last;
		newLink.next = null;
		if(last == null) {
			first = newLink;
			first.previous = null;
		}
		last = newLink;
	}

	public E getLast() {
		if (last == null)
			throw new NoSuchElementException();
		return last.data;

	}

	public void addAfter(E element, Node prevNode){
		//check if prevNode is null
		if(prevNode != null){

			//create newNode and insert data
			Node newLink = new Node();
			newLink.data = element;

			//update next of newNode as next of prevNode
			newLink.next = prevNode.next;

			//update next of prevNode as newNode
			prevNode.next = newLink;

			//update previous of newNode as prevNode
			newLink.previous = prevNode;

			//update previous of newNode next node
			if(newLink.next != null) {
				newLink.next.previous = newLink;
			}
		}
		else{
			throw new NullPointerException("Previous Node cannot be null!");
		}
	}
	public E getAddedAfter(Node prevNode){

		return prevNode.next.data;

	}
	public boolean isEmpty(){
		if (first == null)
			return true;
		else
			return false;

	}

	public int size(){
		Node current = first;
		int cSize = 0;
		while(current != null){
			cSize++;
			current = current.next;
		}
		return cSize;
	}

	public int rSize(Node head){
		if(head == null){
			return 0;
		}else{
			return 1 + rSize(head.next);
		}
	}
	public static int returnSmallest(int a[], int n){
		if(n == 1)
			return a[0];

		return Math.min(a[n-1], returnSmallest(a, n-1));


	}
	public static int binarySearch(int search, int[] array) {

		int start = 0;
		int end = array.length - 1;

		while (start <= end) {

			int middle = (start + end) / 2;

			if (search < array[middle]) {
				end = middle - 1;
			}

			if (search > array[middle]) {
				start = middle + 1;
			}

			if (search == array[middle]) {
				return middle;
			}
		}
		return -1;

	}

	public void print(){
           //outputs the data on the list
		Node current = first;
		while (current != null){
			System.out.println(current.data);
			current = current.next;
		}
	}

	public void recursivePrint(){
		printSub(first);
	}

	private void printSub(Node head){
		if (head != null) {
			System.out.println(head.data);
			printSub(head.next);
		} // do reverse method at home
	}

	public void recursivePrintReverse(){
		printSubReverse(last);
	}

	private void printSubReverse(Node tail){
			if(tail != null) {
				System.out.println(tail.data);
				printSubReverse(tail.previous);
			}
		}
}

