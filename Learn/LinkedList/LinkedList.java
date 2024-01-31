
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

    // To add a node at first
    public void AddNodeAtFirst(int data) {
        // step1 = create new Node
        Node newNode = new Node(data);

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

        if (head == null) {
            head = tail = newNode;
            return;
        }

        // step2 = tail's next points to newNode
        tail.next = newNode;

        // step3 = newNode is now the tail
        tail = newNode;
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

    }

    public static void main(String[] args) {
        LinkedList list1 = new LinkedList();
        list1.AddNodeAtFirst(0);
        list1.printLinkedList();
        list1.AddNodeAtFirst(1);
        list1.printLinkedList();
        list1.AddNodeAtFirst(2);
        list1.printLinkedList();
        list1.AddNodeAtFirst(3);
        list1.printLinkedList();
        list1.AddNodeAtLast(-1);
        list1.printLinkedList();
        list1.AddNodeAtLast(-2);
        list1.printLinkedList();
        list1.AddNodeAtLast(-3);
        list1.AddNodeAtLast(-4);

    }
}
