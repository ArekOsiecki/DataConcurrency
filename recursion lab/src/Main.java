public class Main {
    public static void main(String[] args) {

        CP3LinkedList<String> myList = new CP3LinkedList();


        myList.addFirst("Janusz");
        myList.addFirst("Tomasz");
        myList.addFirst("Zbigniew");
        myList.addFirst("Wladyslaw");
        myList.addFirst("Euzebiusz");

      System.out.println("Recursively printed myList: ");
      myList.recursivePrint();

        System.out.println("Recursively reversely printed myList: ");

        myList.recursivePrintReverse();
    }
}
