package RandomAccess;

import java.io.RandomAccessFile;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BuildStudentData {
    public static void build(String dataFileName, boolean separateIndex){
        Path studentJson = Path.of("students.json");
        String dataFile = dataFileName + ".dat";
        Map<Long, Long> indexedIds = new LinkedHashMap<>();

        try{
            Files.deleteIfExists(Path.of(dataFile));
            String data = Files.readString(studentJson);
            data.replaceFirst("^(\\[)", "").replaceFirst("(\\])$", "");
            var records = data.split(System.lineSeparator());
            System.out.println("# of records = " + records.length);

            long startingPos = separateIndex ? 0 : 4 + (16L * records.length);
            Pattern idPattern = Pattern.compile("studentId\":([0-9]+)");
            try(RandomAccessFile ra = new RandomAccessFile(dataFile, "rw")){
                ra.seek(startingPos);
                for (String record : records){
                    Matcher m = idPattern.matcher(record);
                    if(m.find()){
                        long id = Long.parseLong(m.group(1));
                        indexedIds.put(id, ra.getFilePointer());
                        ra.writeUTF(record);
                    }
                }
                writeIndex((separateIndex) ? new RandomAccessFile(dataFileName + ".idx", "rw") : ra, indexedIds);
            }catch (Exception e){
                e.printStackTrace();
            }
        } catch(Exception e){
            e.printStackTrace();
        }
    }

    private static void writeIndex(RandomAccessFile ra, Map<Long,Long> indexMap){
        try{
            ra.seek(0);
            ra.writeInt(indexMap.size());
            for(var studenIdx: indexMap.entrySet()){
                ra.writeLong(studenIdx.getKey());
                ra.writeLong(studenIdx.getValue());
            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
