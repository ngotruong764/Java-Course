package mysql_query_music;

import java.sql.*;

public class MusicDML {
    public static void main(String[] args) {
        // get connection using JDBC driver, that's earlier than JDBC 4.0
        try {
            // necessary in older JDBC versions, and allowed the database
            // driver to be registered dynamically.
            // This has been replaced for something called ServiceProvider Interface.
            // this Class.forName() is legacy code
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        try (Connection connection = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/music",
                System.getenv("MYSQL_USER"),
                System.getenv("MYSQL_PASS"));
             Statement statement = connection.createStatement()) {
            System.out.println("Connection Successfully");
            String tableName = "music.artists";
            String columnName = "artist_name";
            String columnValue = "Bob Dylan";
            if (!executeSelect(statement, tableName, columnName, columnValue)) {
//                System.out.println("Maybe we should add this record");
//                System.out.println(insertRecord(statement, tableName, new String[]{columnName}, new String[]{columnValue}));
                insertArtistAlbum(statement, columnValue, columnValue);
            } else{
//                deleteRecords(statement, tableName, columnName, columnValue);
//                updateRecords(statement, tableName, columnName, columnValue, columnName, columnValue.toUpperCase());
                try{
                    deleteArtistAlbum(connection, statement, columnValue,columnValue);
                } catch (SQLException e){
                    e.printStackTrace();
                }
                executeSelect(statement, "music.albumview", "album_name", columnValue);
                executeSelect(statement, "music.albums", "album_name", columnValue);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
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

    private static boolean executeSelect(Statement statement, String table,
                                         String columnName, String columnValue) throws SQLException {
        String query = "SELECT * FROM %s WHERE %s = '%s'".formatted(table, columnName, columnValue);
        ResultSet rs = statement.executeQuery(query);
        if (rs != null) {
            return printRecords(rs);
        }
        return false;
    }

    private static boolean insertRecord(Statement statement, String table,
                                        String[] columnNames, String[] columnValues) throws SQLException {
        String colNames = String.join(",", columnNames);
        String colValues = String.join(",", columnValues);
        String query = "INSERT INTO %s (%s) VALUES ('%s')".formatted(table, colNames, colValues);
        return statement.execute(query);
    }

    private static boolean deleteRecords(Statement statement, String table, String columnName, String columnValue)
            throws SQLException {
        String query = "DELETE FROM %s WHERE %s= '%s'".formatted(table, columnName, columnValue);
        System.out.println(query);
        statement.execute(query);
        int recordsDeleted = statement.getUpdateCount();
        if(recordsDeleted > 0){
            executeSelect(statement, table, columnName, columnValue);
        }
        return recordsDeleted > 0;
    }

    private static boolean updateRecords(Statement statement, String table, String matchedColumn, String matchedValue, String updatedColumn, String updatedValue)
            throws SQLException {
        String query = "UPDATE %s SET %s = '%s' WHERE %s= '%s'".formatted(table, updatedColumn, updatedValue, matchedColumn, matchedValue);
        System.out.println(query);
        statement.execute(query);
        int recordsUpdated = statement.getUpdateCount();
        if(recordsUpdated > 0){
            executeSelect(statement, table, updatedColumn, updatedColumn);
        }
        return recordsUpdated > 0;
    }

    private static void insertArtistAlbum(Statement statement, String artistName, String albumName)
            throws SQLException{
        String artistInsert = "INSERT INTO music.artists (artist_name) VALUES (%s)"
                .formatted(statement.enquoteLiteral(artistName));
        System.out.println(artistInsert);
        // This will return automatically generated id and store in
        // a special ResultSet
        statement.execute(artistInsert, Statement.RETURN_GENERATED_KEYS);
        ResultSet rs = statement.getGeneratedKeys();
        int artistId = (rs != null && rs.next()) ? rs.getInt(1) : -1;
        String albumInsert = ("INSERT INTO  music.albums (album_name, artist_is) " +
                                "VALUE (%s, %d)").formatted(statement.enquoteLiteral(albumName), artistId);
        System.out.println(albumInsert);
        //
        statement.execute(albumInsert, Statement.RETURN_GENERATED_KEYS);
        rs = statement.getGeneratedKeys();
        int albumId = (rs != null && rs.next()) ? rs.getInt(1) : -1;
        System.out.println(rs.getInt(2));
        //
        String[] songs = new String[]{"You're No God",
                                    "Talkin' New York",
                                    "In My Time of Dyin'",
                                    "Man of Constant Sorrow",
                                    "Fixin' to Die",
                                    "Pretty Peggy-O",
                                    "Highway 51 Blues"};
        String songInsert = "INSERT INTP music.songs " + "(track_number, song_title, album_id) VALUES (%d, %s, %d)";
        for (int i = 0; i < songs.length; i++){
            String songQuery = songInsert.formatted(i+ 1, statement.enquoteLiteral(songs[i]), albumId);
            System.out.println(songQuery);
            statement.execute(songQuery);
        }
        executeSelect(statement, "music.albumview", "album_name", "Bob Dylan");
    }

    private static void deleteArtistAlbum(Connection conn, Statement statement,
                                          String artistName, String albumName) throws SQLException {
        try{
            System.out.println("AUTOCOMMIT = "+ conn.getAutoCommit());
            // turn off auto commit
            conn.setAutoCommit(false);

            String deleteSongs = """
                DELETE FROM music.songs WHERE album_id =\s
                (SELECT ALBUM_ID FROM music.albums WHERE album_name = '%s' )""";
            String deleteAlbums = "DELETE FROM music.albums WHERE album_name = '%s' ".formatted(albumName);
            //
            String deleteArtist = "DELETE FROM music.artists WHERE artist_name = '%s' ".formatted(artistName);
            // add batch
            statement.addBatch(deleteSongs);
            statement.addBatch(deleteAlbums);
            statement.addBatch(deleteArtist);
            statement.executeBatch();

            // commit change in database
            conn.commit();
        } catch(SQLException e){
            e.printStackTrace();
            conn.rollback();
        }
        conn.setAutoCommit(true);
    }
}
