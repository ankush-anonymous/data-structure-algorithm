public class SwqpTwoNumbers {
    public static void SwapTwoNumbers(int n1, int n2) {
        System.out.println("Before");
        System.out.println(n1);
        System.out.println(n2);
        for (int i = 0; i < 8; i++) {

            int bitMask = 1 << i;
            if ((n1 & bitMask) != (n2 & bitMask)) {
                n1 = updateIthBit(n1, i);
                n2 = updateIthBit(n2, i);
            }

        }
        System.out.println("After");
        System.out.println(n1);
        System.out.println(n2);

    }

    public static int updateIthBit(int n, int i) {
        int bitMask = 1 << i;
        if ((n & bitMask) == 0) {
            n = setIthBit(n, i);
        } else {
            n = clearIthBit(n, i);
        }
        return n;
    }

    public static int setIthBit(int n, int i) {
        int bitMask = (1 << i);
        return n | bitMask;
    }

    public static int clearIthBit(int n, int i) {
        int bitMask = ~(1 << i);
        return n & bitMask;
    }

    public static void main(String a[]) {
        int n1 = 15;
        int n2 = 16;
        SwapTwoNumbers(n1, n2);

    }

}
