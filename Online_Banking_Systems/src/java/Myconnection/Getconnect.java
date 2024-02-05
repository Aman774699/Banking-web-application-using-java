package Myconnection;

import java.sql.Connection;
import java.sql.DriverManager;

public class Getconnect {

    static public Connection getconnect() {
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Note: It's "com.mysql.cj.jdbc.Driver" for MySQL 8+
//            System.out.println("Driver loaded");
        } catch (Exception e) {
            System.out.println(e);
        }

        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/onlinebanking", "root", "root");
//            System.out.println("Connection established");
        } catch (Exception e) {
            System.out.println(e);
        }
        return con;
    }

}
