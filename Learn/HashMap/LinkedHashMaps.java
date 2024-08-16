import java.util.LinkedHashMap;

public class LinkedHashMaps {
    public static void main(String[] args) {
        // in this the order of insertion of key is maintained
        LinkedHashMap<String, Integer> lhm = new LinkedHashMap<>();

        lhm.put("India", 100);
        lhm.put("China", 100);
        lhm.put("US", 100);

        System.out.println(lhm);

    }
}
