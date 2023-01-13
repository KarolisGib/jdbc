package lt.Karolis.jdbc;

public class ProductLine {
    private String productLine;
    private String textDescription;
    private String htmlDescription;
   

    public ProductLine(String productLine, String textDescription) {
        this.productLine = productLine;
        this.textDescription = textDescription;
    }

    public ProductLine(String productLine,
                       String textDescription,
                       String htmlDescription) {
        this.productLine = productLine;
        this.textDescription = textDescription;
        this.htmlDescription = htmlDescription;
     }

    public String getProductLine() {
        return productLine;
    }

    public String getTextDescription() {
        return textDescription;
    }

    public String getHtmlDescription() {
        return htmlDescription;
    }

    public void setProductLine(String productLine) {
        this.productLine = productLine;
    }

    public void setTextDescription(String textDescription) {
        this.textDescription = textDescription;
    }

    public void setHtmlDescription(String htmlDescription) {
        this.htmlDescription = htmlDescription;
    }

    @Override
    public String toString() {
        return "{" +
                "ProductLine: " + productLine +
                ", TextDescription: " + textDescription + '\'' +
                ", htmlDescription: " + htmlDescription + '\'' +
                '}';
    }
}
