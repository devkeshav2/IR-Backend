import java.util.Arrays;

public class LeftRotateElement {
    public static void main(String[] args) {
        // Goal : left shift element
        Integer[] arr = { 4, 5, 6, 7, 8, 8, 2, 0 };
        int temp = arr[0];
        for(int i=0;i<arr.length-1;i++){
            arr[i]=arr[i+1];
        }
        arr[arr.length-1] = temp;
System.out.println(Arrays.toString(arr));

    }
    
}
