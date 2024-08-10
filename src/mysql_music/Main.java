package mysql_music;

import com.mysql.cj.jdbc.MysqlDataSource;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Arrays;

public class Main {
    private final static String CONN_STRING = "jdbc:mysql://localhost:3306/music";
    public static void main(String[] args) {

        String username = JOptionPane.showInputDialog(null, "Enter DB Username");
        JPasswordField pf = new JPasswordField();
        int okCxl = JOptionPane.showConfirmDialog(null, pf, "Enter DB Password", JOptionPane.OK_CANCEL_OPTION);
        final char[] password = (okCxl == JOptionPane.OK_OPTION) ? pf.getPassword() : null;

        /*
        * Connect by using DataSource (RECOMMENDED)
        */
         var dataSource = new MysqlDataSource();
         dataSource.setURL(CONN_STRING);
        // we dont need to close connection because we use with try resources statement
         try(Connection connection = dataSource.getConnection(username, String.valueOf(password))){
             System.out.println("Success!! Connection made to the music database");
         } catch (SQLException e){
             e.printStackTrace();
         }

         /*
         * Connect by using DriverManager
         */
         // we dont need to close connection because we use with try resources statment
        try(Connection connection  = DriverManager.getConnection(
                CONN_STRING, username, String.valueOf(password))) {
            System.out.println("Success!! Connection made to the music database");
            Arrays.fill(password, ' ');
        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
