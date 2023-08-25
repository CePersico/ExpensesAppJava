package comExpense.implem;

import comExpense.clases.Expense;
import comExpense.interfaces.ExpenseCalculator;

import java.util.List;

public class ExpenseCalculatorImplementation implements ExpenseCalculator {
        @Override// metodo que devuelve el valor del gasto
    public double calculateExpense(Expense expense) {
            return expense.getQuantity();
    }



    @Override
    public double calculateTotalExpense(List<Expense> expenses) {
            double totalExpense = 0;
        for (Expense expense : expenses) {
                totalExpense += expense.getQuantity();
        }
        return totalExpense;
    }
}
