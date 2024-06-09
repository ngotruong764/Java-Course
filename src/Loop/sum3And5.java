package Loop;

// calculate sum of all number that is evenly divided by both 3 and 5
public class sum3And5 {
    public static void main(String[] args) {
        int start = 0;
        int end = 1000;
        System.out.println("Sum of all number that is evenly divided by by both 3 and 5 from "+start+" to "+end+" is: "
                +calSum3And5(start, end));
    }

    public static boolean isDivided3And5(int number){
        return( number % 3 == 0 && number % 5 == 0);
    }

    public static int calSum3And5(int start, int end){
        int sum = 0;
        int counter = 0;
        for(int i = start ; i <= end; i++ ){
            if(isDivided3And5(i)) sum += i;

        }
        return sum;
    }
}
