public class EvenOdd {
    public static void checkEvenOdd(int n) {
        int bitMask = 1;
        if ((n & bitMask) == 0) {
            System.out.println("Number is even");
        } else {
            System.out.println("Number is odd");
        }
    }

    public static void main(String a[]) {
        checkEvenOdd(0);
        checkEvenOdd(3);
        checkEvenOdd(13);
        checkEvenOdd(10);
    }
}