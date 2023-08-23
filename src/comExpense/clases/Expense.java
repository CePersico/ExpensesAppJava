package comExpense.clases;

public class Expense {
    private double quantity;
    private Category category;
    private String date;
    private int id;

    public Expense() {}

    public Expense(double quantity, Category category, String date, int id) {
        this.quantity = quantity;
        this.category = category;
        this.date = date;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "quantity=" + quantity +
                ", category=" + category +
                ", date='" + date + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
