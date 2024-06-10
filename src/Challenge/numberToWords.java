package Challenge;

public class numberToWords {
    public static void main(String[] args) {
        numberToWord(100);
        numberToWord(234);
        numberToWord(-12);
        numberToWord(0);
    }

    public static void numberToWord(int number){
        int digitCount = getDigitCount(number);
        if (digitCount == -1 ){
            System.out.println("Invalid Value");
            return;
        }

        int reverseNum = reverse(number);
        while(digitCount > 0 ){
            switch (reverseNum % 10){
                case 1 -> System.out.println("One");
                case 2 -> System.out.println("Two");
                case 3 -> System.out.println("Three");
                case 4 -> System.out.println("Four");
                case 5 -> System.out.println("Five");
                case 6 -> System.out.println("Six");
                case 7 -> System.out.println("Seven");
                case 8 -> System.out.println("Eight");
                case 9 -> System.out.println("Nine");
                default -> System.out.println("Zero");
            }
            reverseNum /= 10;
            digitCount --;
        }
    }

    public static int reverse(int num){
        int temp = 0;
        while(num != 0){
            temp = temp * 10 + num % 10 ;
            num = num / 10;
        }
        return temp;
    }

    public static int getDigitCount(int num){
        int count = 0;
        int temp = num;
        while (temp > 9){
            count ++;
            temp /= 10;
        }
        count ++;
        return (num >= 0 ? count: -1);
    }
}
