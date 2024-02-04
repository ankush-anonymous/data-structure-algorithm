
public class StacksUsingLinkedList {
    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }

    }

    public static Node head;
    public static Node tail;
    public static int size;

    // isEmpty
    public static boolean isEmpty() {
        return (size == 0);

    }

    // to push element
    public static void push(int data) {
        Node newNode = new Node(data);
        if (isEmpty()) {
            head = tail = newNode;
            return;
        }
        size++;
        newNode.next = head;
        head = newNode;
    }

    // to pop element
    public static int pop() {
        if (isEmpty()) {
            System.out.println("Stack Empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int data = head.data;
            head = tail = null;
            size = 0;
            return data;
        }
        size--;
        int data = head.data;
        head = head.next;
        return data;

    }

    // to peek the stack
    public static int peek() {
        int data = head.data;
        return data;

    }

    public static void main(String[] args) {
        StacksUsingLinkedList stack1 = new StacksUsingLinkedList();
        stack1.push(0);
        stack1.push(1);
        stack1.push(2);
        stack1.push(3);
        stack1.push(4);

        while (!isEmpty()) {
            System.out.println(stack1.peek());
            stack1.pop();
        }

    }
}
