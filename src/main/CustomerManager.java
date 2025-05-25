package main;
import java.util.ArrayList;
import java.util.List;

public class CustomerManager {
    private List<Customer> customers;

    public CustomerManager() {
        this.customers = new ArrayList<>();
    }

    // Add a new customer (with validation)
    public boolean addCustomer(Customer customer) {
        if (customer == null || customer.getId() == null || customer.getName() == null) {
            System.err.println("Error: Invalid customer details.");
            return false;
        }

        // Check for duplicate ID
        if (customers.stream().anyMatch(c -> c.getId().equals(customer.getId()))) {
            System.err.println("Error: Customer ID already exists.");
            return false;
        }

        customers.add(customer);
        System.out.println("Customer added: " + customer.getName());
        return true;
    }

    // Remove a customer by ID
    public boolean removeCustomer(String customerId) {
        Customer customer = findCustomerById(customerId);
        if (customer == null) {
            System.err.println("Error: Customer not found with ID: " + customerId);
            return false;
        }

        customers.remove(customer);
        System.out.println("Customer removed: " + customer.getName());
        return true;
    }

    // Update customer details
    public boolean updateCustomer(String customerId, String newName, String newEmail, String newPhone) {
        Customer customer = findCustomerById(customerId);
        if (customer == null) {
            System.err.println("Error: Customer not found.");
            return false;
        }

        customer.setName(newName);
        customer.setEmail(newEmail);
        customer.setPhone(newPhone);
        System.out.println("Customer updated: " + customer.getId());
        return true;
    }

    // Find customer by ID (helper method)
    private Customer findCustomerById(String customerId) {
        return customers.stream()
                .filter(c -> c.getId().equals(customerId))
                .findFirst()
                .orElse(null);
    }

    // Show all customers
    public void displayAllCustomers() {
        if (customers.isEmpty()) {
            System.out.println("No customers found.");
            return;
        }

        System.out.println("\n--- Customer List ---");
        customers.forEach(System.out::println); // Uses toString()
    }
    public void displayCustomersWithSpending() {
        if (customers.isEmpty()) {
            System.out.println("No customers found.");
            return;
        }

        System.out.println("\n--- Customers (Total Spending) ---");
        customers.forEach(System.out::println);  // Uses toString() with totalSpent
    }

    // Get a customer's total spending (by ID)
    public double getCustomerSpending(String customerId) {
        Customer customer = findCustomerById(customerId);
        return customer != null ? customer.getTotalSpent():0.0;
    }

}