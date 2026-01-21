package Logical;

public class ReverseNumber {
    public static void main(String[] args) {
        // Goal : Reverse a number 
        int n = 10154;
        int afterReverse = 0;
        int r = 0 ;
        while(n > 0){
          r = n%10;
          afterReverse = afterReverse *10 +r;
          n=n/10; 
        } 
        System.out.println(afterReverse);
    }
}
