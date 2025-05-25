package main;

import java.time.LocalDate;
import java.util.List;
public class Main {
    public static void main(String[] args) {
        // Setup
        CustomerManager customerManager = new CustomerManager();
        Product apple = new Product("P001", "Apple", 1.99, 100);
        Product banana = new Product("P002", "Banana", 0.99, 150);

        // Add customers
        Customer alice = new Customer("C001", "Alice", "alice@example.com", "1234567890",0);
        customerManager.addCustomer(alice);
        LocalDate today = LocalDate.now();

        // Create a transaction
        List<Product> products = List.of(apple, apple, banana);  // Alice buys 2 apples + 1 banana
        Transactions t1 = new Transactions("T001" , today, alice, List.of(banana, banana) );

        customerManager.displayCustomersWithSpending();
        System.out.printf("Alice's total spending: $%.2f\n",
                customerManager.getCustomerSpending("C001"));

    }
}