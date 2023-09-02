package com.Expense.implem;

import com.Expense.exceptions.InvalidExpenseException;
import com.Expense.interfaces.ExpenseAmountValidator;

public class ExpenseAmountValidatorImplementation
        implements ExpenseAmountValidator/*, IsNumberValidator*/ {
    @Override
    public boolean validateAmount(double quantity) throws InvalidExpenseException {
        if (quantity < 0) {
            throw new InvalidExpenseException("El monto debe ser igual o mayor a cero.");
        }
        return true;
    }


    public boolean isNumberDouble(String enter) {
        try {
            Double.parseDouble(enter);

            return true;

        } catch (NumberFormatException nfe) {

            return false;
        }
    }
}
