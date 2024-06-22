package array;

import java.util.Arrays;
import java.util.Random;

// Sort a list of integer, in the descending order
public class ArrayChallenge {
//    public static void main(String[] args) {
//        // length of the integer array
//        int len = 10;
//
//        //create a random array
//        Random random = new Random();
//        int[] array = new int[len];
//        for(int i = 0; i < len; i++){
//            array[i] = random.nextInt(100);
//        }
//        //copy array
//        int[] cpArray = Arrays.copyOf(array, array.length);
//        Arrays.sort(cpArray);
//
//        System.out.println("Array before sorted: "+ Arrays.toString(array));
//
//        //sort in descending order
//        for(int i = 0; i < array.length; i++){
//            array[i] = cpArray[array.length-1-i];
//        }
//
//        System.out.println("Array after sorted in DSC: "+Arrays.toString(array));
//    }
    public static void main(String... args) {
        System.out.println("Hello world again");
        String[] splitStrings = "Hello World again".split(" ");
        printText(splitStrings);
        System.out.println("_".repeat(20));
        printText("Hello");
        System.out.println("_".repeat(20));
        printText("Hello", "World", "again");
        System.out.println("_".repeat(20));
        printText();
    }

    private static void printText(String... textList){
        for(String t: textList){
            System.out.println(t);
        }
    }
}
