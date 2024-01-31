public class LastOccurence {
    public static int lastOccurence(int arr[], int i, int key) {
        if (i < 0) {
            return i;
        }

        if (arr[i] == key) {
            return i;
        }

        return lastOccurence(arr, i - 1, key);
    }

    public static int lastOccurence2(int arr[], int i, int key) {
        if (i == arr.length) {
            return -1;
        }
        int isFound = lastOccurence2(arr, i + 1, key);

        if (isFound == -1 && arr[i] == key) {
            return i;
        }

        return isFound;
    }

    public static void main(String a[]) {
        int arr[] = { 1, 2, 1, 4, 7 };
        System.out.println(lastOccurence(arr, arr.length - 1, 1));
        System.out.println(lastOccurence2(arr, 0, 1));
    }

}
