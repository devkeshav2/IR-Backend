import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.Set;

public class RemoveDuplicate {
    public static void main(String[] args) {
        // Goal : remove duplicate element from array.
        Integer[] arr = { 4, 5, 6, 7, 8, 8, 2, 0 };
        Set<Integer> uniqueSet = new LinkedHashSet<>(Arrays.asList(arr));
        Integer[] uniqueArray = uniqueSet.toArray(new Integer[0]);
        System.out.println(Arrays.toString(uniqueArray));

    }
}
