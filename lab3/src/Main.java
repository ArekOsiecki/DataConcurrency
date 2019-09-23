import java.util.Deque;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {

    }

    public static boolean isBalanced(String expression) {
        Deque<Character> myStack = new LinkedList();
        boolean balanced = true;
        int index = 0;

        while (balanced && index < expression.length()) {
            char ch = expression.charAt(index);
            if (isOpen(ch)) {
                myStack.push(ch);
            } else if (isClosed(ch)) {
                if (myStack.isEmpty()) {
                    balanced = false;
                } else {
                    char topChar = myStack.pop();
                    if (!areMatching(topChar,ch)) {
                        balanced = false;
                    }
                }
            }
            index++;
        }

        if (balanced && myStack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    private static boolean isOpen(char ch){
        if(ch == '(' || ch == '[' || ch == '<' || ch == '{'){
            return true;
        }else{
            return false;
        }
    }
    private static boolean isClosed(char ch){
        if(ch == ')' || ch == ']' || ch == '>' || ch == '}'){
            return true;
        }else{
            return false;
        }
    }
    private static boolean areMatching(char c1, char c2){
        if( c1 == '(' && c2 == ')' || c1 == '[' && c2 == ']'
                || c1 == '<' && c2 == '>' || c1 == '{' && c2 == '}'){
            return true;
        }else{
            return false;
        }
    }

}
