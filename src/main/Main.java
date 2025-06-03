package main;

import java.time.LocalDate;
import java.util.List;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        SalesTracker tracker = new SalesTracker();
        Customer alice = new Customer("C001", "Alice", "alice@example.com", "1234567890",0);
        Customer alex = new Customer("C002","Alex", "adfkjadsjlk@gmail.com","2343244",00);
        Product apple = new Product("P001", "Apple", 1.99, 100);

        // Record transactions
        Transactions t1 = new Transactions("T001", LocalDate.now(), alice, List.of(apple, apple));
        Transactions t2 = new Transactions("T002",LocalDate.now(),alex,List.of(apple,apple,apple,apple ));
        // Attempt duplicate (ignored)
        tracker.recordTransaction(t1);
        tracker.recordTransaction(t2);
        // Record transactions
        LocalDate today = LocalDate.now();
        LocalDate yesterday = today.minusDays(1);


        // Correct total spent
        System.out.printf("Alice's total spending: $%.2f\n",
                tracker.getCustomerTotalSpent("C001")); // Output: $3.98
        System.out.printf("Alex's total spending: $%.2f\n",
                tracker.getCustomerTotalSpent("C002"));

     //   SalesTracker.generateDailyReport(LocalDate.now());
     //   SalesTracker.generateDailyReport(yesterday);  // Yesterday's sales
    //    SalesTracker.generateMonthlyReport(today.getYear(), today.getMonthValue());  // Current month

    }
}