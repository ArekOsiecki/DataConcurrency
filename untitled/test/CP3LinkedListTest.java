import org.junit.jupiter.api.Test;
import org.w3c.dom.Node;


import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class CP3LinkedListTest {

    @Test
    void addFirst() {
    }

    @Test
    void getFirst() {
    }

    @Test
    void removeFirst() {
    }

    @Test
    void isEmpty() {
        CP3LinkedList<String> myList = new CP3LinkedList();

        boolean actualValue = myList.isEmpty();
        boolean expectedValue = true;
        assertEquals(expectedValue,actualValue);

        myList.addFirst("Sue");
        myList.addFirst("John");
        myList.addFirst("Joe");

        actualValue = myList.isEmpty();
        expectedValue = false;
        assertEquals(expectedValue,actualValue);


    }

    @Test
    void getLast() {
        CP3LinkedList<String> myList = new CP3LinkedList();

        String lastItem;
        String actualLast;

        myList.addLast("Sue");
        myList.addLast("John");
        myList.addLast("Joe");

        lastItem = myList.getLast();
        actualLast = "Joe";
        assertEquals(lastItem,actualLast);

    }
 /*   @Test(expected = NoSuchElementException.class)
    public void getLastOnEmpty(){
        CP3LinkedList<String> myList = new CP3LinkedList();

        String lastItem = myList.getLast();

    }*/

    @Test
    void getAddedAfter(){
        CP3LinkedList<String> myList= new CP3LinkedList();

        String beforeItem;
        String actualBefore;

        myList.addLast("George");
        myList.addLast("Sue");
        myList.addLast("John");
        myList.addLast("Joe");

        myList.addAfter("Janusz",myList.first);

        beforeItem = myList.getAddedAfter();


    }
}