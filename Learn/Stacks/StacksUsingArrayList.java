import java.util.ArrayList;

public class StacksUsingArrayList {

    public static class Stacks {
        static ArrayList<Integer> list = new ArrayList<>();

        // to check if stack is empty
        public static boolean isEmpty() {
            return list.size() == 0;
        }

        // to push element
        public static void push(int data) {
            list.add(data);
        }

        // to pop element
        public static int pop() {
            if (isEmpty()) {
                return -1;
            }
            int top = list.get(list.size() - 1);
            list.remove(list.size() - 1);
            return top;
        }

        // to peek
        public static int peek() {
            int top = list.get(list.size() - 1);
            return top;
        }

    }

    public static void main(String[] args) {
        Stacks stack1 = new Stacks();
        stack1.push(0);
        stack1.push(1);
        stack1.push(2);
        stack1.push(3);

        while (!stack1.isEmpty()) {
            System.out.println(stack1.peek());
            stack1.pop();

        }
    }

}
