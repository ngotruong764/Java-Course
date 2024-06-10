package Challenge;

public class firstAndLastDigitSum {
    public static void main(String[] args) {
        System.out.println("First and Last digit sum of 1001 is: "+ sumFirstAndLast(1001));
        System.out.println("First and Last digit sum of 1000 is: "+ sumFirstAndLast(1000));
    }

    public static int sumFirstAndLast(int number){
        int sum = number % 10;
        while (number > 9){
            number /= 10;
        }
        sum += number;
        return (number >= 0 ? sum : -1);
    }
}
