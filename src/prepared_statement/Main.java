package prepared_statement;

import com.mysql.cj.jdbc.MysqlDataSource;

import java.sql.*;

public class Main {

    private static String ARTIST_INSERT = "INSERT INTO music.artists (artist_name) VALUES (?)";
    private static String ALBUM_INSERT = "INSERT INTO music.albums (artist_id, album_name) VALUES (? , ?)";
    private static String SONG_INSERT = "INSERT INTO music.songs (album_id, track_number, song_title) "
            +"VALUES (?, ?, ?)";
    public static void main(String[] args) {
        var datasource = new MysqlDataSource();
        datasource.setServerName("localhost");
        datasource.setPort(3306);
        datasource.setDatabaseName("music");
        try {
            datasource.setContinueBatchOnError(false);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        try(Connection conn = datasource.getConnection(
                System.getenv("MYSQL_USER"),
                System.getenv("MYSQL_PASS"))){
            String sql = "SELECT * FROM music.albumview WHERE artist_name = ?";
            PreparedStatement preparedStatement = conn.prepareStatement(sql);
            preparedStatement.setString(1, "Elf");
            ResultSet rs = preparedStatement.executeQuery();
            printRecords(rs);
        } catch (SQLException e){
            e.printStackTrace();
        }
    }

    private static boolean printRecords(ResultSet resultSet) throws SQLException {
        boolean foundData = false;
        ResultSetMetaData metaData = resultSet.getMetaData();
        System.out.println("=".repeat(40));
        for (int i = 1; i <= metaData.getColumnCount(); i++) {
            System.out.printf("%-15s", metaData.getColumnName(i).toUpperCase());
        }
        System.out.println();

        while (resultSet.next()) {
            for (int i = 1; i <= metaData.getColumnCount(); i++) {
                System.out.printf("%-15s", resultSet.getString(i));
            }
            System.out.println();
            foundData = true;
        }

        return foundData;
    }
}
