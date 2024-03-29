import java.util.Set;
import java.util.TreeSet;

/**
 * This class implements a Map based binary search tree whose
 * nodes hold keys (of type K) that implement the Comparable
 * interface and associated values (of type V).
 */

public class BinarySearchTreeMap<K extends Comparable<K>, V> {
    private Node root;

    private class Node {
        public K key;
        public V val;
        public Node left;
        public Node right;
    }

    public BinarySearchTreeMap() {
        root = null;
    }

    /* Insert key-value pair into BinarySearchTreeMap
       If key already exists, ignore it
    */
    // insert renamed to put, to match Map interface
    public void put(K k, V v) {
        Node newNode = new Node();
        newNode.key = k;
        newNode.val = v;
        newNode.left = null;
        newNode.right = null;
        if (root == null)
            root = newNode;
        else
            insertSub(root, newNode);
    }

    private void insertSub(Node node, Node newNode) {
        if (newNode.key.compareTo(node.key) < 0) {
            if (node.left == null)
                node.left = newNode;
            else
                insertSub(node.left, newNode);
        } else if (newNode.key.compareTo(node.key) > 0) {
            if (node.right == null)
                node.right = newNode;
            else
                insertSub(node.right, newNode);
        }
        //else duplicate keys not allowed
        // key already in tree => do nothing
    }

    public void print() {
        if (root != null)
            printSub(root);
    }

    private void printSub(Node node) {
        if (node != null) {
            printSub(node.left);
            System.out.println(node.key + " " + node.val);
            printSub(node.right);
        }
    }
    public Set<K> keySet() {
        Set<K> mySet = new TreeSet<>();
        if(root != null){
            keySetSub(root, mySet);
        }
        return mySet;
    }
    private void keySetSub(Node node, Set mySet){
        if(node != null){
            keySetSub(node.left , mySet);
            mySet.add(node.key);
            keySetSub(node.right , mySet);
        }
    }
    /*
     *  Search BinarySearchTreeMap for given key, and return associated value if found,
     *  return null if not found
     */
    public V get(K key) {
        Node node = root;
        while (node != null) {
            int cmp = key.compareTo(node.key);
            if (cmp < 0)
                node = node.left;
            else if (cmp > 0)
                node = node.right;
            else return node.val;
        }
        return null;
    }


    // does there exist a key-value pair with given key?
    public boolean containsKey(K key) {
        return get(key) != null;
    }

    public int height(){
        return heightSub(root);  // calls the helper method
    }

    private int heightSub(Node currentNode) {
        //find the height of the subtree rooted at currentNode
        if (currentNode == null)
            return 0; //empty tree => height = 0
        else {
            int max = Math.max(heightSub(currentNode.left), heightSub(currentNode.right));
            return 1 + max;
        }
    }

    // sample client code
    public static void main(String[] args) {
        BinarySearchTreeMap<String, String> bstMap = new BinarySearchTreeMap();

        // insert some key-value pairs e.g. name, mobile number 
        bstMap.put("Jack", "0871231231");
        bstMap.put("Jill", "0877654321");
        bstMap.put("Bob", "0871234567");
        bstMap.put("Rob", "0851212121");

        bstMap.put("Jill", "0867654321");  //what happens here?

        bstMap.print();

        //System.out.println("Size of tree: "+ bstMap.size());

        // search for mobile number given name
        String number = bstMap.get("Jill");
        System.out.println(number); //what output do you expect here?

        number = bstMap.get("Bill");
        System.out.println(number); //what output do you expect here?

        if (bstMap.containsKey("Sam"))
            System.out.println("Sam is on the tree");
        else
            System.out.println("Sam is not on the tree");

        //To do write code for keySet() method
       Set<String> set = bstMap.keySet();
       System.out.println(set);




    }

}

