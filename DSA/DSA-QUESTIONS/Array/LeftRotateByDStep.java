import java.util.Arrays;

public class LeftRotateByDStep {
    public static void main(String[] args) {
        //Goal : Left rotate an array by D positions
        Integer[] arr = { 4, 5, 6, 7, 8, 8, 2, 0 };
        Integer[] newArr = new Integer[arr.length];
        int d = 3;
        Integer[] temp = new Integer[d];

        for(int i=0 ; i< d ;i++){
            temp[i] = arr[i];
        }
        System.out.println(Arrays.toString(temp));

        for(int i=d;i<arr.length;i++){
            newArr[i-d] = arr[i];
        }

        System.out.println(Arrays.toString(newArr));
        for (int i = 0; i < d; i++) {
            newArr[arr.length - d + i] = temp[i];
        }
        System.out.println(Arrays.toString(newArr));

    }
}
