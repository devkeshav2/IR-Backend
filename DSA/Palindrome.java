

class Palindrome{
    public static void main(String[] args) {

        String input = "madam";
        String reverseString = new StringBuilder(input).reverse().toString();
        if (input.equals(reverseString)) {
            System.out.println("Palindrome");
        }else{
            System.out.println("Not Palindrome");
        }


}

}