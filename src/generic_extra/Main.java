package generic_extra;

import java.util.ArrayList;
import java.util.List;

import generic_extra.model.LPAStudent;
import generic_extra.model.Student;

public class Main {
    public static void main(String[] args) {
        int studentCount = 10;
        List<Student> students = new ArrayList<>();
        for(int i =0; i<studentCount; i++){
            students.add(new Student());
        }
//        printList(students);
        printMoreList(students);
        List<LPAStudent> lpaStudents = new ArrayList<>();
        for(int i =0; i<studentCount; i++){
            lpaStudents.add(new LPAStudent());
        }
//        printList(lpaStudents);
        printMoreList(lpaStudents);
    }

//    public static <T extends Student> void printList(List<T> students){
//        for(var student : students){
//            System.out.println(student);
//        }
//        System.out.println();
//    }

    public static  void printMoreList(List<? extends Student> students){
        for(var student : students){
            System.out.println(student);
        }
        System.out.println();
    }

//    public static void testList(List<String> list){
//        for(var element: list){
//            System.out.println("String: "+ element.toUpperCase());
//        }
//    }
//
//    public static void testList(List<Integer> list){
//        for(var element: list){
//            System.out.println("Integer: "+ element.floatValue());
//        }
//    }
}
