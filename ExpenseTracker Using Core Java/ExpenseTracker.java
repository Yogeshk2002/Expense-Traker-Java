import java.io.*;
import java.time.LocalDate;
import java.time.YearMonth;
import java.util.*;

public class ExpenseTracker {
    private List<Transaction> transactions = new ArrayList<>();

    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    public void loadFromFile(String filename) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        String line;
        while ((line = reader.readLine()) != null) {
            transactions.add(Transaction.fromString(line));
        }
        reader.close();
    }

    public void saveToFile(String filename) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(filename));
        for (Transaction t : transactions) {
            writer.write(t.toString());
            writer.newLine();
        }
        writer.close();
    }

    public void printMonthlySummary(int year, int month) {
        YearMonth yearMonth = YearMonth.of(year, month);
        double income = 0, expense = 0;
        for (Transaction t : transactions) {
            if (YearMonth.from(t.getDate()).equals(yearMonth)) {
                if (t.getType().equalsIgnoreCase("Income")) {
                    income += t.getAmount();
                } else {
                    expense += t.getAmount();
                }
            }
        }
        System.out.println("Summary for " + yearMonth);
        System.out.println("Total Income: " + income);
        System.out.println("Total Expense: " + expense);
        System.out.println("Net Balance: " + (income - expense));
    }
}