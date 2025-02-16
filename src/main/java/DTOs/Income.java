package DTOs;

public class Income {

    private int income_id;
    private String title;
    private double amount;
    private String dateEarned;

    public Income(int incomeId, String title, double amount, String dateEarned) {
        this.income_id = incomeId;
        this.title = title;
        this.amount = amount;
        this.dateEarned = dateEarned;
    }

    public Income(String title, double amount, String dateEarned) {
        this.income_id = 0;
        this.title = title;
        this.amount = amount;
        this.dateEarned = dateEarned;
    }

    public Income() {
    }

    public int getIncome_id() {
        return income_id;
    }

    public void setIncome_id(int income_id) {
        this.income_id = income_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDateEarned() {
        return dateEarned;
    }

    public void setDateEarned(String dateEarned) {
        this.dateEarned = dateEarned;
    }

    @Override
    public String toString() {
        return "{" +
                "income_id=" + income_id +
                ", title='" + title + '\'' +
                ", amount=" + amount +
                ", dateEarned='" + dateEarned + '\'' +
                '}';
    }
}
