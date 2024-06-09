package Loop;

public class evenNumber {
    public static void main(String[] args) {
        int start = 5;
        int end = 20;
        while (start <= end){
            start++;
            if(!isEvenNumber(start))
                continue;
            System.out.println(start);
        }
    }
    public static boolean isEvenNumber(int number){
        return (number % 2 == 0);
    }
}
