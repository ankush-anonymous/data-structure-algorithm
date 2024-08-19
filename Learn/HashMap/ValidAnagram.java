import java.util.HashMap;

public class ValidAnagram {
    public static boolean checkAnagram(String s, String t) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char chr = s.charAt(i);
            if (hm.containsKey(chr)) {
                int count = hm.get(chr);
                hm.put(chr, count + 1);
            } else {
                hm.put(chr, 1);
            }
        }

        for (int i = 0; i < t.length(); i++) {
            char chr = t.charAt(i);
            if (hm.get(chr) != null) {
                if (hm.get(chr) == 1) {
                    hm.remove(chr);
                } else {
                    int count = hm.get(chr);
                    hm.put(chr, count - 1);
                }
            }
        }

        return hm.isEmpty();
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";

        System.out.println(checkAnagram(s, t));
    }

}
