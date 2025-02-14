package DAOs;

import DTOs.Expense;
import Exceptions.DaoException;
import java.util.List;

public interface ExpenseDaoInterface
{
    public List<Expense> findAllExpenses() throws DaoException;

    public Expense findExpenseByTitleCategory(String username, String password) throws DaoException;

    public List<Expense> findExpensesByMonth(String subString) throws DaoException;

}

