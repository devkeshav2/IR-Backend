

class SecondLargest{
    public static void main(String[] args) {

        
        int[] arr = {12, 35, 1, 10, 34, 1};
        int secondLargest =arr[0];
        for(int i=0;i<arr.length;i++){
            if(arr[i]>secondLargest){
                secondLargest=arr[i];
            }
            
        }
        System.out.println(secondLargest);

}

}