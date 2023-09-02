package com.Expense.interfaces;

import com.Expense.clases.Expense;
import com.Expense.dao.dto.ExpenseDto;

import java.util.List;

// no es una interface funcional ya que osee dos metodos
public interface ExpenseCalculator {
    double calculateExpense(Expense expense);

    double calculateTotalExpense(List<ExpenseDto> expenses); // Refactorizamos el tipo del parámetros para recibir una lista, ya no un array
}
