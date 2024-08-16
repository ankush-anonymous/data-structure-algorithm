//for given array return all the elements which appear more than n/3 time. n=>length of array

import java.util.HashMap;
import java.util.Set;

public class MajorityElement {
    public static void findCount(int arr[], HashMap<Integer, Integer> hm) {
        for (int i = 0; i < arr.length; i++) {
            if (hm.containsKey(arr[i])) {
                int c = hm.get(arr[i]);
                hm.put(arr[i], c + 1);
            } else {
                hm.put(arr[i], 1);
            }
        }
    }

    public static void main(String[] args) {
        int arr[] = { 1, 3, 2, 5, 1, 3, 1, 5, 1 };
        HashMap<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            hm.put(arr[i], 1);
        }
        findCount(arr, hm);
        int n = arr.length / 3;
        Set<Integer> keys = hm.keySet();
        for (int key : keys) {
            if (hm.get(key) > n) {
                System.out.println(key);
            }
        }
    }
}
