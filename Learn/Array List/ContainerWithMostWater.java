
import java.util.ArrayList;

public class ContainerWithMostWater {

    public static void BruteForceMethod(ArrayList<Integer> list) {
        int maxWater = Integer.MIN_VALUE;
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                int height = Math.min(list.get(i), list.get(j));
                int width = j - i;
                int water = height * width;

                maxWater = Math.max(maxWater, water);

            }
        }
        System.out.println(maxWater);

    }

    public static void twoPointerApproach(ArrayList<Integer> list) {
        int maxWater = Integer.MIN_VALUE;
        int leftPointer = 0;
        int rightPointer = list.size() - 1;

        while (leftPointer < rightPointer) {
            int height = Math.min(list.get(leftPointer), list.get(rightPointer));
            int width = rightPointer - leftPointer;
            int water = height * width;
            maxWater = Math.max(water, maxWater);

            if (list.get(leftPointer) < list.get(rightPointer)) {
                leftPointer++;
            } else {
                rightPointer--;
            }

        }

        System.out.println(maxWater);
    }

    public static void main(String args[]) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(8);
        list.add(6);
        list.add(2);
        list.add(5);
        list.add(4);
        list.add(8);
        list.add(3);
        list.add(7);

        BruteForceMethod(list);
        twoPointerApproach(list);

    }
}
