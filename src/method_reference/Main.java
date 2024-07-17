package method_reference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.Supplier;

class PlainOld {
    private static int last_id = 1;
    private int id;
    public PlainOld(){
        id = PlainOld.last_id++;
        System.out.println("Creating a PlainOld object: id"+ id);
    }
}
public class Main {
    public static void main(String[] args) {


        List<String> list = new ArrayList<>(List.of("Anna", "Bob", "Chuck", "Dave"));
        list.forEach(System.out::println);

        calculator(Integer::sum, 5, 3);
        calculator(Double::sum, 12.4, 34.6);

        Supplier<PlainOld> referencen1 = PlainOld::new;
        PlainOld newPojo = referencen1.get();

        System.out.println("Getting array");
        PlainOld[] pojo = seedArray(PlainOld::new, 10);

        calculator((s1, s2) -> s1+ s2, "Hello", "World");
        calculator(String::concat, "Hello", "World");
    }
    private static <T> void calculator(BinaryOperator<T> function, T value1, T value2){

        T result = function.apply(value1, value2);
        System.out.println("Result of operation: "+ result);
    }

    private static PlainOld[] seedArray(Supplier<PlainOld> reference, int count){
        PlainOld[] array = new PlainOld[count];
        Arrays.setAll(array, i -> reference.get());
        return array;

    }
}
