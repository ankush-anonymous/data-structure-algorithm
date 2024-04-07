import java.util.Stack;

public class DuplicateParenthesis {
    public static boolean checkDuplicateParenthesis(String str) {
        Stack<Character> stack = new Stack<>();
        System.out.println(str);
        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            if (currentChar != ')') {
                stack.push(currentChar);
            } else {
                int count = 0;
                while (stack.peek() != '(') {
                    stack.pop();
                    count++;
                }
                if (count < 1) {
                    stack.pop();
                    return true;
                }
            }
        }
        return false;

    }

    public static void main(String[] args) {
        System.out.println(checkDuplicateParenthesis("(a+b)"));
    }
}
