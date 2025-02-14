package DAOs;

import DTOs.Expense;
import Exceptions.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExpenseDAO  extends MySqlDao implements ExpenseDaoInterface {
    @Override
    public List<Expense> findAllExpenses() throws DaoException {

        Connection myConnection = null;
        PreparedStatement myPreparedStatement = null;
        ResultSet myResultSet = null;
        List<Expense> ExpenseList = new ArrayList<>();

        try{
            myConnection = getConnection();
            String sql = "select * from expenses";
            myPreparedStatement = myConnection.prepareStatement(sql);
            myResultSet = myPreparedStatement.executeQuery();

            while(myResultSet.next())
            {
                int expenseId = myResultSet.getInt("EXPENSE_ID");
                String title = myResultSet.getString("TITLE");
                String category = myResultSet.getString("CATEGORY");
                double amount = myResultSet.getDouble("AMOUNT");
                String dateIncurred = myResultSet.getString("DATE_INCURRED");

                Expense newExpense = new Expense(expenseId, title,category, amount, dateIncurred);
                ExpenseList.add(newExpense);
            }
        }
        catch (SQLException e)
        {
            throw new DaoException("findAllExpenses() " + e.getMessage());
        }
        finally
        {
            try
            {
                if(myResultSet != null)
                {
                    myResultSet.close();
                }

                if(myPreparedStatement != null)
                {
                    myPreparedStatement.close();
                }

                if(myConnection != null)
                {
                    freeConnection(myConnection);
                }
            } catch (SQLException e) {
                throw new DaoException("findAllExpenses() " + e.getMessage());
            }
        }
        return ExpenseList;
    }

    @Override
    public List<Expense> findExpensesByMonth(String subString) throws DaoException {

        Connection myConnection = null;
        PreparedStatement myPreparedStatement = null;
        ResultSet myResultSet = null;
        List<Expense> ExpenseList = new ArrayList<>();

        try {
            myConnection = this.getConnection();
            String sql = "select * from expenses where dateIncurred = ?";
            myPreparedStatement = myConnection.prepareStatement(sql);
            myPreparedStatement.setString(1, subString);
            myResultSet = myPreparedStatement.executeQuery();

            while (myResultSet.next()) {
                int expense_id = myResultSet.getInt("EXPENSE_ID");
                String title = myResultSet.getString("TITLE");
                String category = myResultSet.getString("CATEGORY");
                double amount = myResultSet.getDouble("AMOUNT");
                String dateIncurred = myResultSet.getString("DATE_INCURRED");

                Expense newExpense = new Expense(expense_id, title,category, amount, dateIncurred);
                ExpenseList.add(newExpense);
            }
        } catch (SQLException e) {
            throw new DaoException("findExpensesByMonth() " + e.getMessage());
        } finally {
            try {
                if (myResultSet != null) {
                    myResultSet.close();
                }

                if (myPreparedStatement != null) {
                    myPreparedStatement.close();
                }

                if (myConnection != null) {
                    freeConnection(myConnection);
                }
            } catch (SQLException e) {
                throw new DaoException("findExpensesByMonth() " + e.getMessage());
            }
        }
        return ExpenseList;
    }

    @Override
    public void addAnExpense(String title,String category, double amount, String dateIncurred ) throws DaoException {

        Connection myConnection = null;
        PreparedStatement myPreparedStatement = null;
        ResultSet myResultSet = null;

        try {
            myConnection = this.getConnection();
            String sql = "INSERT INTO expenses (title,category, amount, dateIncurred) VALUES (?, ?, ?, ?)";
            myPreparedStatement = myConnection.prepareStatement(sql);
            myPreparedStatement.setString(1, title);
            myPreparedStatement.setString(2, category);
            myPreparedStatement.setDouble(3, amount);
            myPreparedStatement.setString(4, dateIncurred);
            myPreparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new DaoException("addAnExpense() " + e.getMessage());
        } finally {
            try {
                if (myResultSet != null) {
                    myResultSet.close();
                }

                if (myPreparedStatement != null) {
                    myPreparedStatement.close();
                }

                if (myConnection != null) {
                    freeConnection(myConnection);
                }
            } catch (SQLException e) {
                throw new DaoException("addAnExpense() " + e.getMessage());
            }
        }
    }

    @Override
    public void deleteAnExpense(int expense_id) throws DaoException {

        Connection myConnection = null;
        PreparedStatement myPreparedStatement = null;
        ResultSet myResultSet = null;

        try {
            myConnection = this.getConnection();
            String sql = "DELETE FROM expenses WHERE expense_id = ?";
            myPreparedStatement = myConnection.prepareStatement(sql);
            myPreparedStatement.setInt(1, expense_id);
            myPreparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new DaoException("deleteAnExpense() " + e.getMessage());
        } finally {
            try {
                if (myResultSet != null) {
                    myResultSet.close();
                }

                if (myPreparedStatement != null) {
                    myPreparedStatement.close();
                }

                if (myConnection != null) {
                    freeConnection(myConnection);
                }
            } catch (SQLException e) {
                throw new DaoException("deleteAnExpense() " + e.getMessage());
            }
        }
    }
}
