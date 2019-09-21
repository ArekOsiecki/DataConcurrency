import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        ArrayList<String> myAList = new ArrayList();
        LinkedList<String> myLList = new LinkedList();
        int size = 0;
        try {   // The name of the file which we will read from
            String filename = "words_alpha.txt";

            // Prepare to read from the file, using a Scanner object
            File file = new File(filename);
            Scanner in = new Scanner(file);

            // Read each line until end of file is reached
            while (in.hasNextLine()) {
                // Read one string from the file
                String str = in.nextLine();
                // add str to ArrayList and LinkedList
                myAList.add(str);
                myLList.add(str);
                size++;


            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");

        }

        System.out.println("Size of list: "+size);


        testGetForArrayList(myAList);
        testGetForLinkedList(myLList);


        System.exit(0);

    }
    public static void testGetForArrayList(ArrayList aList) {
        long startTime = System.currentTimeMillis();
        testGetForList(aList);
        long endTime = System.currentTimeMillis();

        System.out.println("Process for Array List took: "+(endTime - startTime)+ " ms");


    }
    public static void testGetForLinkedList(LinkedList lList) {
        long startTime = System.currentTimeMillis();
        testGetForList(lList);
        long endTime = System.currentTimeMillis();

        System.out.println("Process for Linked List took: "+(endTime - startTime)+ " ms");

    }
    public static void testGetForList(List list) {

        int listSize = list.size();
        Random random = new Random();
        int reps = 50000;
        for(int i = 0; i < reps; i++) {
            // reps is the number of repetitions
            // declare reps as something large e.g. 10000000
            list.get(random.nextInt(listSize)); // list is your list
            // (ArrayList or LinkedList)
        }
    }
    public static void testSetForArrayList(ArrayList aList) {
        long startTime = System.currentTimeMillis();
        testSetForList(aList);
        long endTime = System.currentTimeMillis();

        System.out.println("Process for Array List took: "+(endTime - startTime)+ " ms");


    }
    public static void testSetForLinkedList(LinkedList lList) {
        long startTime = System.currentTimeMillis();
        testSetForList(lList);
        long endTime = System.currentTimeMillis();

        System.out.println("Process for Linked List took: "+(endTime - startTime)+ " ms");

    }
    public static void testSetForList(List list) {
        int listSize = list.size();
        Random random = new Random();
        int reps = 50000;
        for (int i = 0; i < reps; i++)
            list.set(random.nextInt(listSize),listSize);  // 47 just a random number
    }
    /*public static void testInsertForList(List list) {
        int reps = 50000;
        for (int i = 0; i < reps; i++)
            list.add(5, “test”); // minimize random-access cost
    }
    public static void testRemoveForList(List list) {
        while (list.size() > 5)
            list.remove(5); // Minimize random access cost // 5 an arbitrary number
    }*/





}
