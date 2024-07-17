package lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Supplier;

public class LambdasP1 {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>(List.of("alpha", "bravo", "charlie", "delta"));
        list.replaceAll(s -> s.charAt(0) + "-"+ s.toUpperCase());

        list.removeIf(s -> s.equalsIgnoreCase("bravo")); // bravo is removed

        list.addAll(List.of("echo", "easy", "earnest"));
        list.forEach(s -> System.out.println(s));

        System.out.println("-".repeat(30));
        list.removeIf(s-> s.startsWith("ea"));
        list.forEach(s -> System.out.println(s));
        System.out.println("-".repeat(30));

        System.out.println(list);

        list.forEach(s -> System.out.println(s));

        System.out.println("----------");

        list.forEach(s -> {
            char first = s.charAt(0);
            System.out.println(s+ " means " + first);
        });

        list.replaceAll(s -> s.charAt(0) + "-"+ s.toUpperCase());
        System.out.println(list);

        String[] emptyStrings = new String[10];
        Arrays.setAll(emptyStrings, (i) -> "" + (i+1) + ". ");

        System.out.println(Arrays.toString(emptyStrings));
        Arrays.fill(emptyStrings, "");
        System.out.println(Arrays.toString(emptyStrings));

        Random random = new Random();

        String[] names = {"Ann", "Bob", "Carol", "David", "Ed", "Fred"};
        String[] randomList = randomlySelectedValues(15, names,() -> random.nextInt(0, names.length));
        System.out.println(Arrays.toString(randomList));
        System.out.println("-".repeat(30));
        String[] randomList2 = randomlySelectedValues(15, names, new Supplier<Integer>() {
            @Override
            public Integer get() {
                return random.nextInt(0, names.length);
            }
        });
        System.out.println(Arrays.toString(randomList));
        System.out.println("-".repeat(30));
    }

    public static String[] randomlySelectedValues(int count, String[] values, Supplier<Integer> s){
        String[] selectedValues = new String[count];
        for (int i = 0; i < count ; i++){
            selectedValues[i] = values[s.get()];
        }
        return selectedValues;
    }
}
