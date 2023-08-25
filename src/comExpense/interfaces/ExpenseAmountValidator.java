package comExpense.interfaces;

import comExpense.exceptions.InvalidExpenseException;

@FunctionalInterface// donde se define un unico metodo
public interface ExpenseAmountValidator {
    boolean validateAmount(double quantity) throws InvalidExpenseException;
}
