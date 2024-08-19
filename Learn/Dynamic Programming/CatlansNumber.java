import java.util.Arrays;

public class CatlansNumber {
    public static int catRecursion(int n) {
        if (n == 0 || n == 1)
            return 1;

        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += catRecursion(i) * catRecursion(n - i - 1);
        }

        return ans;
    }

    public static int carMemoization(int n, int dp[]) {
        if (n == 0 || n == 1) {
            return 1;
        }
        // memoisation
        if (dp[n] != -1) {
            return dp[n];
        }
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += carMemoization(i, dp) * carMemoization(n - i - 1, dp);
        }
        return dp[n] = ans;

    }

    public static int catTabulation(int n) {
        int dp[] = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                dp[i] += dp[j] * dp[i - j - 1];
            }
        }

        return dp[n];

    }

    public static void main(String[] args) {
        System.out.println(catRecursion(5));
        int num = 20;
        int dp[] = new int[num + 1];
        Arrays.fill(dp, -1);

        System.out.println(carMemoization(num, dp));
        System.out.println(catTabulation(num));

    }

}
