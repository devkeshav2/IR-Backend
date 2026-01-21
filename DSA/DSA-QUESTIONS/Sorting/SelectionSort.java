package Sorting;

public class SelectionSort {
    public static void main(String[] args) {
        Integer[] arr = {34,56,98,37,12,16,89};

        int min;
        int temp=0;

        for(int i=0;i<arr.length;i++){
            min = i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[min]){
                    min=j;
                }
            }
            temp = arr[i];
            arr[i]=arr[min];
            arr[min]=temp;

        }
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }
    }
}
