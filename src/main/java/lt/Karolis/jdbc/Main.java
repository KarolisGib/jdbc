package lt.Karolis.jdbc;

import java.io.FileInputStream;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Main {
    public static void main(String[] args) {
        try {
            Properties properties = new Properties();
            FileInputStream fileInputStream = new FileInputStream("./src/main/resources/db.properties");

            properties.load(fileInputStream);

            String url = properties.getProperty("db.url");
            String username = properties.getProperty("db.username");
            String password = properties.getProperty("db.password");

            Connection connection = DriverManager.getConnection(
                    url,
                    username,
                    password
            );


            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("select * from customers");

            List<Customer> customers = new ArrayList<>();

            while (resultSet.next()) {
                Customer customer = new Customer(
                        resultSet.getInt("customerNumber"),
                        resultSet.getString("customerName"),
                        resultSet.getString("phone"),
                        resultSet.getString("city")
                );
                customers.add(customer);
            }

            customers.forEach(System.out::println);

            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
