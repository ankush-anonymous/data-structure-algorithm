
public class fibonacci {

    public static int ithFibonacci(int n) {
        if (n == 0 || n == 1) {
            return n;
        }

        int fib1 = ithFibonacci(n - 1);
        int fib2 = ithFibonacci(n - 2);
        return fib1 + fib2;
    }

    public static void main(String a[]) {
        System.out.println(ithFibonacci(5));

    }

}
