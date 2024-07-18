public class LongestCommonSubstring {
    public static int lcsRecursion(String str1, String str2, int n, int m, int count) {
        System.out.println("n = " + n + " m = " + m + " count = " + count);
        if (n == 0 || m == 0)
            return count;

        if (str1.charAt(n - 1) == str2.charAt(m - 1)) {
            count = count + 1;
            return lcsRecursion(str1, str2, n - 1, m - 1, count);
        } else {
            count = 0;
            return lcsRecursion(str1, str2, n - 1, m - 1, count);
        }

    }

    public static int lcsTabulation(String str1, String str2) {
        int n = str1.length();
        int m = str2.length();

        int dp[][] = new int[n + 1][m + 1];
        int ans = 0;

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < m + 1; j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                    ans = Math.max(ans, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String str1 = "abcde";
        String str2 = "ace";
        int n = str1.length();
        int m = str2.length();

        System.out.println(lcsRecursion(str1, str2, n, m, 0));
        System.out.println(lcsTabulation(str1, str2));
    }

}
