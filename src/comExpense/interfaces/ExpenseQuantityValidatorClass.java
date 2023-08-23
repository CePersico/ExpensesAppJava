package comExpense.interfaces;

import comExpense.exceptions.InvalidExpenseException;

public class ExpenseQuantityValidatorClass implements ExpenseQuantityValidator{
        @Override
        public boolean validateQuantity(double amount) throws InvalidExpenseException { // Propagamos la excepción
            if (amount < 0) {
                // Throw de excepción customizada
                throw new InvalidExpenseException("El monto debe ser igual o mayor a cero.");
            }
            return true;
        }
}

