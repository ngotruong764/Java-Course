package array;

import java.util.Arrays;

public class TwoDimesionalArray {
    public static void main(String[] args) {
        int[][] array1 = new int[4][4];
        System.out.println(Arrays.toString(array1));
        System.out.println("Array1 length: "+ array1.length );

        for(int[] outer: array1){
            System.out.println(Arrays.toString(outer));
        }

        int[][]  array2 = {{12,312,32},{12,12,32,123,12,3},{903423}};
        System.out.println(Arrays.deepToString(array2)); // print multi dimensional array

        int[][][] array3 = new int[3][3][3];
        System.out.println(Arrays.deepToString(array3));
    }
}
