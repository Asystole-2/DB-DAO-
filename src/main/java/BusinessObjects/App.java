package BusinessObjects;
import java.util.List;
import java.util.Scanner;

import DAOs.ExpenseDAO;
import DAOs.ExpenseDaoInterface;
import DAOs.IncomeDAO;
import DAOs.IncomeDaoInterface;
import DTOs.Expense;
import DTOs.Income;
import Exceptions.DaoException;

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
                    case 7 -> findIncomeAndExpensesByMonth();
                    case 8 -> {
                        System.out.println("Exiting...\nThank you for using this FinanceTracker\n\n     （づ￣3￣）づ❤️～");
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

    public static void findAllExpenses() throws DaoException {

        ExpenseDaoInterface IExpenseDao = new ExpenseDAO();
        double totalExpenses = 0;

        System.out.println("• All expenses: ");
        List<Expense> expenses = IExpenseDao.findAllExpenses();
        if (expenses.isEmpty()) {
            System.out.println("No expenses found.");
            System.out.println("Exiting...");
            return;
        }
        for (Expense expense : expenses) {
            System.out.println("Expense: "+expense.toString());
            totalExpenses += expense.getAmount();
        }
        System.out.println("** Total expenses: "+totalExpenses);
    }
    public static void addAnExpense () throws DaoException {
        ExpenseDaoInterface IExpenseDao = new ExpenseDAO();
        Scanner in = new Scanner(System.in);
        String title, category, dateIncurred;
        double amount = 0;

        try{
        System.out.println("**  New Expense  ** \nEnter the following details for the new expense [Enter 'cancel' at any stage to stop]: ");
            System.out.print("Title: ");
            title = in.nextLine();
            if (title.equalsIgnoreCase("cancel")) return;

            System.out.print("Category: ");
            category = in.nextLine();
            if (category.equalsIgnoreCase("cancel")) return;

            System.out.print("Amount: ");
            String amountInput = in.nextLine();
            if (amountInput.equalsIgnoreCase("cancel")) return;
            amount = Double.parseDouble(amountInput);

            System.out.print("Date Incurred [Enter in the format (YYYY-MM-DD)]: ");
            dateIncurred = in.nextLine();
            if (dateIncurred.equalsIgnoreCase("cancel")) return;

            IExpenseDao.addAnExpense(title, category, amount, dateIncurred);
            System.out.println("Expense added successfully!");

        } catch (NumberFormatException e) {
            System.out.println("Invalid amount. Please enter a numeric value.");
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }

    }
    public static void deleteAnExpense() throws DaoException {

        ExpenseDaoInterface IExpenseDao = new ExpenseDAO();
        Scanner in = new Scanner(System.in);
        int expense_id;

        System.out.println("**  Remove an Expense  ** \nEnter the id for the expense you wish to delete [Enter '-1' to stop]: ");
        expense_id = in.nextInt();
        if (expense_id == -1) {
            System.out.println("Back to menu");
            return;
        }
        IExpenseDao.deleteAnExpense(expense_id);
        System.out.println("Expense removed successfully!");
    }
    public static void findAllIncomes() throws DaoException {

        IncomeDaoInterface IIncomeDao = new IncomeDAO();
        double totalIncome = 0;

        System.out.println("• All Incomes: ");
        List<Income> incomes = IIncomeDao.findAllIncomes();
        if (incomes.isEmpty()) {
            System.out.println("No incomes found.");
            System.out.println("Exiting...");
            return;
        }
        for (Income income : incomes) {
            System.out.println("Income: "+income.toString());
            totalIncome += income.getAmount();
        }
        System.out.println("** Total Incomes: "+totalIncome);
    }
    public static void addAnIncome() throws DaoException {

        IncomeDaoInterface IIncomeDao = new IncomeDAO();
        Scanner in = new Scanner(System.in);
        String  title, dateEarned;
        double amount = 0;

        try {
            System.out.println("**  New Income Entry  ** \nEnter the following details for the new income entry [Enter 'cancel' at any stage to stop]: ");
            System.out.println("Title: ");
            title = in.nextLine();
            if (title.equalsIgnoreCase("cancel")) return;

            System.out.println("DateEarned: ");
            dateEarned = in.nextLine();
            if (dateEarned.equalsIgnoreCase("cancel")) return;

            System.out.println("Amount: ");
            String amountInput = in.nextLine();
            if (amountInput.equalsIgnoreCase("cancel")) return;
            amount = Double.parseDouble(amountInput);

            IIncomeDao.addAnIncome(title, amount, dateEarned);
            System.out.println("Income added successfully!");

        } catch (NumberFormatException e) {
            System.out.println("Invalid amount. Please enter a numeric value.");
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }

    }
    public static void deleteAnIncome() throws DaoException {

        IncomeDaoInterface IIncomeDao = new IncomeDAO();
        Scanner in = new Scanner(System.in);
        int income_id;

        System.out.println("**  Delete an income record  ** \nEnter the id for the income record you wish to delete [Enter '-1' to stop]: ");
        income_id = in.nextInt();
        if (income_id == -1) {
            System.out.println("Back to menu");
            return;
        }
        IIncomeDao.deleteAnIncome(income_id);
        System.out.println("Income removed successfully!");
    }
    public static void findIncomeAndExpensesByMonth() throws DaoException {
        IncomeDaoInterface IIncomeDao = new IncomeDAO();
        ExpenseDaoInterface IExpenseDao = new ExpenseDAO();
        Scanner in = new Scanner(System.in);
        String month;
        double totalIncome = 0 , totalExpenditure = 0, discretionaryIncome = 0;

        System.out.println("**  Monthly income and expenditure  ** \nEnter the month for which you wish to see the income and expenses [include year and enter in the format  YYYY-MM eg 2025-02 ] (Enter 'cancel' to stop)): ");

        month = in.next();
        if (month.equalsIgnoreCase("cancel")) return;

        List<Income> incomes = IIncomeDao.findIncomeByMonth(month);
        List<Expense> expenses = IExpenseDao.findExpensesByMonth(month);

        System.out.println("**  Monthly income and expenditure for "+month+": \nIncome:\n");
        for (Income income : incomes) {
            System.out.println("Income: "+income.toString());
            totalIncome = totalIncome + income.getAmount();
        }
        System.out.println("** Total Income: "+totalIncome+"\nExpenses:\n");

        for (Expense expense : expenses) {
            System.out.println("Expense: "+expense.toString());
            totalExpenditure = totalExpenditure + expense.getAmount();
        }
        discretionaryIncome = totalIncome - totalExpenditure;
        System.out.println("** Total Expenditure: "+totalExpenditure+"\n\nDiscretionary Income: "+discretionaryIncome);

    }

    /*Testing example:
    * Expenses: new shoes clothing 80 2025-02-10
     * Income: consulting 300 2025-02-10
     * */


}
