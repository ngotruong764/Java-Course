package Challenge;

public class evenDigitSum {
    public static void main(String[] args) {
        System.out.println("Even digit some of 1200 is: " +getEvenDigitSum(1200));
    }

    public static int getEvenDigitSum(int number){
        int originNum = number;
        int sum = 0;
        while (number != 0){
            if(number % 10 % 2 == 0) sum += number % 10;
            number /= 10;
        }
        return (originNum >= 0 ? sum : -1);
    }
}
