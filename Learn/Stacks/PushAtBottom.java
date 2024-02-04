
import java.util.*;

public class PushAtBottom {

    public static void pushAtBottom(Stack<Integer> stack, int value) {
        if (stack.isEmpty()) {
            stack.push(value);
            return;
        }

        int top = stack.pop();
        pushAtBottom(stack, value);
        stack.push(top);

    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(3);
        stack.push(2);
        stack.push(1);

        pushAtBottom(stack, 4);

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());

        }
    }

}
