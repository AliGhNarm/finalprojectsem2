package main;

public class Customer {
    private String id;
    private String name;
    private String email;
    private String phone;
    private double totalSpent;  // New field

    public Customer(String id, String name, String email, String phone, double totalSpent) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.totalSpent = 0.0;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getEmail() { return email; }
    public String getPhone() { return phone; }

    public void setName(String name) { this.name = name; }
    public void setEmail(String email) { this.email = email; }
    public void setPhone(String phone) { this.phone = phone; }
    public double getTotalSpent() { return totalSpent; }
    public void addToTotalSpent(double amount) { this.totalSpent += amount; }

    @Override
    public String toString() {
        return String.format(
                "ID: %s | Name: %s | Email: %s | Phone: %s | Total Spent: $%.2f",
                id, name, email, phone, totalSpent
        );
    }


}
