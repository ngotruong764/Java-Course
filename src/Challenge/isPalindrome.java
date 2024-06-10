package Challenge;

public class isPalindrome {
    public static void main(String[] args) {
        System.out.println("121 is palindrome number: "+checkPalindrome(121));
        System.out.println("1000 is palindrome number: "+checkPalindrome(1000));
        System.out.println("-1221 is palindrome number: "+checkPalindrome(-1221));
    }

    public static boolean checkPalindrome(int number){
        int palindromeNum = 0;
        int originNum = number;
        while(number != 0){
            palindromeNum = palindromeNum * 10 + number % 10 ;
            number = number / 10;
        }
        return palindromeNum == originNum;
    }
}
