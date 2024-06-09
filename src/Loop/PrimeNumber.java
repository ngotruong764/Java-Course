package Loop;

public class PrimeNumber {
    public static void main(String[] args) {
        System.out.println("8 us prime number: "+isPrime(8));
        System.out.println("2 is prime number: "+isPrime(2));
        System.out.println("1 is prime number: "+isPrime(1));
        System.out.println("7 is prime number: "+isPrime(7));
        countPrime(1000);
    }


    public static boolean isPrime(int wholeNumber){
        if (wholeNumber <= 2) return (wholeNumber ==2 );

        for(int i = 2; i < wholeNumber; i++){
            if(wholeNumber % i == 0) return false;
        }
        return true;
    }

    public static void countPrime(int range){
        int count = 0;
        for(int i = 0; i <= 1000; i++){
            if(isPrime(i)) count++;
        }
        System.out.println("The number of prime number counted from 0 to "+ range+" is: "+count);
    }
}
