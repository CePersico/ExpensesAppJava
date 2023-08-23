package comExpense.interfaces;


import comExpense.clases.Expense;

public interface ExpenseCalc {
    double sumExpense(Expense expense);
    double sumTotalExpense(Expense[] expenses);
}
