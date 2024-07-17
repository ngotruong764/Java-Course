package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;

public class Main {
    //The record is implicitly static when use an inner class( enum, interface are the same)
    record Person(String firstName, String lastName) {
        @Override
        public String toString() {
            return firstName + " " + lastName;
        }
    }

    public static void main(String[] args) {
        List<Person> people = new ArrayList<>(Arrays.asList(new Person("Lucy", "Van Pelt"),
                new Main.Person("Sally", "Brown"),
                new Person("Linus", "Van Pelt"),
                new Person("Peppermint", "Patty"),
                new Person("Charlie", "Brown")));

        //using anonymous class
        var comparatorLastName = new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.lastName.compareTo(o2.lastName);
            }
        };

        people.sort((o1, o2) -> o1.lastName.compareTo(o2.lastName));
        System.out.println(people);

        interface EnhancedComparator<T> extends Comparator<T> {
            int secondLevel(T o1, T o2);
        }

        var comparatorMixed = new EnhancedComparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                int result = o1.lastName.compareTo(o2.lastName);
                return (result == 0 ? secondLevel(o1, o2) : result);
            }

            @Override
            public int secondLevel(Person o1, Person o2) {
                return o1.firstName.compareTo(o2.firstName);
            }
        };

        people.sort(comparatorMixed);
        System.out.println(people);

        int result = calculator((a, b) -> a + b, 12, 13);

        int result2 = calculator((var a, var b) -> a / b, 10, 2);

        var coors = Arrays.asList(new double[]{47.2160, -95.2348},
                                                new double[]{29.1556, -89.2455},
                                                new double[]{35.1556, -90.0659});
        coors.forEach(s -> System.out.println(Arrays.toString(s)));

        BiConsumer<Double, Double> p1 = (lat, lng) -> {
            System.out.printf("[lat:%.3f lon:%.3f]%n", lat, lng);
        };
        var firstPoint = coors.get(0);
        processPoint(firstPoint[0], firstPoint[1], p1);

        System.out.println("-".repeat(30));
        coors.forEach(s -> processPoint(s[0], s[1], p1)); // equal

        System.out.println("-".repeat(30));
        coors.forEach(s -> processPoint(s[0], s[1], (lat, lng) -> System.out.printf("[lat:%.3f lon:%.3f]\n" , lat, lng))); // equal


    }
    public static <T> void processPoint(T t1, T t2, BiConsumer<T, T> consumer){
        consumer.accept(t1, t2);
    }

    public static <T> T calculator(BinaryOperator<T> function, T value1, T value2) {
        T result = function.apply(value1, value2);
        System.out.println("result of operation: " + result);
        return result;
    }


}
