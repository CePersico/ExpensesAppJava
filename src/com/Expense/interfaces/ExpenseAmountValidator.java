package com.Expense.interfaces;

import com.Expense.exceptions.InvalidExpenseException;

@FunctionalInterface// donde se define un unico metodo
public interface ExpenseAmountValidator {
    boolean validateAmount(double quantity) throws InvalidExpenseException;
}
