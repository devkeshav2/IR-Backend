package Logical;

public class ArmStrongNumber {
    public static void main(String[] args) {
        // Goal : Check armstrong or not.
        int n =153;
        int m = 0;
        int prev = n ;
        int rem = 0;
        while(n>0){
            rem = n % 10 ;
            m = m + (rem*rem*rem);
            n=n/10;
        }
        System.out.println((prev==m)?"armstrong":"not armstrong");
    }
}
