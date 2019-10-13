public class Main {
    public static void main(String[] args) {

        long startTime = System.currentTimeMillis();
        System.out.println(Fibonacci.iterativeF(18));
        long endTime = System.currentTimeMillis();
        System.out.println("Process for iterative took: "+(endTime - startTime)+ " ms");

        long startTime2 = System.currentTimeMillis();
        System.out.println(Fibonacci.recursiveF(18));
        long endTime2 = System.currentTimeMillis();
        System.out.println("Process for recursive took: "+(endTime2 - startTime2)+ " ms");
    }
}
