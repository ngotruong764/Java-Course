package Challenge;

// calculate the largest prime factor of a given number
public class largestPrime {
    public static void main(String[] args) {
        System.out.println("Largest prime of 21: "+ getLargestPrime(21));
    }

    public static int getLargestPrime(int num){
        int largestPrime = -1;
        for(int i = 2; i <= num; i++ ){
            if(isPrime(i) && num % i == 0) largestPrime = i;
        }
        return largestPrime;
    }

    public static boolean isPrime(int number){
        boolean prime = true;
        for (int i = 2; i < number; i++){
            prime = (number % i) != 0 ;
            if (!prime) break;
        }
        return prime;
    }
}
