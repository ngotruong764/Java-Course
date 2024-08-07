package scanner_project;

import java.io.File;
import java.util.Scanner;
import java.util.regex.MatchResult;

public class Main {
    public static void main(String[] args) {
        try(Scanner scanner = new Scanner(new File("fixedWidth.txt"))){
//            while (scanner.hasNextLine()){
//                System.out.println(scanner.nextLine());
//            }
//            System.out.println(scanner.delimiter());
//            scanner.useDelimiter("$");
//            scanner.tokens().forEach(System.out::println);
            scanner.findAll("[A-Za-z]{10,}")
                    .map(MatchResult::group)
                    .distinct()
                    .sorted()
                    .forEach(System.out::println);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
