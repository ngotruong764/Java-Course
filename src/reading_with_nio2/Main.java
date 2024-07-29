package reading_with_nio2;

import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        System.out.println(System.getProperty("file.encoding"));
        System.out.println(Charset.defaultCharset());

        Path path = Path.of("fixedWidth.txt");
        try{
            System.out.println(new String(Files.readAllBytes(path)));
            System.out.println("-".repeat(40));
            System.out.println(Files.readString(path));
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }
}
