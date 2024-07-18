import java.util.Arrays;

public class ZeroOneKnapsack {

    public static int knapsack(int val[], int wt[], int W, int n) {
        if (W == 0 || n == 0)
            return 0;

        if (wt[n - 1] <= W) { // valid
            // include
            int include = val[n - 1] + knapsack(val, wt, W - wt[n - 1], n - 1);

            // exclude
            int exclude = knapsack(val, wt, W, n - 1);

            return Math.max(include, exclude);
        } else { // not valid
            return knapsack(val, wt, W, n - 1);

        }
    }

    public static int knapsackMemoisation(int val[], int wt[], int W, int n, int dp[][]) {
        if (W == 0 || n == 0) {
            return 0;
        }

        if (dp[n][W] != -1) {
            return dp[n][W];
        }

        if (wt[n - 1] <= W) {
            int include = val[n - 1] + knapsackMemoisation(val, wt, W - wt[n - 1], n - 1, dp);
            int exclude = knapsackMemoisation(val, wt, W, n - 1, dp);

            dp[n][W] = Math.max(include, exclude);
            return dp[n][W];
        } else {
            dp[n][W] = knapsackMemoisation(val, wt, W, n - 1, dp);
            return dp[n][W];

        }
    }

    public static int knapsackTabulation(int val[], int wt[], int W) {
        int n = val.length;
        int dp[][] = new int[n + 1][W + 1];

        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 0;
        }

        for (int j = 0; j < W + 1; j++) {
            dp[0][j] = 0;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < W + 1; j++) {
                // valid case
                if (wt[i - 1] <= j) {

                    // include
                    int include = val[i - 1] + dp[i - 1][j - wt[i - 1]];
                    int exclude = dp[i - 1][j];
                    dp[i][j] = Math.max(include, exclude);
                } else {
                    int exclude = dp[i - 1][j];
                    dp[i][j] = exclude;

                }
            }
        }
        return dp[n][W];
    }

    public static void main(String[] args) {
        int val[] = { 15, 14, 10, 45, 30 };
        int wt[] = { 2, 5, 1, 3, 4 };
        int W = 7;
        int dp[][] = new int[val.length + 1][W + 1];
        for (int i = 0; i < val.length + 1; i++) {
            for (int j = 0; j < W + 1; j++) {
                dp[i][j] = -1;
            }
        }

        System.out.println(knapsack(val, wt, W, val.length));
        System.out.println(knapsackMemoisation(val, wt, W, val.length, dp));
        System.out.println(knapsackTabulation(val, wt, W));

    }
}
