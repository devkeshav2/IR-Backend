package ArrayPractice;

public class Practice {
    // 1. Is both array has same element or not.
public static void main(String[] args) {
        Integer[] arr11 = { 400, 590, 6340, 700, 8240, 80, 20, 10 };
      //  Integer[] arr2 = { 400, 590, 6340, 700, 8240, 80, 20, 10 ,21};
      Integer [] arr1 = {4, 5, 6, 7, 8, 9, 12, 20};

      boolean isAscending = true;
      boolean isDescending = true;

      for(int i=0;i<arr1.length-1;i++){
        if(arr1[i]>arr1[i+1]){
            isAscending = false;
        }

        if(arr1[i]<arr1[i+1]){
            isDescending = false;
        }
      }
       if(isAscending){
        System.out.println("Sorted in asecending order");
       }else if (isDescending) {
        System.out.println("Sorted in descending order");
       }else{
        System.out.println("Not sorted");
       }
}
        
    
}
