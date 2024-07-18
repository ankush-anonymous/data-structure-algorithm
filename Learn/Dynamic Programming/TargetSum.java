public class TargetSum {
    public static boolean targetSum(int[] arr, int target, int idx) {
        if (idx <= 0 || target < 0)
            return false;
        if (target == 0)
            return true;

        if (target > 0) {
            boolean include = targetSum(arr, target - arr[idx - 1], idx - 1);
            boolean exclude = targetSum(arr, target, idx - 1);

            return include || exclude;
        } else {
            boolean exclude = targetSum(arr, target, idx - 1);
            return exclude;

        }

    }

    public static boolean targetSumTabulation(int arr[], int targetSum) {
        boolean dp[][] = new boolean[arr.length + 1][targetSum + 1];

        // initialise
        for (int i = 0; i < arr.length + 1; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i < arr.length + 1; i++) {
            for (int j = 1; j < targetSum + 1; j++) {
                int value = arr[i - 1];
                // include
                if (value <= j && dp[i - 1][j - value] == true) {
                    dp[i][j] = true;
                }

                // exclude
                else if (dp[i - 1][j] == true) {
                    dp[i][j] = true;
                }

            }
        }

        return dp[arr.length][targetSum];

    }

    public static void main(String[] args) {
        int arr[] = { 4, 2, 7, 1, 3 };
        System.out.println(targetSum(arr, 255, arr.length));
        System.out.println(targetSumTabulation(arr, 25));

    }
}