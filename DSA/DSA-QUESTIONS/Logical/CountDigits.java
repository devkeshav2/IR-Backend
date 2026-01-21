package Logical;

public class CountDigits {
    public static void main(String[] args) {
        // Goal : count digits
        int value = -423232;
        int n = Math.abs(value);
        int count = 0;
        while(n>0){
            n = n/10;
            count++;
        }
        System.out.println(count);
    }
}
