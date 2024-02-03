
public class ZIgZagLinkedList {
    public class Node {
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

    // To find mid
    public Node findMid(Node head) {
        Node slow = head;
        Node fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;

        }
        return slow;

    }

    public Node reverse(Node head) {
        Node prev = null;
        Node current = head;
        while (current != null) {
            Node next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        return prev;

    }

    // make zig-zag
    public void zigZag(Node head) {
        // find Mid
        Node mid = findMid(head);
        Node rightHead = mid.next;
        mid.next = null;

        // reverse the second part
        Node rightPointer = reverse(rightHead);
        Node leftPointer = head;

        // use pointer and append in zigZag Array
        Node temp = new Node(-1);
        while (rightPointer != null && leftPointer != null) {
            temp.next = leftPointer;
            leftPointer = leftPointer.next;
            temp = temp.next;
            temp.next = rightPointer;
            rightPointer = rightPointer.next;
            temp = temp.next;
        }

        while (rightPointer != null) {
            temp.next = rightPointer;
            rightPointer = rightPointer.next;
            temp = temp.next;
        }

        while (leftPointer != null) {
            temp.next = leftPointer;
            leftPointer = leftPointer.next;
            temp = temp.next;
        }

    }

    public static void main(String[] args) {
        ZIgZagLinkedList list1 = new ZIgZagLinkedList();

        // list1.AddNodeAtFirst(5);
        // list1.AddNodeAtFirst(4);
        list1.AddNodeAtFirst(3);
        list1.AddNodeAtFirst(2);
        list1.AddNodeAtFirst(1);
        // 5->4->3->2->1

        list1.printLinkedList();

        list1.zigZag(head);
        list1.printLinkedList();
    }
}
