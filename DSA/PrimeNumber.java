
class PrimeNumber{
    public static void main(String[] args) {

        int n=7;
        boolean flag=true;

        for(int i=2;i<Math.sqrt(n);i++){

            if(n%i==0){
                flag = false;
            }

        }
        if (flag==true) {
            System.out.println("Prime");
        }
}

}