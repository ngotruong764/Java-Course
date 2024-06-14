package Input;

import java.util.Scanner;

public class InputCalculator {
    public static void main(String[] args) {
        inputThenPrintSumAndAverage();
    }

    public static void inputThenPrintSumAndAverage(){
        Scanner scanner = new Scanner(System.in);
        int num, count = 0;
        int sum = 0;
        long avg = 0L;
        while (true){
            try {
                count ++;
                num = scanner.nextInt();
                sum += num;
                avg = (long) (Math.round((double)(sum/count)));
            } catch (Exception e){
                System.out.println("SUM = "+ sum+ " AVG = "+ avg);
                break;
            }
        }
    }

}
