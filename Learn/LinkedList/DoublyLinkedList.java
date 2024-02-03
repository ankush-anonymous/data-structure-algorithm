
public class DoublyLinkedList {

    public class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
            this.prev = null;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    // add node at first
    public void AddNodeAtFirst(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }

        newNode.next = head;
        head.prev = newNode;
        head = newNode;

    }

    // add node at last
    public void AddNodeAtLast(int data) {
        Node newNode = new Node(data);
        size++;
        if (head == null) {
            head = tail = newNode;
            return;
        }

        tail.next = newNode;
        newNode.prev = tail;
        tail = newNode;

    }

    // remove from first
    public int RemoveFromFirst() {
        if (head == null) {
            System.out.println("list empty");
        } else if (size == 1) {
            int data = head.data;
            head = tail = null;
            size = 0;
            return data;
        }
        size--;
        int data = head.data;
        head = head.next;
        head.prev = null;
        return data;
    }

    // remove from last
    public int RemoveFromLast() {
        if (head == null) {
            System.out.println("list is empty");
            return Integer.MIN_VALUE;
        } else if (size == 1) {
            int data = head.data;
            head = tail = null;
            size = 0;
            return data;
        }

        size--;
        int data = tail.data;
        tail = tail.prev;
        tail.next = null;
        return data;

    }

    // print doubly linked list
    public void printLinkedList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println(" null ");
        System.out.println("size: " + size);

    }

    // reverse a doubly linked list
    public void reverseList() {
        Node prev = null;
        Node current = tail = head;

        while (current != null) {
            Node next = current.next;
            current.next = prev;
            current.prev = next;
            prev = current;
            current = next;
        }

        head = prev;
    }

    public static void main(String[] args) {
        DoublyLinkedList list = new DoublyLinkedList();
        list.AddNodeAtLast(1);
        list.AddNodeAtLast(2);
        // list.AddNodeAtFirst(0);
        // list.AddNodeAtFirst(1);
        // list.AddNodeAtFirst(2);
        // list.AddNodeAtFirst(3);

        // list.AddNodeAtLast(2);
        // list.AddNodeAtLast(3);

        // list.RemoveFromFirst();
        // list.RemoveFromFirst();
        // list.RemoveFromFirst();

        // list.RemoveFromLast();
        // list.RemoveFromLast();
        // list.RemoveFromLast();
        // list.RemoveFromLast();
        // list.RemoveFromLast();

        list.printLinkedList();
        list.reverseList();

        list.printLinkedList();
    }

}
