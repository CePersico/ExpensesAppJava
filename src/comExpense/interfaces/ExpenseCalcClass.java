package comExpense.interfaces;

import comExpense.clases.Expense;

public class ExpenseCalcClass implements ExpenseCalc{
        @Override
        public double sumExpense(Expense expense) {
            return expense.getQuantity();
        }

        @Override
        public double sumTotalExpense(Expense[] expenses) {
            double totalExpense = 0;
            for (Expense expense : expenses) {
                totalExpense += expense.getQuantity();
            }
            return totalExpense;
        }
}

