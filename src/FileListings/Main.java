package FileListings;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Path path = Path.of("");
        System.out.println("cwd = " + path.toAbsolutePath());

        try (Stream<Path> paths = Files.list(path)) {
            paths.map(Main::listDir)
                    .forEach(System.out::println);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("-".repeat(40));
        //walk
        try (Stream<Path> paths = Files.walk(path)) {
            paths.map(Main::listDir)
                    .forEach(System.out::println);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("-".repeat(40));
        //find
        try (Stream<Path> paths = Files.find(path, Integer.MAX_VALUE,
                 (p, attr) -> attr.isRegularFile() && attr.size() > 300)) {

            paths.map(Main::listDir)
                    .forEach(System.out::println);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("-".repeat(20) + "Directory Stream"+ "-".repeat(20));

        path =path.resolve(".idea");
        try(DirectoryStream<Path> dirs = Files.newDirectoryStream(path, "*.xml")){
            dirs.forEach( d -> System.out.println(Main.listDir(d)));
        } catch (IOException e){
            throw new RuntimeException(e);
        }

        System.out.println("-".repeat(20) + "Directory Stream"+ "-".repeat(20));


        try(DirectoryStream<Path> dirs = Files.newDirectoryStream(path,
                p -> p.getFileName().toString().endsWith(".xml"))){
            dirs.forEach( d -> System.out.println(Main.listDir(d)));
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    private static String listDir(Path path) {
        try {
            boolean isDir = Files.isDirectory(path);
            FileTime dateField = Files.getLastModifiedTime(path);
            LocalDateTime modDT = LocalDateTime.ofInstant(dateField.toInstant(), ZoneId.systemDefault());
            return "%tD %tT %-5s %12s %s".formatted(modDT, modDT, isDir ? "<DIR>" : "", isDir ? "" : Files.size(path), path);
        } catch (IOException e) {
            System.out.println("Whoops! Something went wrong with " + path);
            return path.toString();
        }
    }
}
