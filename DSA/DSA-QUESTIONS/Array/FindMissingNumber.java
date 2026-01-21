public class FindMissingNumber {
    public static void main(String[] args) {
        //Goal : find missing number in 1 to n.
        Integer[] arr = {1,2,3,4,5,6,7,9,10};
        int missingNumber =0;
        for(int i=0;i<arr.length;i++){
            if (arr[i]!=i+1) {
                missingNumber = i+1;
                break;
            }
        }
        System.out.println(missingNumber);
    }
}
