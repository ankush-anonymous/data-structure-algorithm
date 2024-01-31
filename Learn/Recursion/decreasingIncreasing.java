
public class decreasingIncreasing {

    public static int printDecreasing(int n) {
        if (n == 0) {
            return 0;
        }
        printDecreasing(n - 1);
        System.out.println(printDecreasing(n));
        return
    }

    public static void printIncreasing(int n) {
        if (n == 0) {
            System.out.println(0);
        }
        System.out.println(n);
        printIncreasing(n + 1);

    }

    public static void main(String args[]) {
        printIncreasing(5);
        printDecreasing(10);
    }

}
