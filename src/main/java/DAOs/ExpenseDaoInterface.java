package DAOs;

import DTOs.Expense;
import Exceptions.DaoException;

import java.util.List;

public interface ExpenseDaoInterface {

    public List<Expense> findAllExpenses() throws DaoException;

    public List<Expense> findExpensesByMonth(String subString) throws DaoException;

    public void addAnExpense(String title,String category, double amount, String dateIncurred )throws DaoException;

    public void deleteAnExpense(int expense_id) throws DaoException;
}



