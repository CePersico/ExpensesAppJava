package comExpense;


import comExpense.clases.Category;
import comExpense.clases.Expense;
import comExpense.exceptions.InvalidExpenseException;
import comExpense.interfaces.ExpenseAmountValidator;
import comExpense.implem.ExpenseAmountValidatorImplementation;
import comExpense.interfaces.ExpenseCalculator;
import comExpense.implem.ExpenseCalculatorImplementation;
import comExpense.utils.Utilities;

import javax.swing.JOptionPane;
import java.util.*;

public class ExpenseApp {

        public static void main(String[] args) {

                Scanner scanner = new Scanner(System.in);

                ExpenseCalculator expenseCalculator = new ExpenseCalculatorImplementation();
                ExpenseAmountValidator expenseAmountValidator = new ExpenseAmountValidatorImplementation();

                Map<String, Integer> countCategoryMap = new HashMap<>();

                List<Expense> expenses = new ArrayList<>();
                int index = 0;
                double quantity = 0;
                String name;
                String date;

                int numExpenses;


                System.out.print("Indique la cantidad de gastos a ingresar: ");
                //numExpenses = Integer.parseInt(JOptionPane.showInputDialog("Indique la cantidad de gastos a ingresar: " ));
                numExpenses = scanner.nextInt();
                do {
                        try {
                                Category category = new Category();
                                Expense expense = new Expense();

                                System.out.print("Ingrese el monto del gasto: ");
                                //quantity = Double.parseDouble(JOptionPane.showInputDialog( "Indique el monto del gasto: ") );
                                quantity = scanner.nextDouble();

                                if (!expenseAmountValidator.validateAmount(quantity)) {
                                        System.out.println("Monto valido");
                                }
                                scanner.nextLine();

                                System.out.print("Ingrese la categoría del gasto: ");
                              name = scanner.nextLine();
                              //name = JOptionPane.showInputDialog( "Indique la categoría del gasto ingresado: ");

                                System.out.println("Ingrese la fecha del gasto: (dd/MM/yyyy)");
                                date = scanner.nextLine();
                              //date = JOptionPane.showInputDialog("Indique la fecha del gasto: (dd/MM/yyyy)");


                                countCategoryMap.put(name, countCategoryMap.getOrDefault(name, 0) + 1);

                                expense.setQuantity(quantity);
                                category.setName(name);
                                expense.setCategory(category);
                                expense.setDate(date);
                            //System.out.println("Detalle del gasto ingresado: " + expense);
                               System.out.println("Suma gastos ingresados: " + expenseCalculator.calculateExpense(expense));
                              //JOptionPane.showMessageDialog(null,"Detalle del gasto ingresado: " + expense );
                              //JOptionPane.showMessageDialog(null,"Cálculo del monto del gasto ingresado: " + expenseCalculator.calculateExpense(expense));

                                expenses.add(expense);
                                index++;

                        } catch (InvalidExpenseException exception) {
                              System.out.println("Error" + exception);
                              //JOptionPane.showMessageDialog(null,"Error" + exception);
                        }
                } while (index < numExpenses);
              System.out.println("Total gastos ingresados: " + expenseCalculator.calculateTotalExpense(expenses));
              //JOptionPane.showMessageDialog(null,"Total del monto del gasto ingresado: " + expenseCalculator.calculateTotalExpense(expenses));

                System.out.println("DETALLE GASTOS");


                expenses.stream()
                        .limit(5)
                        .forEach(System.out::println);


                System.out.println("CONTADOR POR CATEGORÍA");

                countCategoryMap.forEach((category, count) -> System.out.println(category + ": " + count));

                System.out.println("----------------------------------------");
                System.out.println("IMPRESIÓN DE GASTOS USANDO UN MÉTODO GENËRICO");

                Utilities.imprimirElementos(expenses);
        }
}
