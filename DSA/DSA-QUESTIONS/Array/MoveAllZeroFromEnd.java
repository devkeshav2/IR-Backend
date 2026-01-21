import java.util.Arrays;

public class MoveAllZeroFromEnd {
    public static void main(String[] args) {
        // Goal : remove all zero from end for each element
        Integer[] arr = { 400, 590, 6340, 700, 8240, 80, 20, 10 };

        for(int i=0;i<arr.length;i++){

        while(arr[i]%10==0){
           
           arr[i]=arr[i]/10;
           
        }
        }
        

        System.out.println(Arrays.toString(arr));
    }
}
