package Logical;

public class PalindromeNumber {
    public static void main(String[] args) {
        //Goal : Check if a number is palindrome
        int n  = 32323;
        int prev = n;
        int m =0;
        int r = 0;
        while(n > 0){
            r = n % 10 ;
            m = m * 10 + r;// 1 
            n =n/10;
        }
        System.out.println((prev == m) ? "Palindrome" : "Not palindrome");

       
    }
}
