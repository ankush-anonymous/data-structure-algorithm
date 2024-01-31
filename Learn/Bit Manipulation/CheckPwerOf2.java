public class CheckPwerOf2 {
    public static void checkPowerOf2(int n) {
        if ((n & n - 1) == 0) {
            System.out.println("Its power of 2");
        } else {
            System.out.println("Its not power of 2");

        }
    }

    public static void main(String a[]) {
        checkPowerOf2(16);

    }
}
