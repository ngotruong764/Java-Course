package Comparing;

import java.util.Arrays;
import java.util.Comparator;

public class ComparingP1 {
    public static void main(String[] args) {
        Integer five = 5;
        Integer[] others = {0,5, 10 -50, 50};

        for(Integer i : others){
            int val = five.compareTo(i);
            System.out.printf("%d %s %d: compareTo=%d%n", five, (val == 0 ? "==" : (val <0) ? "<" : ">"), i, val);
        }

        String banana = "banana";
        String[] fruit = {"apple", "banana", "pear", "BANANA"};
        for (String s : fruit){
            int val = banana.compareTo(s);
            System.out.printf("%s %s %s: compareTo=%d\n", banana, (val == 0) ? "==" : (val > 0) ? ">" : "<", s, val);
        }
        Arrays.sort(fruit);
        System.out.println(Arrays.toString(fruit));
        System.out.println("A:"+ (int)'A'+ " "+ "a: "+ (int)'a');
        System.out.println("B:"+ (int)'B'+ " "+ "b: "+ (int)'b');
        System.out.println("P:"+ (int)'P'+ " "+ "p: "+ (int)'p');

        Student tim = new Student("Tim");
        Student[] students = {new Student("Zack"), new Student("Tim"), new Student("Ann")};
        Arrays.sort(students);
        System.out.println("Student array sort: "+ Arrays.toString(students));

        Comparator<Student> gpaSorter = new StudentGPAComparator();
        Arrays.sort(students, gpaSorter);
        System.out.println(Arrays.toString(students));

    }
}
