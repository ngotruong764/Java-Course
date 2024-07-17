package lambda;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class LambdaChallenge {
    public static void main(String[] args) {
        // challenge 1
        System.out.println("Challenge 1");
        Consumer<String> splitString = (String sentence) -> {
            String[] parts = sentence.split(" ");
            for (String part : parts) {
                System.out.println(part);
            }
        };
        splitString.accept("My name is Truong");

        System.out.println("-".repeat(10));

        Consumer<String> splitString2 = sentence -> Arrays.asList(sentence.split(" ")).forEach(s -> System.out.println(s));
        splitString2.accept("My cat name is Nac");

        System.out.println("-".repeat(30));

        // challenge 2
        System.out.println("Challenge 2");
       Function<String, String> everySecondChar = source -> {
           StringBuilder returnVal = new StringBuilder();
           for (int i = 0 ;i < source.length(); i++){
               if(i%2 == 1)
                   returnVal.append(source.charAt(i));
           }
           return returnVal.toString();
       };
       String mini2Res = everySecondChar.apply("1234567890");
       System.out.println(mini2Res);
        System.out.println("-".repeat(30));

        System.out.println("Challenge 4");
        String mini4Res = everySecondCharacter(everySecondChar, "1234567890");
        System.out.println(mini4Res);
        System.out.println("-".repeat(30));

        // challenge 6
        Supplier<String> stringSupplier = () -> "I love Java";
        String iLoveJava = stringSupplier.get();
        System.out.println(iLoveJava);
    }

    // challenge 4
    public static String everySecondCharacter( Function<String, String> function, String source){
        return function.apply(source);
    }
}
