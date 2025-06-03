package main;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.*;

public class SalesTracker {
    private List<Transactions> transactions;  // Changed to singular
    private Set<String> recordedTransactionIds;

    public SalesTracker() {
        this.transactions = new ArrayList<>();
        this.recordedTransactionIds = new HashSet<>();
    }

    // Record transaction (with duplicate check)
    public void recordTransaction(Transactions transaction) {
        if (recordedTransactionIds.contains(transaction.getId())) {
            System.err.println("Error: Transaction ID already recorded: " + transaction.getId());
            return;
        }
        transactions.add(transaction);
        recordedTransactionIds.add(transaction.getId());
    }

    // Get a customer's total spending (calculated dynamically)
    public double getCustomerTotalSpent(String customerId) {
        return transactions.stream()
                .filter(t -> t.getCustomer().getId().equals(customerId))
                .mapToDouble(Transactions::getTotalAmount)
                .sum();
    }

    // Instance method for daily sales
    public double getDailySales(LocalDate date) {
        return transactions.stream()
                .filter(t -> t.getDate().equals(date))
                .mapToDouble(Transactions::getTotalAmount)
                .sum();
    }

    // Static version that takes transactions as parameter
    public static double getDailySales(List<Transactions> transactions, LocalDate date) {
        return transactions.stream()
                .filter(t -> t.getDate().equals(date))
                .mapToDouble(Transactions::getTotalAmount)
                .sum();
    }

    // Get monthly sales
    public double getMonthlySales(int year, int month) {
        YearMonth targetMonth = YearMonth.of(year, month);
        return transactions.stream()
                .filter(t -> YearMonth.from(t.getDate()).equals(targetMonth))
                .mapToDouble(Transactions::getTotalAmount)
                .sum();
    }

    // Generate daily report (instance version)
    public void generateDailyReport(LocalDate date) {
        double total = getDailySales(date);
        System.out.printf("Daily Sales Report (%s): $%.2f\n", date, total);
    }

    // Static version that takes transactions as parameter
    public static void generateDailyReport(List<Transactions> transactions, LocalDate date) {
        double total = getDailySales(transactions, date);
        System.out.printf("Daily Sales Report (%s): $%.2f\n", date, total);
    }

    // Generate monthly report
    public void generateMonthlyReport(int year, int month) {
        double total = getMonthlySales(year, month);
        System.out.printf("Monthly Sales Report (%d-%02d): $%.2f\n", year, month, total);
    }

    // Getter for transactions (needed for static methods)
    public List<Transactions> getTransactions() {
        return Collections.unmodifiableList(transactions);
    }
    private List<Customer> customers = new ArrayList<>();

    public List<Customer> getAllCustomers() {
        return new ArrayList<>(customers); // Return a copy
    }

    public List<Transactions> getAllTransactions() {
        return new ArrayList<>(transactions); // Return a copy
}}