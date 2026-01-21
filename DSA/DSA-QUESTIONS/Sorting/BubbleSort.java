package Sorting;

public class BubbleSort {

    public static void main(String[] args) {
        Integer[] arr = {4,6,3,7,9,1,10,13};
        int temp;

        for(int m=0;m<arr.length;m++){
             int flag =0;
            for(int n=0;n<arr.length-1-m;n++){
               
                if(arr[n]>arr[n+1]){
                    temp = arr[n];
                    arr[n]=arr[n+1];
                    arr[n+1]=temp;
                    flag = 1;
                }


            }
            if(flag==0){
                break;
            }
        }
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
        
    }
    
}
