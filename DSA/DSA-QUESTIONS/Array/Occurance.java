public class Occurance {
    public static void main(String[] args) {
        // Goal : Occurance
        int n = 234;
        int i=0;
        while(n != 0){
            i++;
            n=n/10;
        }
        System.out.println(i);
    }
}
