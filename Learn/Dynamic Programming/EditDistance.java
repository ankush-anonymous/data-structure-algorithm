public class EditDistance {
    public static int editDist(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();
        int dp[][] = new int[n + 1][m + 1];

        // initialize
        for (int i = 0; i < n + 1; i++) {
            for (int j = 0; j < m + 1; j++) {
                if (i == 0) {
                    dp[i][j] = j;
                }
                if (j == 0) {
                    dp[i][j] = i;
                }
            }
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    int ans1 = dp[i][j - 1]; // add
                    int ans2 = dp[i - 1][j]; // delete
                    int ans3 = dp[i - 1][j - 1]; // replace
                    dp[i][j] = Math.min(ans1, Math.min(ans2, ans3)) + 1;
                }
            }
        }
        return dp[n][m];

    }

    public static void main(String[] args) {
        String str1 = "intention";
        String str2 = "execution";
        System.out.println(editDist(str1, str2));
    }

}
