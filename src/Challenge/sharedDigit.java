package Challenge;

// shared digit in range 10 - 99
public class sharedDigit {
    public static void main(String[] args) {
        System.out.println("12 and 23 have shared digit: "+ hasSharedDigit(12,23));
        System.out.println("24 and 53 have shared digit: "+ hasSharedDigit(24,53));
        System.out.println("12 and 13 have shared digit: "+ hasSharedDigit(12,13));
    }

    public static boolean hasSharedDigit(int num1, int num2){
        if(num1 > 10 && num1 <= 99 && num2 > 10 && num2 <= 99 ){
            while (num1 != 0){
                int temp = num2;
                while (temp != 0){
                    System.out.println();
                    if( temp % 10 == num1 % 10) return true;
                    temp /= 10;
                }
                num1 /= 10;
            }
        }
        return false;
    }
}
