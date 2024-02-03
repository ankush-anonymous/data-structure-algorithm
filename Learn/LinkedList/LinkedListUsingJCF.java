import java.util.LinkedList;

public class LinkedListUsingJCF {
    public static void main(String[] args) {
        // create
        LinkedList<Integer> list1 = new LinkedList<>();

        // add
        list1.addLast(1);
        list1.addLast(2);
        list1.addFirst(0);

        list1.removeFirst();
        list1.removeLast();
        System.out.println(list1);

    }

}
