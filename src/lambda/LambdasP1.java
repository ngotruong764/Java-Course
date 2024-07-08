package lambda;

import java.util.ArrayList;
import java.util.List;

public class LambdasP1 {
    public static void main(String[] args) {

        List<String> list = new ArrayList<>(List.of("alpha", "bravo", "charlie", "delta"));

        list.forEach(s -> System.out.println(s));

        System.out.println("----------");

        list.forEach(s -> {
            char first = s.charAt(0);
            System.out.println(s+ " means " + first);
        });
    }
}
