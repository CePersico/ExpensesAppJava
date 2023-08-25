package comExpense.interfaces;

import comExpense.clases.Expense;

import java.util.List;

// no es una interface funcional ya que osee dos metodos
public interface ExpenseCalculator {
    double calculateExpense(Expense expense);

    double calculateTotalExpense(List<Expense> expenses);
    // Se le consulta al usuario la cantidad de gastos a ingreasr, por lo que se usa una lista en lugar de un Array
}
