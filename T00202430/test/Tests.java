import org.junit.jupiter.api.Test;

import java.io.File;
import java.lang.reflect.Array;
import java.util.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class Tests {
    @Test
    public void testHeight(){

        //Tree with height 3
        BinarySearchTreeMap<String, String> bstMap = new BinarySearchTreeMap();
        int height = 3;

        bstMap.put("Jack", "0871231231");
        bstMap.put("Jill", "0877654321");
        bstMap.put("Bob", "0871234567");
        bstMap.put("Rob", "0851212121");

        assertEquals(height,bstMap.height());

        //Tree with height 0
        BinarySearchTreeMap<String, String> bstMap2 = new BinarySearchTreeMap();
        int height2 = 0;

        assertEquals(height2,bstMap2.height());
    }

    @Test
    public void testSetKey(){
        BinarySearchTreeMap<String, String> bstMap = new BinarySearchTreeMap();

        bstMap.put("Jack", "0871231231");
        bstMap.put("Jill", "0877654321");
        bstMap.put("Bob", "0871234567");
        bstMap.put("Rob", "0851212121");

        Set expected = bstMap.keySet();

        Set actual = new TreeSet();

        actual.add("Jack");
        actual.add("Jill");
        actual.add("Bob");
        actual.add("Rob");

        assertEquals(expected, actual);

        BinarySearchTreeMap<String, String> bstMap2 = new BinarySearchTreeMap();
        Set expected2 = bstMap2.keySet();
        Set actual2 = new TreeSet();

        assertEquals(expected2, actual2);

        BinarySearchTreeMap<String, String> bstMap3 = new BinarySearchTreeMap();

        bstMap.put("Jack", "0871231231");

        Set expected3 = bstMap3.keySet();
        Set actual3 = new TreeSet();

        assertEquals(expected3,actual3);

    }

    @Test
    void testSearch(){

        InvertedIndex index = new InvertedIndex();
        File file = new File("TeXts/");
        List<File> fileAsList = new ArrayList<>(Arrays.asList(file.listFiles()));

        index.buildIndex(fileAsList);

        List<File> searchFor = index.search("proposal");
        List<File> expected = new ArrayList<>(Arrays.asList(file.listFiles()[0],file.listFiles()[1],file.listFiles()[2]));
        assertEquals(searchFor, expected);

        InvertedIndex index2 = new InvertedIndex();
        File file2 = new File("TeXts/");
        List<File> fileAsList2 = new ArrayList<>(Arrays.asList(file2.listFiles()));

        index2.buildIndex(fileAsList2);

        List<File> searchFor2 = index.search("visions");
        List<File> expected2 = new ArrayList<>(Arrays.asList(file.listFiles()[0],file.listFiles()[1],file.listFiles()[2]));
        assertEquals(searchFor2, expected2);

    }
}
