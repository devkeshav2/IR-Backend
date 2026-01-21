import java.util.Arrays;

public class CompareTwoArraysElement {
    public static void main(String[] args) {
        
        //  Goal : is both same

        Integer[] arr1 = { 400, 590, 6340, 700, 8240, 80, 20, 10 };
        Integer[] arr2 = { 400, 590, 6340, 700, 8240, 80, 20, 10 };
        boolean same = true;

        if(arr1.length==arr2.length){

         for(int i=0;i<arr1.length;i++){
                if (!arr1[i].equals(arr2[i])) {
                    same = false;
                    break;
                }
         }
         if (same) {
            System.out.println("Same");
         }else{
            System.out.println("Different");
         }


        }else{
            System.out.println("not same");
        }

    }
}
