package lab2;

public class Invoice {

    private String partNumber;
    private String description;
    private int quantity;
    private double price;

    public Invoice(String partNumber, String description, int quantity, double price) {
        this.partNumber = partNumber;
        this.description = description;
        setQuantity(quantity);
        setPrice(price);
    }

    public void setPartNumber(String partNumber) { this.partNumber = partNumber; }
    public String getPartNumber() { return partNumber; }

    public void setDescription(String description) { this.description = description; }
    public String getDescription() { return description; }

    public void setQuantity(int quantity) { this.quantity = quantity > 0 ? quantity : 0; }
    public int getQuantity() { return quantity; }

    public void setPrice(double price) { this.price = price > 0 ? price : 0.0; }
    public double getPrice() { return price; }

    public double getInvoiceAmount() { return quantity * price; }
}
