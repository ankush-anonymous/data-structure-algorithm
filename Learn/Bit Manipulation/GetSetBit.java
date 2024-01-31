
public class GetSetBit {
    public static int getIthBit(int n, int i) {
        int bitMask = 1 << i;
        return n & bitMask;
    }

    public static int setIthBit(int n, int i) {
        int bitMask = 1 << i;
        return n | bitMask;
    }

    public static int clearIthBit(int n, int i) {
        int bitMask = ~(1 << i);
        return n & bitMask;
    }

    public static int updateIthBit(int n, int i, int newBit) {
        n = clearIthBit(n, i);
        int bitMask = newBit << i;
        return n | bitMask;
    }

    public static int clearIBits(int n, int i) {
        int bitMask = (-1) << i;
        return n & bitMask;
    }

    public static void main(String a[]) {
        System.out.println(getIthBit(15, 2));
        System.out.println(setIthBit(9, 2));
        System.out.println(clearIthBit(10, 1));
        System.out.println(updateIthBit(10, 2, 1));
        System.out.println(clearIBits(15, 2));
    }
}