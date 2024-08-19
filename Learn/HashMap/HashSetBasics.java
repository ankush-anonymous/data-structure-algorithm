import java.util.HashSet;
import java.util.Iterator;
import java.util.*;

public class HashSetBasics {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>();

        // it stores unique values in order of insertion
        LinkedHashSet<Integer> lset = new LinkedHashSet<>();

        // adds unique values to set
        set.add(1);
        set.add(2);
        set.add(1);
        set.add(2);
        set.add(3);

        // print set
        System.out.println(set);

        // to check if exists
        System.out.println(set.contains(3));

        // to remove element
        System.out.println(set.remove(3));

        // iterate hashSet using iterator
        Iterator itr = set.iterator();
        while (itr.hasNext()) {
            System.out.println(itr.next());
        }
        // iterate hashSet using for each loop
        for (int i : set) {
            System.out.println(i);
        }
    }
}
