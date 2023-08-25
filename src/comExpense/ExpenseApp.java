package comExpense;


import comExpense.clases.Category;
import comExpense.clases.Expense;
import comExpense.exceptions.InvalidExpenseException;
import comExpense.interfaces.ExpenseAmountValidator;
import comExpense.implem.ExpenseAmountValidatorImplementation;
import comExpense.interfaces.ExpenseCalculator;
import comExpense.implem.ExpenseCalculatorImplementation;
import comExpense.utils.Utilities;

import java.util.*;

public class ExpenseApp {

        public static void main(String[] args) {

                Scanner scanner = new Scanner(System.in);

                ExpenseCalculator expenseCalculator = new ExpenseCalculatorImplementation();
                ExpenseAmountValidator expenseAmountValidator = new ExpenseAmountValidatorImplementation();
                // Declaramos un map para contar la aparición de categorias
                Map<String, Integer> countCategoryMap = new HashMap<>();
                // Refactorizamos el array a una List<Expense>
                List<Expense> expenses = new ArrayList<>();
                int index = 0;
                int quantity = 0;
                String name;
                String date;
                // Definimos una variable que será definida por el usaurio para controlar
                // la cantidad de iteraciones que hará el bucle do/while
                int cantGastosACargar;

                // Se inicializa la variable de control del do/while con lo definido por el usuario
                System.out.print("¿Cuántos gastos desea cargar?: ");
                cantGastosACargar = scanner.nextInt();
                do {
                        try {
                                Expense expense = new Expense();
                                Category category = new Category();
                                System.out.print("Ingrese el monto del gasto: ");
                                quantity = scanner.nextInt();

                                if (!expenseAmountValidator.validateAmount(quantity)) {
                                        System.out.println("El monto es válido.");
                                }
                                scanner.nextLine();

                                System.out.print("Ingrese la categoría del gasto: ");
                                name = scanner.nextLine();

                                System.out.println("Ingrese la fecha del gasto: (dd/MM/yyyy)");
                                date = scanner.nextLine();

                                // Actuaizamos el map contador de categorias
                                countCategoryMap.put(name, countCategoryMap.getOrDefault(name, 0) + 1);

                                expense.setQuantity(quantity);
                                category.setName(name);
                                expense.setCategory(category);
                                expense.setDate(date);
                                System.out.println("Detalle del gasto ingresado: " + expense);
                                System.out.println("Cálculo del monto del gasto ingresado: " + expenseCalculator.calculateExpense(expense));

                                expenses.add(expense);
                                index++;

                        } catch (InvalidExpenseException exception) {
                                System.out.println("Error" + exception);
                        }
                } while (index < cantGastosACargar);
                System.out.println("Total del monto del gasto ingresado: " + expenseCalculator.calculateTotalExpense(expenses));

                System.out.println("DETALLE DE GASTOS INGRESADOS");
        /* Antes de usar una forma declarativa
        for (Expense expense : expenses) {
            System.out.println(expense);
        }*/
                // Implementamos programación funcional con Stream API para recorrer la lista de gastos y mostrar solo los primeros 5
                expenses.stream()
                        .limit(5)
                        .forEach(System.out::println);

                // Recorremos el map para mostrar por consola
                System.out.println("CONTADOR POR CATEGORÍA");
        /* Antes de usar una forma declarativa
        for (Map.Entry<String, Integer> entry : countCategoryMap.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }*/
                // Implementamos programación funcional con Stream API para recorrer el map contador de categorias
                countCategoryMap.forEach((category, count) -> System.out.println(category + ": " + count));

                System.out.println();
                System.out.println("IMPRESIÓN DE GASTOS USANDO UN MÉTODO GENËRICO");
                // Si tuviesemos una lista de categorías podríamos usar el mismo método
                Utilities.imprimirElementos(expenses);
        }
}
