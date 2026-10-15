
package bank.management.system;

import java.sql.*;
import java.io.FileInputStream;
import java.util.Properties;

public class Conn {
    Connection c;
    Statement s;

    public Conn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Properties p = new Properties();
            p.load(new FileInputStream("db.properties"));

            String user = p.getProperty("db.user");
            String password = p.getProperty("db.password");

            c = DriverManager.getConnection(
                "jdbc:mysql:///bankmanagementsystem",
                user,
                password
            );

            s = c.createStatement();

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}




