package Challenge;

// check the last digit of 3 number
// if these number has at least 2 same digit return true, otherwise return false
public class lastDigitChecker {
    public static void main(String[] args) {
        System.out.println("42, 22 and 71 have the same last digit: "+ hasSameLastDigit(42,22,71));
        System.out.println("11, 22 and 31 have the same last digit: "+ hasSameLastDigit(11,22,31));
    }

    public static boolean hasSameLastDigit(int num1, int num2, int num3){
        int lastDigit1 = num1 % 10;
        int lastDigit2 = num2 % 10;
        int lastDigit3 = num3 % 10;

        return (isValid(num1)&& isValid(num2) && isValid(num3)
                && (lastDigit1 == lastDigit2 || lastDigit3 == lastDigit2 || lastDigit1 == lastDigit3));
    }

    /**
     * @overview isValid check the range of number( in this case the range from 10 to 1000)
     * @param number
     * @return
     */
    public static boolean isValid(int number){
        return (number >= 10 && number <= 1000);
    }
}
