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
        newLink.next = null;
        if(last == null){
            first = newLink;
        }else{
            last.next = newLink;
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
    /**method to out print contents of the list, debugging purposes only*/
    public void print(){
        //output contents of the list
        Node current = first;

        while(current != null){
            System.out.println(current.data);
            current = current.next;
        }
    }
}
