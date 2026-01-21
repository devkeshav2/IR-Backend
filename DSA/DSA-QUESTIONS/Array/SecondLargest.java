import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.SortedSet;
import java.util.TreeSet;

public class SecondLargest {
    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(4, 5, 6, 7, 8, 8, 2, 0);
        // Collections.sort(intList);
        // System.out.println(intList);
        // Integer index = intList.size();
        // System.out.println("Second largest: "+intList.get(index-2));

        //SortedSet<Integer> sortedSet = new TreeSet<>(Arrays.asList(intList));


        int max = Integer.MIN_VALUE, secondMax = Integer.MIN_VALUE;
        for (int num : intList) {
            if (num > max) {
                secondMax = max;
                max = num;
            } else if (num > secondMax && num != max) {
                secondMax = num;
            }
        }
        if (secondMax == Integer.MIN_VALUE) {
            System.out.println("No second largest distinct value found");
        } else {
            System.out.println("Second largest distinct: " + secondMax);
        }

    }
}