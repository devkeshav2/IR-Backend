
class SmallestNumber{
    public static void main(String[] args) {

        int[] arr = {3, 7, 1, 9, 2};
        int min = arr[0];

        for(int i=0;i<=arr.length-1;i++){

            if(arr[i]<min){
                min = arr[i];
            }
        }

        System.out.println(min);
    
    }
}

