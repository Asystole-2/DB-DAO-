package BusinessObjects;
import java.util.Scanner;

import DAOs.ExpenseDaoInterface;
import DTOs.Expense;

public class App
{
    public static void main(String[] args)
    {
        menuOptions menu = new menuOptions();
        Scanner in = new Scanner(System.in);

        while (true) {
            try {
                menu.menuOptions();
                int choice = Integer.parseInt(in.nextLine());
                switch (choice) {
                    case 1 -> findAllExpenses();
                    case 2 -> addAnExpense();
                    case 3 -> deleteAnExpense();
                    case 4 -> findAllIncomes();
                    case 5 -> addAnIncome();
                    case 6 -> deleteAnIncome();
                    case 7 -> findIncomeByMonth();
                    case 8 -> {
                        System.out.println("Exiting...");
                        return;
                    }
                    default -> System.out.println("Invalid choice. Please try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid number.");
            } catch (Exception e) {
                System.out.println("An unexpected error occurred: " + e.getMessage());
            }
        }

    }

    public static void findAllExpenses() {
        System.out.println("yay"); //test
    }
    public static void addAnExpense (){}
    public static void deleteAnExpense(){}
    public static void findAllIncomes(){}
    public static void findIncomeByMonth(){}
    public static void addAnIncome(){}
    public static void deleteAnIncome(){}

}
