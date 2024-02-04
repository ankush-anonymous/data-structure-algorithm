import java.util.Stack;

public class ReverseString {

    public static String reverseString(String str) {
        Stack<Character> stack = new Stack<>();
        int idx = 0;

        while (idx < str.length()) {
            stack.push(str.charAt(idx));
            idx++;
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {

            result.append(stack.pop());

        }

        return str = result.toString();

    }

    public static void main(String[] args) {
        System.out.println(reverseString("ankush"));
    }
}
