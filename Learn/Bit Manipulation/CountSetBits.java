public class CountSetBits {
    public static void countSetBits(int n) {
        int count = 0;
        while (n > 0) {
            if ((n & 1) != 0) {
                count++;
            }
            n = n >> 1;
        }

        System.out.println("number of set bits: " + count);

    }

    public static void main(String a[]) {
        countSetBits(16);

    }
}
