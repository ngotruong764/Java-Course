package lambda;

import java.util.Arrays;
import java.util.function.Function;

public class ChainingLambda {
    public static void main(String[] args) {
        String name = "Tim";
        Function<String, String> uCase = String::toUpperCase;
        System.out.println(uCase.apply(name));

        Function<String, String> lastName = s -> s.concat(" Buchalka");
        Function<String, String> uCaseLastName = uCase.andThen(lastName);
        System.out.println(uCaseLastName.apply(name));

        uCaseLastName = uCase.compose(lastName);
        System.out.println(uCaseLastName.apply(name));

        Function<String, String[]> f0 = uCase.andThen(s->s.concat("Buchalka")).andThen(s -> s.split(" "));
        System.out.println(Arrays.toString(f0.apply(name)));
    }
}
