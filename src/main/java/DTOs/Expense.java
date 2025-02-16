package DTOs;

public class Expense {
    private int expenseId;
    private String title;
    private String category;
    private Double amount;
    private String dateIncurred;

    public Expense(int expenseId, String title, String category, double amount, String dateIncurred) {
        this.expenseId = expenseId;
        this.title = title;
        this.category = category;
        this.amount = amount;
        this.dateIncurred = dateIncurred;
    }

    public Expense(String title, String category, double amount, String dateIncurred) {
        this.expenseId = 0;
        this.title = title;
        this.category = category;
        this.amount = amount;
        this.dateIncurred = dateIncurred;
    }

    public Expense() {
    }

    public int getId() {
        return expenseId;
    }

    public void setId(int expenseId) {
        this.expenseId = expenseId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Double getAmount() {

        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public String getDateIncurred() {
        return dateIncurred;

    }

    public void setDateIncurred(String dateIncurred) {
        this.dateIncurred = dateIncurred;
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "{" +
                "expenseId=" + expenseId +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", amount=" + amount +
                ", dateIncurred='" + dateIncurred + '\'' +
                '}';
    }
}

