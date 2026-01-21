package Logical;

public class FindSumOfDigits {

    public static void main(String[] args) {
        // Goal : Sum of all digits of a number.
        int value = 1231;
        int n = Math.abs(value);
        int sum = 0;
        int r = 0;

        while (n > 0) {
            r = n % 10;
            sum = sum + r;
            n = n / 10;
        }
        System.out.println(sum);
    }

}
