import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class Lab5 {
    public static void main(String[] args) {
        
        List<String> arrList = new ArrayList();
        List<String> linkList = new LinkedList();

        //populate both lists with contents of a data file
        try {   // The name of the file which we will read from
            String filename = "words_alpha.txt"; //file in project folder
            //String filename = "C:\\Users\\t00012345\\Desktop\\words_alpha.txt"; //can have file in any folder

            // Prepare to read from the file, using a Scanner object
            File file = new File(filename);
            Scanner in = new Scanner(file);

            // Read each line until end of file is reached
            while (in.hasNextLine()) {
                // Read one string from the file
                String str = in.nextLine();

                // add str to ArrayList and LinkedList
                arrList.add(str);
                linkList.add(str);
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
        }

        // call testGetForArrayList, testGetForLinkedList,  testInsertForArrayList etc to test get, insert and remove for ArrayList and LinkedList.

        long startTime = System.currentTimeMillis();
        testGetForArrayList(arrList);
        long endTime = System.currentTimeMillis();
        long timeTaken = endTime - startTime;
        System.out.println("time for ArrayList get " + timeTaken);

        startTime = System.currentTimeMillis();
        testGetForLinkedList(linkList);
        endTime = System.currentTimeMillis();
        timeTaken = endTime - startTime;
        System.out.println("time for LinkedList get " + timeTaken);
    }

    public static void testGetForArrayList(List list) {
        testGetForList(list);
    }

    public static void testGetForLinkedList(List list) {
        testGetForList(list);
    }

    public static void testGetForList(List list) {
        int listSize = list.size();
        
        Random random = new Random();
        int reps = 50000;
        for(int i = 0; i < reps; i++) {
            // reps is the number of repetitions
            // declare reps as something large e.g. 50000
            list.get(random.nextInt(listSize)); // list is your list
            // (ArrayList or LinkedList)
        }
    }
}