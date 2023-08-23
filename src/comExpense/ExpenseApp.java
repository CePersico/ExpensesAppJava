package comExpense;

import comExpense.clases.Category;
import comExpense.clases.Expense;
import comExpense.exceptions.InvalidExpenseException;
import comExpense.interfaces.ExpenseCalc;
import comExpense.interfaces.ExpenseCalcClass;
import comExpense.interfaces.ExpenseQuantityValidator;
import comExpense.interfaces.ExpenseQuantityValidatorClass;

import java.util.Scanner;

public class ExpenseApp {

        public static void main(String[] args) {

            // Declaramos las interfaces a utilizar
            ExpenseCalc expenseCalculator = new ExpenseCalcClass();
            ExpenseQuantityValidator expenseAmountValidator = new ExpenseQuantityValidatorClass();
            // Declaramos e instanciamos un array donde guardaremos los gastos ingresados
            Expense[] expenseArray = new Expense[2];
            int index = 0;
            int quantity = 0;

            // Creamos un objeto scanner para pedir al usuario que ingrese los valores por consola
            Scanner scanner = new Scanner(System.in);

            do {
                //AGREGAMOS UN GASTO
                // Instanciamos un gasto, una categoria
                Expense expense = new Expense();
                Category category = new Category();
                // Try/catch para manipular excepción
                try {
                    // Solicitamos al usuario que ingrese los valores
                    System.out.print("Ingrese el monto del gasto: ");
                    quantity = scanner.nextInt();

                    // Validación con condicional if/else | Obtención de valor por getter
                    if (!expenseAmountValidator.validateQuantity(quantity)) {
                        System.out.println("El monto es válido.");
                    }
                    scanner.nextLine();

                } catch (InvalidExpenseException exception) {
                    System.out.println("Error" + exception);
                }

                System.out.print("Ingrese la categoría del gasto: ");
                String name = scanner.nextLine();
                category.setName(name);

                System.out.println("Ingrese la fecha del gasto: (dd/MM/yyyy)");
                String date = scanner.nextLine();

                // Seteamos los valores ingresados en el objeto gasto
                expense.setQuantity(quantity);
                expense.setCategory(category);
                expense.setDate(date);
                System.out.println("Detalle del gasto ingresado: " + expense);
                System.out.println("Cálculo del monto del gasto ingresado: " + expenseCalculator.sumExpense(expense));

                expenseArray[index] = expense;
                index++;

            } while (index < expenseArray.length); // Validamos la condicion de que el bulce itere según el tamaño definido para el array
            System.out.println("Total del monto del gasto ingresado: " + expenseCalculator.sumTotalExpense(expenseArray));

            System.out.println("DETALLE DE GASTOS INGRESADOS");
            for (int i = 0; i < expenseArray.length; i++) {
                System.out.println(expenseArray[i]);
            }
        }

}
