import java.util.Arrays;
import java.util.List;

public class IsArraySorted {
    public static void main(String[] args) {
        // Goal : Is array sorted ?

        //Integer [] arr = {4, 5, 6, 7, 8, 8, 2, 0};
        //Integer [] arr = {4, 5, 6, 7, 8, 9, 12, 20};
        Integer [] arr = {4000, 550, 60, 40, 18, 9, 1, 0};
        System.out.println(Arrays.toString(arr));
        
        boolean isAscending = true;
        boolean isDescending = true;

        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                isAscending = false;
            }
            if (arr[i] < arr[i + 1]) {
                isDescending = false;
            }
        }

        if (isAscending) {
            System.out.println("Sorted in ascending order");
        } else if (isDescending) {
            System.out.println("Sorted in descending order");
        } else {
            System.out.println("Not sorted");
        }
    }
}
