package comExpense.implem;

import comExpense.exceptions.InvalidExpenseException;
import comExpense.interfaces.ExpenseAmountValidator;
import comExpense.interfaces.IsNumberValidator;

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
