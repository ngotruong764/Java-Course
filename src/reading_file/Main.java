package reading_file;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;


public class Main {
    public static void main(String[] args) {
        try(FileReader reader = new FileReader("./testfile.txt")){
            char[] block = new char[100];
            int data;
            while ( (data = reader.read(block)) != -1){
                String content = new String(block, 0, data);
                System.out.printf("-->[%d chars] %s%n", data, content);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("-".repeat(40));

        try(BufferedReader bufferedReader = new BufferedReader(new FileReader("./testfile.txt"))){
            bufferedReader.lines().forEach(System.out::println);
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }
}
