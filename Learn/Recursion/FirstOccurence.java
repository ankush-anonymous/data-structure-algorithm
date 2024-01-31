public class FirstOccurence {

    public static int firstOccurence(int arr[], int key, int i) {
        if (i == arr.length) {
            return -1;
        }

        if (arr[i] == key) {
            return i;
        }

        return firstOccurence(arr, key, i + 1);

    }

    public static void main(String a[]) {
        int arr[] = { 1, 2, 3, 4, 1 };
        System.out.println(firstOccurence(arr, 1, 0));
    }
}