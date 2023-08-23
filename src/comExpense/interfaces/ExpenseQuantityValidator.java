package comExpense.interfaces;

import comExpense.exceptions.InvalidExpenseException;

public interface ExpenseQuantityValidator {
    boolean validateQuantity(double amount) throws InvalidExpenseException;
}
