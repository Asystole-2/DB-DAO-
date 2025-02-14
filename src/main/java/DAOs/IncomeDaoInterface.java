package DAOs;

import DTOs.Income;
import Exceptions.DaoException;

import java.util.List;

public interface IncomeDaoInterface {

    public List<Income> findAllIncomes() throws DaoException;

    public List<Income> findIncomeByMonth(String subString) throws DaoException;

    public void addAnIncome(String title, double amount, String dateEarned) throws DaoException;

    public void deleteAnIncome(int income_id) throws DaoException;
}
