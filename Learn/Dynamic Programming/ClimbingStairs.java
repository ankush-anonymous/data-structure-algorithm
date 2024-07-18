import java.util.Arrays;

public class dp1 {

    public static int climbStairsRecursion(int stairs) {
        if (stairs < 0) {
            return 0;
        }
        if (stairs == 1 || stairs == 0)
            return 1;

        return climbStairsRecursion(stairs - 1) + climbStairsRecursion(stairs - 2);
    }

    public static int climbStairsMemoisation(int stairs, int ways[]) {
        if (stairs == 0)
            return 1;

        if (stairs < 0)
            return 0;

        if (ways[stairs] != -1)
            return ways[stairs];

        ways[stairs] = climbStairsMemoisation(stairs - 1, ways) + climbStairsMemoisation(stairs - 2, ways);

        return ways[stairs];

    }

    public static int climbStairsTabulation(int stairs) {
        int ways[] = new int[stairs + 1];
        ways[0] = 1;
        ways[1] = 1;

        for (int i = 2; i < ways.length; i++) {
            if (i == 1)
                ways[i] = 1;
            ways[i] = ways[i - 1] + ways[i - 2];
        }
        return ways[stairs];

    }

    public static void main(String[] args) {
        System.out.println(climbStairsRecursion(4));

        int[] ways = new int[5];
        Arrays.fill(ways, -1);
        System.out.println(climbStairsMemoisation(4, ways));

        System.out.println(climbStairsTabulation(4));
    }
}
