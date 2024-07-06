package generic_extra;

import java.util.ArrayList;
import java.util.List;

import generic_extra.model.LPAStudent;
import generic_extra.model.Student;
import generic_extra.util.QueryList;

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

        var queryList = new QueryList<>(lpaStudents);
//        var matches = queryList.getMatches("Course", "Python");
//        printMoreList(matches);
        var students2021 = QueryList.getMatches(students, "YearStarted", "2021");
        printMoreList(students2021);

//        QueryList<Employee> employeeQueryList = new QueryList<Employee>();
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
