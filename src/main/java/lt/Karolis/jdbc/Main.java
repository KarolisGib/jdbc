package lt.Karolis.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        Repository repository = new Repository();

        try(Connection connection = repository.getConnection()) {

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

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
