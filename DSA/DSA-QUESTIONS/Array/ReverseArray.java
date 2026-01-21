import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        // Goal : Reverse an array.
        Integer[] arr = { 4, 5, 6, 7, 8, 8, 2, 0 };
        Integer[] revArr = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            revArr[i] = arr[arr.length - 1 - i];
        }

        System.out.println(Arrays.toString(revArr));
    }
}
