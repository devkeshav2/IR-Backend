package Logical;

public class Factorial {
    public static void main(String[] args) {
        //Goal : Find factorial
        int n = 5;
        int fact =1 ;
        while(n>1){
           fact = fact * n;
           n --;
        }
        System.out.println(fact);
    }
}
