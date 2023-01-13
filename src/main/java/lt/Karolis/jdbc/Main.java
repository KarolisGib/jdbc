package lt.Karolis.jdbc;

import java.util.List;


public class Main {
    public static void main(String[] args) {

//        CustomerService customerService = new CustomerService();
        ProductLineService productLineService = new ProductLineService();
//
//        List<Customer> customers = customerService.getAllCustomers();
        List<ProductLine> productLines = productLineService.getAllProductLines();
//
//        customers.forEach(System.out::println);
        productLines.forEach(System.out::println);



    }
}
