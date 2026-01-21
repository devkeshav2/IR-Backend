public class FindMinAndMax {
    public static void main(String[] args) {
        // Goal : find min and max.
        Integer[] arr = { 400, 590, 6340, 700, 8240, 80, 20, 10 };
        int min = arr[0];
        int max = arr[0];

        for (int i = 1; i < arr.length; i++) {

            if (arr[i] < min) {
                min = arr[i];
            }

            if (arr[i] > max) {
                max = arr[i];
            }

        }
        System.out.println(min);
        System.out.println(max);
    }
}
