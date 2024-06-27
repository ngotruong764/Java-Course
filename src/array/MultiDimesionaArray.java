package array;

import java.util.Arrays;

public class MultiDimesionaArray {
    public static void main(String[] args) {
        Object[] anyArray = new Object[3];
        System.out.println(Arrays.deepToString(anyArray));

        anyArray[0] = new String[] {"s", "a", "m"};
        System.out.println(Arrays.deepToString(anyArray));

//        anyArray[1] = new String([]);
    }
}
