package lab2;

public class InvoiceTest {
    public static void main(String[] args) {
        Invoice item = new Invoice("A-10", "Молоток", 3, 12.5);
        System.out.println("Товар: " + item.getDescription());
        System.out.println("Количество: " + item.getQuantity());
        System.out.println("Цена за единицу: " + item.getPrice());
        System.out.println("Сумма счёта: " + item.getInvoiceAmount());
    }
}
