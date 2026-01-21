package Logical;

public class SwapNumbers {
    public static void main(String[] args) {
        //Goal : Swap two numbers without using third variable
        int a= 5;
        int b=6;

        System.out.println("Before A : "+a+" B : "+b);

         b = a + b; // b= 11
         a = b - a ; // a = 6
         b = b - a; // b = 11 - a = 5 

         System.out.println("After A : "+a+" B : "+b);

    }
}
