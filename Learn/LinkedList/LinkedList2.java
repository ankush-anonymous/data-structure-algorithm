
public class LinkedList2 {
    public static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    // initialise
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

    // To print the linkedList
    public static void printLinkedList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " -> ");
            temp = temp.next;
        }
    }

    public static boolean detectCycle() {
        Node slow = head;
        Node fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }

        }

        return false;

    }

    public static void removeCycle() {
        // step 1: detect cycle
        Node slow = head;
        Node fast = head;
        Boolean isCycle = false;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (fast == slow) {
                isCycle = true;
                break;
            }
        }

        if (isCycle == false) {
            return;
        }

        // step 2: slow = head
        slow = head;

        // step 3: make slow & fast step 1 till slow == fast
        // also tract prev
        // point prev to null
        Node prev = null;
        while (slow != fast) {
            prev = fast;
            slow = slow.next;
            fast = fast.next;
        }

        // step4 : remove cycle
        prev.next = null;
    }

    public static void main(String args[]) {
        head = new Node(1);
        Node temp = new Node(2);
        head.next = temp;
        head.next.next = new Node(3);
        head.next.next.next = temp;
        // 1->2->3->1

        System.out.println(detectCycle());
        removeCycle();
        System.out.println(detectCycle());
    }
}
