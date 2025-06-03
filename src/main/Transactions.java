package main;

import java.time.LocalDate;
import java.util.List;

public class Transactions {
    private String id;
    private Customer customer;  // Link to customer
    private List<Product> products;
    private double totalAmount;
    private LocalDate date;

    // Constructor

    public Transactions(String id, LocalDate date, Customer customer, List<Product> products) {
        this.id = id;
        this.date = date;
        this.customer = customer;
        this.products = products;
        this.totalAmount = calculateTotal();
    }

    private double calculateTotal() {
        return products.stream().mapToDouble(Product::getPrice).sum();
    }

    // Getters
    public Customer getCustomer() { return customer; }
    public double getTotalAmount() { return totalAmount; }
    public LocalDate getDate() { return date; }
    public String getId() { return id; }
    public List<Product> getProducts() {return products;
    }




    }
