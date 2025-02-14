package DAOs;

import DTOs.Income;
import Exceptions.DaoException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class IncomeDAO extends MySqlDao implements IncomeDaoInterface {
    @Override
    public List<Income> findAllIncomes() throws DaoException {

        Connection myConnection = null;
        PreparedStatement myPreparedStatement = null;
        ResultSet myResultSet = null;
        List<Income> IncomeList = new ArrayList<>();

        try{
            myConnection = getConnection();
            String sql = "select * from incomes";
            myPreparedStatement = myConnection.prepareStatement(sql);
            myResultSet = myPreparedStatement.executeQuery();

            while(myResultSet.next())
            {
                int income_id = myResultSet.getInt("INCOME_ID");
                String title = myResultSet.getString("TITLE");
                double amount = myResultSet.getDouble("AMOUNT");
                String dateEarned = myResultSet.getString("DATE_EARNED");

                Income newIncome = new Income(income_id, title, amount, dateEarned);
                IncomeList.add(newIncome);
            }
        }
        catch (SQLException e)
        {
            throw new DaoException("findAllIncomes() " + e.getMessage());
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
                throw new DaoException("findAllIncomes() " + e.getMessage());
            }
        }
        return IncomeList;
    }

    @Override
    public List<Income> findIncomeByMonth(String subString) throws DaoException {

        Connection myConnection = null;
        PreparedStatement myPreparedStatement = null;
        ResultSet myResultSet = null;
        List<Income> IncomeList = new ArrayList<>();

        try {
            myConnection = this.getConnection();
            String sql = "select * from incomes where dateEarned = ?";
            myPreparedStatement = myConnection.prepareStatement(sql);
            myPreparedStatement.setString(1, subString);
            myResultSet = myPreparedStatement.executeQuery();

            while (myResultSet.next()) {
                int income_id = myResultSet.getInt("INCOME_ID");
                String title = myResultSet.getString("TITLE");
                double amount = myResultSet.getDouble("AMOUNT");
                String dateEarned = myResultSet.getString("DATE_EARNED");

                Income newIncome = new Income(income_id, title, amount, dateEarned);
                IncomeList.add(newIncome);
            }
        } catch (SQLException e) {
            throw new DaoException("findIncomeByMonth() " + e.getMessage());
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
                throw new DaoException("findIncomeByMonth() " + e.getMessage());
            }
        }
        return IncomeList;
    }

    @Override
    public void addAnIncome(String title, double amount, String dateEarned) throws DaoException {

        Connection myConnection = null;
        PreparedStatement myPreparedStatement = null;
        ResultSet myResultSet = null;

        try {
            myConnection = this.getConnection();
            String sql = "INSERT INTO incomes (title, amount, dateEarned) VALUES (?, ?, ?)";
            myPreparedStatement = myConnection.prepareStatement(sql);
            myPreparedStatement.setString(1, title);
            myPreparedStatement.setDouble(2, amount);
            myPreparedStatement.setString(3, dateEarned);
            myPreparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new DaoException("addAnIncome() " + e.getMessage());
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
                throw new DaoException("addAnIncome() " + e.getMessage());
            }
        }
    }

    @Override
    public void deleteAnIncome(int income_id) throws DaoException {

        Connection myConnection = null;
        PreparedStatement myPreparedStatement = null;
        ResultSet myResultSet = null;

        try {
            myConnection = this.getConnection();
            String sql = "DELETE FROM incomes WHERE income_id = ?";
            myPreparedStatement = myConnection.prepareStatement(sql);
            myPreparedStatement.setInt(1, income_id);
            myPreparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new DaoException("deleteAnIncome() " + e.getMessage());
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
                throw new DaoException("deleteAnIncome() " + e.getMessage());
            }
        }
    }


}
