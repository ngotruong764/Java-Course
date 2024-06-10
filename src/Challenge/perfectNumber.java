package Challenge;

//A perfect number is a positive integer which is equal to the sum of its proper positive divisors.
// e.g. 6 is a perfect number because 1+2+ 3 = 6
public class perfectNumber {
    public static void main(String[] args) {
        System.out.println("6 is a perfect number: "+isPerfectNumber(6));
    }

    public static boolean isPerfectNumber(int num){
        int sum = 0;
        int count = 0;

        while (count < num/2){
            count ++;
            if (num % count == 0) sum +=count;
        }

        return (num >= 1 && sum == num);
    }
}
