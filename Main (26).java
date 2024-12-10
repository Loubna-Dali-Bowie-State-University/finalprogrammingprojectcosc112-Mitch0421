 /******************************************************************************

Welcome to GDB Online.
GDB online is an online compiler and debugger tool for C, C++, Python, Java, PHP, Ruby, Perl,
C#, OCaml, VB, Swift, Pascal, Fortran, Haskell, Objective-C, Assembly, HTML, CSS, JS, SQLite, Prolog.
Code, Compile, Run and Debug online from anywhere in world.

*******************************************************************************/
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InventoryManager manager = new InventoryManager();

        // Sample suppliers
        Supplier supplier1 = new Supplier("S001", "Acme Supplies", "123-456-789");
        manager.addSupplier(supplier1);

        // Sample products
        Product product1 = new Product("P001", "Laptop", 10, 1000.00, "S001");
        Product product2 = new Product("P002", "Smartphone", 20, 500.00, "S001");
        manager.addProduct(product1);
        manager.addProduct(product2);

        // Menu-driven application
        while (true) {
            System.out.println("\nInventory Management System");
            System.out.println("1. Add Product");
            System.out.println("2. Update Product Stock");
            System.out.println("3. Process Sale");
            System.out.println("4. Check Low Stock");
            System.out.println("5. Generate Sales Report");
            System.out.println("6. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    // Add product
                    System.out.print("Enter product ID: ");
                    String productId = scanner.next();
                    System.out.print("Enter product name: ");
                    String name = scanner.next();
                    System.out.print("Enter stock level: ");
                    int stock = scanner.nextInt();
                    System.out.print("Enter price: ");
                    double price = scanner.nextDouble();
                    System.out.print("Enter supplier ID: ");
                    String supplierId = scanner.next();
                    Product newProduct = new Product(productId, name, stock, price, supplierId);
                    manager.addProduct(newProduct);
                    break;

                case 2:
                    // Update stock level
                    System.out.print("Enter product ID: ");
                    productId = scanner.next();
                    System.out.print("Enter new stock level: ");
                    int newStock = scanner.nextInt();
                    manager.updateStock(productId, newStock);
                    break;

                case 3:
                    // Process sale
                    System.out.print("Enter product ID: ");
                    productId = scanner.next();
                    System.out.print("Enter quantity sold: ");
                    int quantitySold = scanner.nextInt();
                    Sale sale = new Sale(productId, quantitySold);
                    manager.processSale(sale);
                    break;

                case 4:
                    // Check low stock
                    manager.checkLowStock();
                    break;

                case 5:
                    // Generate sales report
                    manager.generateSalesReport();
                    break;

                case 6:
                    // Exit
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
