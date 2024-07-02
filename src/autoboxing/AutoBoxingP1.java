package autoboxing;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

public class AutoBoxingP1 {
    public static void main(String[] args) {
        Integer boxedInt = Integer.valueOf(15); // preferred but unnecessary

        Integer deprecatedBoxing = new Integer(15); // deprecated since JDK 9

        int unboxInt =  boxedInt.intValue();    // unnecessary

        // Automatic
        Integer autoBoxing = 15;
        int autoUnbox = autoBoxing;
        System.out.println(autoBoxing);
        System.out.println(autoUnbox);

        Integer[] wrapperArray = new Integer[5];
        wrapperArray[0] = 50; // JVM boxed the literal 50 before assign it to an element in the array.
        System.out.println(Arrays.toString(wrapperArray));
        System.out.println(wrapperArray[0].getClass().getName());

        //Auto-boxing when initialize
        Character[] characterArray = {'a', 'b', 'c', 'd'};
        System.out.println(Arrays.toString(characterArray));
        System.out.println(characterArray.getClass().getName());

        var outList = getList(1,2,3,4,5);
        System.out.println(outList);


    }
    private static ArrayList<Integer> getList(int... varargs){
        ArrayList<Integer> aList = new ArrayList<>();

        for (int i : varargs){
            aList.add(i);
        }

        return aList;
    }
    private static int returnAnInt(Integer i){
        return i;
    }

    private static Integer returnAnInteger(int i){
        return i;
    }
}
