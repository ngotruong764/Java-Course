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
