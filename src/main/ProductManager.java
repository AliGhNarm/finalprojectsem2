package main;

import java.util.ArrayList;
import java.util.List;

public class ProductManager {
    private List<Product> products;

    // Constructor
    public ProductManager() {
        this.products = new ArrayList<>();
    }

    // Add a new product
    public boolean addProduct(Product product) {
        if (product == null || product.getId() == null || product.getName() == null) {
            System.err.println("Error: Invalid product details.");
            return false;
        }

        // Check if product ID already exists
        for (Product p : products) {
            if (p.getId().equals(product.getId())) {
                System.err.println("Error: Product ID already exists.");
                return false;
            }
        }

        products.add(product);
        System.out.println("Product added: " + product.getName());
        return true;
    }

    // Remove a product by ID
    public boolean removeProduct(String productId) {
        if (productId == null || productId.trim().isEmpty()) {
            System.err.println("Error: Invalid product ID.");
            return false;
        }

        for (Product p : products) {
            if (p.getId().equals(productId)) {
                products.remove(p);
                System.out.println("Product removed: " + p.getName());
                return true;
            }
        }

        System.err.println("Error: Product not found with ID: " + productId);
        return false;
    }

    // Get all products (read-only)
    public List<Product> getAllProducts() {
        return new ArrayList<>(products); // Return a copy to avoid external modification
    }
}