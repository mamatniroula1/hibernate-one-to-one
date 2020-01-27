package test.jdbc.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestJdbc {
    public static void main(String[] args) {
        String url="jdbc:mysql://localhost:3306/hb-01-one-to-one-uni";
        String username="root";
        String password="";

        try (Connection connection = DriverManager.getConnection(url, username, password)) {

            if(!connection.equals(null)){
                System.out.println("you are coonnected to the database ");
            }



        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
