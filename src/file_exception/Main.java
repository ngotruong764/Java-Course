package file_exception;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Current Working Directory (cwd) = "+ new File("").getAbsolutePath());
        String filename ="files/testing.csv";
//        testFile2(null);

        File file = new File(filename);
        if(!file.exists()){
            System.out.println("I can't run unless this file exist");
            return;
        }
        System.out.println("I'm good to go");

        for(File f : File.listRoots()){
            System.out.println(f);
        }

        // NIO2 types
        Path path = Paths.get("files/testing.csv");
        if(!Files.exists(path)){
            System.out.println("I can't run unless this file exist");
            return;
        }
        System.out.println("I'm good to go");
    }

    private static void testFile(String fileName){
        Path path = Paths.get(fileName);
        FileReader reader = null;
        try {
//            List<String> lines = Files.readAllLines(path);
            reader  = new FileReader(fileName);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        finally {
            if(reader != null){
                try {
                    reader.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            System.out.println("Maybe I'd log something either way...");
        }
        System.out.println("File exist and able to use as a resource");
    }

    private static void testFile2(String filename){
        try (FileReader reader = new FileReader(filename)) {
        } catch (FileNotFoundException e) {
            System.out.println("File "+ filename + " does not exist");
            throw new RuntimeException(e);
        }catch (NullPointerException | IllegalArgumentException badData){
            System.out.println("User has added bad data "+ badData.getMessage());
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        System.out.println("File exists and able to use as a resource");
    }

}
