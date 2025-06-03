package main;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ExcelExporter {

    public static void exportCustomersToCSV(List<Customer> customers, String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            // Header
            writer.write("ID,Name,Email,Phone,Total Spent\n");

            for (Customer customer : customers) {
                writer.write(String.format("%s,%s,%s,%s,%.2f\n",
                        customer.getId(),
                        customer.getName(),
                        customer.getEmail(),
                        customer.getPhone(),
                        customer.getTotalSpent()));
            }

            System.out.println("Customer CSV file saved: " + fileName);
        } catch (IOException e) {
            System.err.println("Error writing customer CSV: " + e.getMessage());
        }
    }

    public static void exportTransactionsToCSV(List<Transactions> transactions, String fileName) {
        try (FileWriter writer = new FileWriter(fileName)) {
            // Header
            writer.write("Transaction ID,Date,Customer Name,Product List,Total Price\n");

            for (Transactions t : transactions) {
                StringBuilder productList = new StringBuilder();
                double total = 0;
                for (Product p : t.getProducts()) {
                    productList.append(p.getName()).append(" ");
                    total += p.getPrice();
                }

                writer.write(String.format("%s,%s,%s,\"%s\",%.2f\n",
                        t.getId(),
                        t.getDate(),
                        t.getCustomer().getName(),
                        productList.toString().trim(),
                        total));
            }

            System.out.println("Transaction CSV file saved: " + fileName);
        } catch (IOException e) {
            System.err.println("Error writing transaction CSV: " + e.getMessage());
        }
    }
}
