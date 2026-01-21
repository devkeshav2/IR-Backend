package Logical;

public class PrintPrimeSeries {
    public static void main(String[] args) {
        // Goal : print prime series to nth number.
        int nth = 20;

        for (int num = 2; num <= nth; num++) {
            boolean isPrime = true;

            for (int i = 2; i * i <= num; i++) {
                if (num % i == 0) {
                    isPrime = false;
                    break;
                }
            }

            if (isPrime) {
                System.out.print(num + " ");
            }
        }

    }
}
