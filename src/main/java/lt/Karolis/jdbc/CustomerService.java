package lt.Karolis.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerService {

    Repository repository = new Repository();

    public List<Customer> getAllCustomers() {

        List<Customer> customers = new ArrayList<>();

        try(Connection connection = repository.getConnection()) {

            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("select * from customers");

            while (resultSet.next()) {
                Customer customer = new Customer(
                        resultSet.getInt("customerNumber"),
                        resultSet.getString("customerName"),
                        resultSet.getString("phone"),
                        resultSet.getString("city")
                );
                customers.add(customer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customers;
    }
}
