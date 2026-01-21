package Logical;

public class PrimeNumber {
    public static void main(String[] args) {
        // Goal : Check prime number.
        int n =13;
        boolean flag = false;
        for(int i = 2 ; i <= n/2;i++){
             if (n%i==0) {
                flag = true;
             }
        }
        System.out.println(flag ? "Not Prime" : "Prime");
    }
}
