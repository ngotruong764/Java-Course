package array;

import java.util.Arrays;
import java.util.Random;

public class ArraysClass {
    public static void main(String[] args) {
        int[] firstArray = getRandomArray(10);
        Arrays.sort(firstArray);
        System.out.println(Arrays.toString(firstArray));

        int[] secondArray = new int[10];
        Arrays.fill(secondArray, 5);
        System.out.println(Arrays.toString(secondArray));

        int[] thirdArray = {5,2,3,4,1};
        int[] forthArray = Arrays.copyOf(thirdArray, thirdArray.length);
        System.out.println(Arrays.toString(forthArray));

        String[] sArray = {"Able", "Jane", "Mark","Ralph", "David"};
        Arrays.sort(sArray);
        int matchFoundPosition = Arrays.binarySearch(sArray, "Mark");
        if(matchFoundPosition >= 0) System.out.println("Match found: c"+ matchFoundPosition);
        else System.out.println("Not found: "+ matchFoundPosition);

        // Equal arrays: have the same length and position of each element must be the same
        int[] s1 = {1,2,3,4,5,6};
        int[] s2 = {1,2,3,4,5,6};
        if(Arrays.equals(s1,s2)) System.out.println("Arrays are equal.");
        else System.out.println("Arrays are not equal");

        


    }

    private static int[] getRandomArray(int len){
        Random random = new Random();
        int[] newInt = new int[len];
        for (int i = 0; i <len; i++){
            newInt[i] = random.nextInt(100);
        }
        return newInt;
    }
}
