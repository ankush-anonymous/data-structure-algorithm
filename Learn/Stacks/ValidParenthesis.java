import java.util.Stack;

public class ValidParenthesis {
    public static boolean checkValidParenthesis(String str) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            if (currentChar == '(' || currentChar == '{' || currentChar == '[') {
                stack.push(currentChar);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    if ((stack.peek() == '(' && currentChar == ')') ||
                            (stack.peek() == '[' && currentChar == ']') ||
                            (stack.peek() == '{' && currentChar == '}')) {
                        stack.pop();
                    } else {
                        return false;
                    }

                }
            }

        }

        if (stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public static void main(String[] args) {
        String str = "({})[]";
        System.out.println(checkValidParenthesis(str));

    }

}
