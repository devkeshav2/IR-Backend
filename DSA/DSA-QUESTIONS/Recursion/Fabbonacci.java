package Recursion;

public class Fabbonacci {
    public static void main(String[] args) {
        // Goal : Find the fabonacci for kth.
        // Expected output : 0,1,1,2,3,5,8,13,21,34,55,89,144,233
        int n = 12;
        int last = 0;
        int current = 1;
        int i = 1;
        System.out.print(last +","+current);
        while(i <= n){

        int output = fabb(last,current);
        last =current ;
        current = output ;

        System.out.print(", "+output);
        i++;
        }
        
    }

    static int fabb(int last, int current){
         return last + current;
    }
}
