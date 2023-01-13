package lt.Karolis.jdbc;

import java.sql.SQLException;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        CustomerService customerService = new CustomerService();
        ProductLineService productLineService = new ProductLineService();

        List<Customer> customers = customerService.getAllCustomers();
        List<ProductLine> productLines = productLineService.getAllProductLines();

        customers.forEach(System.out::println);
//        productLines.forEach(System.out::println);

        System.out.println("===================");

        Customer customer01 = new Customer(
                497,
                "customerNameKarolis",
                "LastNameG",
                "firstNameK",
                "just_phone",
                "addressKaune",
                "Kaunas",
                "Lithuania"
                );

        customerService.createCustomer(customer01);

        customers = customerService.getAllCustomers();
        customers.forEach(System.out::println);
        try{
            Repository.closeConnection();
        }catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
