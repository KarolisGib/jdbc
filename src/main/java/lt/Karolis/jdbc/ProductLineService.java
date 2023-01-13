package lt.Karolis.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ProductLineService {

    Repository repository = new Repository();

    public List<ProductLine> getAllProductLines() {

        List<ProductLine> productLines = new ArrayList<>();

        try(Connection connection = repository.getConnection()) {

            Statement stmt = connection.createStatement();
            ResultSet resultSet = stmt.executeQuery("select * from productlines");

            while (resultSet.next()) {
                ProductLine productLine = new ProductLine(
                        resultSet.getString("productLine"),
                        resultSet.getString("textDescription"),
                        resultSet.getString("htmlDescription")
                );
                productLines.add(productLine);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return productLines;
    }
}
