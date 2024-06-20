package array;

import java.util.Arrays;

public class ArrayP1 {
    public static void main(String[] args) {
        int[] myArray = new int[10]; // 10 elements in an array
//        myArray[0] = 45.0; // error
        myArray[5] = 50;

        double[] myDoubleArray = new double[10]; //10 elements in an array
        myDoubleArray[2] = 3.5;
        System.out.println(myDoubleArray[2]);

        int[] firstTen = {1,2,3,4,5,6,7,8,9,10};
        System.out.println("first = "+ firstTen[0]);
        int arrayLength = firstTen.length;
        System.out.println("length of array = "+ arrayLength);
        System.out.println("last of array "+ firstTen[arrayLength -1]);

        int[] newArray;
        //newArray = {1,2,3,4}; // error
        newArray = new int[] {1,2,3};

        int[] newArray1 = new int[5];
        for(int i : newArray1){
            System.out.print(i+"\t");
        }
        System.out.println();

        boolean[] newArray2 = new boolean[5];
        for(boolean i : newArray2){
            System.out.print(i+"\t");
        }
        System.out.println();

        String[] newArray3 = new String[5];
        for(String i : newArray3){
            System.out.print(i+"\t");
        }
        System.out.println();

        int[] array1 = {5,4,3,2,1};
        String array1ToString = Arrays.toString(array1);
        System.out.println(array1ToString);

        boolean[] array2 = {true, false};
        System.out.println(array2);

        Object object = array1;
        if( object instanceof int[]){
            System.out.println("object is really an instance of an int[]");
        }

        // create an array of object that support any type of Java
        Object[] object1 = new Object[3];
        object1[0] = "Hello";
        object1[1] = true;
        object1[2] = new StringBuilder("World");
        System.out.println(Arrays.toString(object1));


    }
}
