package Challenge;

public class greatestCommonDivisor {
    public static void main(String[] args) {
        System.out.println("GCD(15, 25) = " +getGreatestCommonDivisor(15,25));
    }

    public static int getGreatestCommonDivisor(int num1, int num2){
        int count = 0;
        int max_num = num1 > num2 ? num1 : num2;
        int gcd = 1;
        while (count < max_num){
            count++;
            System.out.println(num1 % count );
            if(num1 % count == 0 && num2 % count == 0) gcd = count;
        }

        return (num1 >= 10 && num2 >= 10 ? gcd : -1);
    }
}
