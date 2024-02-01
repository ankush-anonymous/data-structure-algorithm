
public class LinkedList {

    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;

        }
    }

    // initialize head and tail
    public static Node head;
    public static Node tail;
    public static int size;

    // To add a node at first
    public void AddNodeAtFirst(int data) {
        // step1 = create new Node
        Node newNode = new Node(data);
        size++;
        // important step = if there is no node in the linkedList
        if (head == null) {
            head = tail = newNode;
            return;
        }

        // step2 = point newNode's next to head
        newNode.next = head;

        // step3 = now head is newNode
        head = newNode;

    }

    // To add a node at last
    public void AddNodeAtLast(int data) {
        // step1 = create new node
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }

        // step2 = tail's next points to newNode
        tail.next = newNode;

        // step3 = newNode is now the tail
        tail = newNode;
    }

    // to add a node in middle at index i
    public void AddNodeAtMiddle(int data, int idx) {
        Node newNode = new Node(data);
        Node temp = head;
        int i = 0;
        if (idx == 0) {
            AddNodeAtFirst(data);
        }
        while (i < idx - 1) {
            temp = temp.next;
            i++;
        }
        size++;

        newNode.next = temp.next;
        temp.next = newNode;
    }

    // to remove a node from first
    public int RemoveFromFirst() {
        if (size == 0) {
            System.out.println("LinkedList is empty");

            return Integer.MAX_VALUE;
        } else if (size == 1) {
            size = 0;
            int data = head.data;
            head = tail = null;
            return data;
        }

        Node temp = head;
        int data = temp.data;
        temp = temp.next;
        head = temp;
        size--;
        return data;
    }

    // to remove a node from last
    public int RemoveFromLast() {
        if (size == 0) {
            System.out.println("LinkedList is empty");
            return Integer.MAX_VALUE;
        } else if (size == 1) {
            int value = head.data;
            head = tail = null;
            size = 0;
            return value;

        }

        Node temp = head;

        for (int i = 0; i < size - 2; i++) {
            temp = temp.next;
        }

        int data = tail.data;
        temp.next = null;
        tail = temp;
        size--;

        return data;
    }

    // To print Linked List
    public void printLinkedList() {

        Node temp = head;
        if (head == null) {
            System.out.println("null");
        }

        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
        System.out.println("size = " + size);

    }

    // iterative search
    public void iterativeSearch(int key) {
        Node temp = head;
        int i = 0;
        while (temp.data != key) {
            if (temp.next == null) {
                System.out.println("not found");
                return;
            }
            temp = temp.next;
            i++;
        }
        System.out.println("found at: " + (i));
    }

    // recursive search
    public void recursiveSearch(int key, int idx, Node temp) {
        if (temp.next == null) {
            System.out.println("not found");
            return;
        }

        if (temp.data == key) {
            System.out.println("found at: " + idx);
            return;
        }

        recursiveSearch(key, idx + 1, temp.next);

    }

    // ** VERY IMPORTANT **
    // reverse a linked list
    public void reverseLinkedList() {
        Node prev = null;
        Node current = tail = head;

        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }

        head = prev;

    }

    public void FindAndRemoveNthNode(int key) {
        Node prev = null;
        Node current = head;
        while (current.next != null) {

        }
    }

    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        list1.AddNodeAtFirst(2);
        list1.AddNodeAtFirst(1);
        list1.AddNodeAtFirst(0);
        list1.AddNodeAtLast(3);
        list1.AddNodeAtLast(4);

        list1.AddNodeAtMiddle(100, 1);

        list1.RemoveFromFirst();

        // list1.iterativeSearch(100);

        Node temp = head;
        list1.recursiveSearch(1, 0, temp);

        list1.reverseLinkedList();

        list1.printLinkedList();

    }
}
