package mysql_query_music;

import com.mysql.cj.jdbc.MysqlDataSource;

import javax.sql.DataSource;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        Properties properties = new Properties();
        try{
            properties.load(Files.newInputStream(Path.of("music.properties"), StandardOpenOption.READ));
        } catch(Exception e){
            e.printStackTrace();
        }

        String albumName = "Tapestry";
        String query = "SELECT * FROM music.albumview "
                + "WHERE album_name = '%s'".formatted(albumName);

        var dataSource = new MysqlDataSource();
        dataSource.setServerName(properties.getProperty("serverName"));
        dataSource.setPort(Integer.parseInt(properties.getProperty("port")));
        dataSource.setDatabaseName(properties.getProperty("databaseName"));

        // all 3 objects Connection, Statement, ResultSet are all resources
        // that need to be closed
        try(Connection conn = dataSource.getConnection(
                properties.getProperty("user"),
                System.getenv("MYSQL_PASS"));
            Statement statement = conn.createStatement();
        ){
            System.out.println("Connection successfully");
            ResultSet resultSet = statement.executeQuery(query);
            var meta = resultSet.getMetaData();
            for(int i = 1; i <= meta.getColumnCount(); i++){
                System.out.printf("%d %s %s %n", i,
                                            meta.getColumnName(i),
                                            meta.getColumnTypeName(i));
            }
            System.out.println("-".repeat(40));
            while (resultSet.next()){
                System.out.printf("%d %s %s %n", resultSet.getInt("track_number"),
                                                resultSet.getString("artist_name"),
                                                resultSet.getString("song_title"));
            }
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
