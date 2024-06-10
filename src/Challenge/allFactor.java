package Challenge;

public class allFactor {
    public static void main(String[] args) {
        printFactor(10);
    }

    public static void printFactor(int number){
        if(number < 1){
            System.out.println("Invalid Value");
            return;
        }
        int count = 0;
        while (count <= number){
            count ++;
            if(number % count != 0) continue;
            System.out.println(count);
        }
    }
}
