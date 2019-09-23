import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTestTest {

    @Test
    void isBalanced() {

        String a1 = "(a+b*(c/(d–e))+(d/e))";
        boolean actual = Main.isBalanced(a1);
        boolean expected = true;
        assertEquals(actual,expected);

       String a2 = "((((a+b*(c/(d–e))+(d/e)";
        boolean actual2 = Main.isBalanced(a2);
        boolean expected2 = false;
        assertEquals(actual2,expected2);

        String a3 = "[a+{b+<c+(d+e)+f>+g}+h]";
        boolean actual3 = Main.isBalanced(a3);
        boolean expected3 = true;
        assertEquals(actual3,expected3);

    }
}