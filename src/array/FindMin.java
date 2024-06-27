package array;

import java.util.Arrays;
import java.util.Scanner;

public class FindMin {
    public static void main(String[] args) {
        String[] array = readInteger();
        System.out.println("Min: "+ findMin(array));
    }
    public static String[] readInteger(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input array of int");
        String str = scanner.nextLine();
        return str.split(",");
    }

    public static int findMin(String[] array){
        Arrays.sort(array);
        return Integer.parseInt(array[0]);
    }
}
