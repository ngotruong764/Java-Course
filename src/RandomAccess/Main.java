package RandomAccess;

import java.io.RandomAccessFile;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    private static final Map<Long, Long> indexedIds = new LinkedHashMap<>();
    private static int recordsInFile = 0;
    public static void main(String[] args) {
//        BuildStudentData.build("studentData");
        BuildStudentData.build("student", true);
        try(RandomAccessFile ra = new RandomAccessFile("studentData.dat", "r")){
            loadIndex(ra, 0);
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter a Student Id or 0 to quit");
            while (scanner.hasNext()){
                long studentId = Long.parseLong(scanner.nextLine());
                if(studentId < 1){
                    break;
                }
                ra.seek(indexedIds.get(studentId));
                String targetedRecord = ra.readUTF();
                System.out.println(targetedRecord);
                System.out.println("Enter a Student Id or 0 to quit");
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private static void loadIndex(RandomAccessFile ra, int indexPosition){
        try{
            ra.seek(indexPosition);
            recordsInFile = ra.readInt();
            System.out.println(recordsInFile);
            for(int i = 0; i < recordsInFile; i++){
                indexedIds.put(ra.readLong(), ra.readLong());
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
