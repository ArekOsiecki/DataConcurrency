public class Fibonacci {

    public static int iterativeF(int n){
        if(n <= 1) {
            return n;
        }
        int num = 1;
        int prevNum = 1;

        for(int i=2; i<n; i++) {
            int temp = num;
            num += prevNum;
            prevNum = temp;
        }
        return num;

    }
    public static int recursiveF(int n) {
        if ((n == 0) || (n == 1))
            return n;
        else
            return recursiveF(n - 1) + recursiveF(n - 2);
    }
}
