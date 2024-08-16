import java.util.*;

public class HashMapBasics {
    public static void main(String[] args) {
        HashMap<String, Integer> hm = new HashMap<>();

        // .put(key,value) => it inserts key value pair to hashmap
        hm.put("India", 150);
        hm.put("China", 15);
        hm.put("US", 10);

        // to print hashMap
        System.out.println(hm);

        // .get(key) => returns the value of its corresponding key
        System.out.println(hm.get("India"));

        // .containsKey(key) => return true if key value pair exists;
        System.out.println(hm.containsKey("India"));

        // .remove(key) => removes key value pair and returns value
        System.out.println(hm.remove("China"));

        // .size() => returns size of HashMap
        System.out.println(hm.size());

        // .isEmpty() => returns true if hashMap is empty
        System.out.println(hm.isEmpty());

        // .clear() => to clear the hashMap
        // hm.clear();

        // to iterate in hashMap
        Set<String> keys = hm.keySet();
        for (String key : keys) {
            System.out.println(key + " = " + hm.get(key));
        }

    }
}
