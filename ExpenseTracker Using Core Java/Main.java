import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ExpenseTracker tracker = new ExpenseTracker();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Add Income\n2. Add Expense\n3. Load from File\n4. Save to File\n5. Monthly Summary\n6. Exit");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter category (Salary/Business): ");
                    String cat = sc.nextLine();
                    System.out.print("Enter amount: ");
                    double amt = sc.nextDouble();
                    tracker.addTransaction(new Transaction("Income", cat, amt, LocalDate.now()));
                }
                case 2 -> {
                    System.out.print("Enter category (Food/Rent/Travel): ");
                    String cat = sc.nextLine();
                    System.out.print("Enter amount: ");
                    double amt = sc.nextDouble();
                    tracker.addTransaction(new Transaction("Expense", cat, amt, LocalDate.now()));
                }
                case 3 -> {
                    System.out.print("Enter file path to load: ");
                    String file = sc.nextLine();
                    try {
                        tracker.loadFromFile(file);
                        System.out.println("Loaded successfully.");
                    } catch (Exception e) {
                        System.out.println("Error loading file: " + e.getMessage());
                    }
                }
                case 4 -> {
                    System.out.print("Enter file path to save: ");
                    String file = sc.nextLine();
                    try {
                        tracker.saveToFile(file);
                        System.out.println("Saved successfully.");
                    } catch (Exception e) {
                        System.out.println("Error saving file: " + e.getMessage());
                    }
                }
                case 5 -> {
                    System.out.print("Enter year: ");
                    int year = sc.nextInt();
                    System.out.print("Enter month: ");
                    int month = sc.nextInt();
                    tracker.printMonthlySummary(year, month);
                }
                case 6 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice");
            }
        }
    }
}