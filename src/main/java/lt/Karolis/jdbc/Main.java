package lt.Karolis.jdbc;

import java.sql.*;

public class Main {
    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/classicmodels",
                    "root",
                    "root");
            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("select * from customers");

            while (resultSet.next())
                System.out.println(resultSet.getInt(1) +
                        " | " +
                        resultSet.getString(2));

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
