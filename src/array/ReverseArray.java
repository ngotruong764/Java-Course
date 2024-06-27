package array;

import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        int[] array = {1,3,4,6,1,6};
        int[] reverseArr = reverse(array);
        System.out.println(Arrays.toString(reverseArr));
    }

    public static int[] reverse(int[] array){
        Arrays.sort(array);
        int[] tempArr = Arrays.copyOf(array, array.length);
        for (int i = 0; i < array.length; i++){
            array[i] = tempArr[array.length - 1 -i];
        }
        return array;
    }
}
