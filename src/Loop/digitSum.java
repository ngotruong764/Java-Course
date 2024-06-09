package Loop;

public class digitSum {
    public static void main(String[] args) {
        int number = 100;
        int sum = 0;

        while(number % 10 > 0 || number /10 != 0){
            sum += number % 10;
            number = number / 10;
        }
        System.out.println("Digit sum: "+ sum);
    }


}
