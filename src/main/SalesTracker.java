package main;

import java.time.LocalDate;
import java.time.YearMonth;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SalesTracker {
    private List<Transactions> transactions;

    public SalesTracker() {
        this.transactions = new ArrayList<>();
    }

    // Record a new transaction
    public void recordTransaction(Transactions transaction) {
        transactions.add(transaction);
    }

    // Get daily sales
    public double getDailySales(LocalDate date) {
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

    // Generate daily report
    public  void generateDailyReport(LocalDate date) {
        double total = getDailySales(date);
        System.out.printf("Daily Sales Report (%s): $%.2f\n", date, total);
    }

    // Generate monthly report
    public  void generateMonthlyReport(int year, int month) {
        double total = getMonthlySales(year, month);
        System.out.printf("Monthly Sales Report (%d-%02d): $%.2f\n", year, month, total);
    }
}