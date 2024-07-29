package managing_files;

import java.io.*;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;
import java.nio.file.StandardOpenOption;

public class Main {
    public static void main(String[] args) {
         // create a file instance
//        File oldFile = new File("students.json");
//        File newFile = new File("student-activity.json");
//
//        if(oldFile.exists()){
//            oldFile.renameTo(newFile);
//            System.out.println("File renamed successfully!");
//        } else {
//            System.out.println("File does not exist");
//        }

        // rename file
//        Path oldPath = Path.of("students.json");
//        Path newPath = Path.of("files/student-activity.json");
//        try{
//            Files.move(oldPath, newPath);
//            System.out.println("Path renamed successfully");
//        } catch(Exception e){
//            e.printStackTrace();
//        }

       // rename directory
//       Path fileDir = Path.of("files");
//       Path resourceDir = Path.of("resources");
//       try{
//           Files.move(fileDir, resourceDir);
//           System.out.println("Directory renamed");
//       } catch(Exception e){
//           e.printStackTrace();
//       }

        // copy directory
//        Path fileDir = Path.of("files");
//        Path resourceDir = Path.of("resources");
//        try{
//            Files.copy(fileDir, resourceDir);
//            System.out.println("Directory copied to " + resourceDir);
//        } catch(Exception e){
//            e.printStackTrace();
//        }

        Path fileDir = Path.of("files");
        Path resourceDir = Path.of("resources");
        try{
           recurseDelete(resourceDir);
            recurseCopy(fileDir, resourceDir);
            System.out.println("Directory copied to " + resourceDir);
        } catch(Exception e){
            e.printStackTrace();
        }

        try(BufferedReader reader = new BufferedReader(
                new FileReader("files/student-activity.json"))){
            PrintWriter writer = new PrintWriter("students-backup.json");
            reader.transferTo(writer);
        } catch (Exception e){
            e.printStackTrace();
        }

        String urlString = "https://api.census.gov/data/2019/pep/charagegroups?get=NAME,POP&for=state:*";
        URI uri = URI.create(urlString);
        try(var urlInputStream = uri.toURL().openStream()){
            urlInputStream.transferTo(System.out);
        } catch (Exception e){
            e.printStackTrace();
        }

        Path jsonPath = Path.of("USPopulationByState.txt");
        try(var reader = new InputStreamReader(uri.toURL().openStream());
            var writer = Files.newBufferedWriter(jsonPath)){
            reader.transferTo(writer);
        } catch (Exception e){
            e.printStackTrace();
        }

        try(var reader = new InputStreamReader(uri.toURL().openStream());
            PrintWriter writer = new PrintWriter("USPopulationByState.csv")){
            reader.transferTo(new Writer() {
                @Override
                public void write(char[] cbuf, int off, int len) throws IOException {
                    String jsonString = new String(cbuf, off, len).trim();
                    jsonString = jsonString.replace('[', ' ').trim();
                    jsonString = jsonString.replaceAll("\\]", "");
                    writer.write(jsonString);
                }

                @Override
                public void flush() throws IOException {
                    writer.flush();
                }

                @Override
                public void close() throws IOException {

                }
            });
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void recurseCopy(Path source, Path target) throws IOException {
        // Perform shallow copied: meaning none of the directory's content were copied
        Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING);
        if (Files.isDirectory(source)){
            try(var children = Files.list(source)){
                children.toList().forEach(
                        p -> {
                            try {
                                Main.recurseCopy(p, target.resolve(p.getFileName()));
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                );
            } catch (Exception e){
                e.printStackTrace();
            }
        }
    }

    public static void recurseDelete(Path target) throws IOException {
        if (Files.isDirectory(target)){
            try(var children = Files.list(target)){
                children.toList().forEach(
                        p -> {
                            try {
                                Main.recurseDelete(p);
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                );
            } catch (Exception e){
                e.printStackTrace();
            }
        }
        Files.delete(target);
    }
}
