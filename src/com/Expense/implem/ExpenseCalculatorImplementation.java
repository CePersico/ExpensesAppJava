package com.Expense.implem;

import com.Expense.clases.Expense;
import com.Expense.dao.dto.ExpenseDto;
import com.Expense.interfaces.ExpenseCalculator;

import java.util.List;

public class ExpenseCalculatorImplementation implements ExpenseCalculator {
        @Override// metodo que devuelve el valor del gasto
    public double calculateExpense(Expense expense) {
            return expense.getQuantity();
    }

    @Override
    public double calculateTotalExpense(List<ExpenseDto> expenses) {
        double totalExpense = 0;
        for (ExpenseDto expense : expenses) {
            totalExpense += expense.getQuantity();
        }
        return totalExpense;
    }



}
