
class LargestNumber{
    public static void main(String[] args) {

        int[] arr = {3, 7, 1, 9, 2};
        int max = arr[0];

        for(int i=0;i<=arr.length-1;i++){

            if(arr[i]>max){
                max = arr[i];
            }
        }

        System.out.println(max);
    
    }
}

