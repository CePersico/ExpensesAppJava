package com.Expense;


import com.Expense.clases.Category;
import com.Expense.config.JdbcConfiguration;
import com.Expense.dao.dto.CategoryDto;
import com.Expense.dao.dto.ExpenseDto;
import com.Expense.dao.implementations.CategoryDaoImpl;
import com.Expense.dao.implementations.ExpenseDaoImpl;
import com.Expense.dao.implementations.UserDaoImpl;
import com.Expense.dao.interf.CategoryDao;
import com.Expense.dao.interf.ExpenseDao;
import com.Expense.dao.interf.UserDao;
import com.Expense.exceptions.ExceptionDao;
import com.Expense.implem.ExpenseCalculatorImplementation;
import com.Expense.interfaces.ExpenseCalculator;
import com.Expense.exceptions.InvalidExpenseException;
import com.Expense.interfaces.ExpenseAmountValidator;
import com.Expense.implem.ExpenseAmountValidatorImplementation;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

public class ExpenseApp {

        public static void main(String[] args) {

            Scanner scanner = new Scanner(System.in);

            try (Connection connection = JdbcConfiguration.getConnection()) {
                ExpenseDao expenseDao = new ExpenseDaoImpl(connection);
                CategoryDao expenseCategoryDao = new CategoryDaoImpl(connection);
                UserDao expenseUserDao = new UserDaoImpl(connection);

                ExpenseCalculator expenseCalculator = new ExpenseCalculatorImplementation();
                ExpenseAmountValidator expenseAmountValidator = new ExpenseAmountValidatorImplementation();
                int quantity;
                String name;
                int cantGastosACargar;
                System.out.print("¿Cuántos gastos desea cargar?: ");
                cantGastosACargar = scanner.nextInt();

                for (int i = 0; i < cantGastosACargar; i++) {
                    try {
                        // Usamos el DTO para manipular en la lógica externa
                        ExpenseDto expenseDto = new ExpenseDto();
                        // Igualmente en esta instancia deberíamos usar el Dto de la categoría,
                        // ya que la categoría tambien tiene su entidad correlativa en una tabla de BD
                        CategoryDto expenseCategoryDto = new CategoryDto();

                        System.out.print("Ingrese el monto del gasto: ");
                        quantity = scanner.nextInt();

                        // Podríamos pensar esta validación de forma inversa, y en caso que el monto no sea válido,
                        // solicitar nuevamente al usuario que ingrese el monto hasta que ingrese un monto válido
                        if (!expenseAmountValidator.validateAmount(quantity)) {
                            System.out.println("El monto es válido.");
                        }
                        scanner.nextLine();

                        System.out.print("Ingrese la categoría del gasto: ");
                        name = scanner.nextLine();
                        expenseCategoryDto.setName(name);
                        // Insertamos la categoría en BD
                        expenseCategoryDao.insert(expenseCategoryDto);

                        //-----------------
                        System.out.println("Ingrese la fecha del gasto: (yyyy-MM-dd)");
                        String dateString = scanner.nextLine();

                        expenseDto.setQuantity(quantity);
                        // Para poder setear el id de la categoría en Expense, primero recuperamos la categoría por el nombre
                        // y luego obtenemos el id para setearlo en el gasto
                        Category expenseCategory = expenseCategoryDao.getCategoryByName(name);
                        expenseDto.setIdCategory(expenseCategory.getId());
                        expenseDto.setDate(dateString);

                        // Insertamos el gasto en la BD por medio del método crud
                        expenseDao.insert(expenseDto);

                        System.out.println("Detalle del gasto ingresado: " + expenseDto);

                        /*System.out.println("Ingrese la fecha del gasto: (yyyy-MM-dd)");
                        String dateString = scanner.nextLine();



                        expenseDto.setQuantity(quantity);
                        // Para poder setear el id de la categoría en Expense, primero recuperamos la categoría por el nombre
                        // y luego obtenemos el id para setearlo en el gasto
                        System.out.println("llegue aca");
                        Category expenseCategory = expenseCategoryDao.getCategoryByName(name);
                        //int idRecup = expenseCategory.getId() ;
                        expenseDto.getIdCategory();
                        expenseDto.setDate(dateString);

                        // Insertamos el gasto en la BD por medio del método crud
                        expenseDao.insert(expenseDto);

                        System.out.println("Detalle del gasto ingresado: " + expenseDto);*/
                    } catch (ExceptionDao exception) {
                        // Arojamos una excepción si hay un error al insertar el gasto
                        System.out.println("Error al insertar el gasto: " + exception.getMessage());
                    } catch (InvalidExpenseException e) {
                        throw new RuntimeException(e);
                    }
                }

                // Usamos el método getAll del CRUD para obtener los registros de BD

                List<ExpenseDto> expenses = expenseDao.getAll(); // .getAll();
                System.out.println("en el listado hay: " + expenses.size());
                System.out.println("DETALLE DE GASTOS INGRESADOS");
                for (ExpenseDto expense : expenses) {
                    System.out.println(expense);
                }

                System.out.println("Total del monto del gasto ingresado: "
                        + expenseCalculator.calculateTotalExpense(expenses));

                // Otras operaciones CRUD a realizar...

            } catch (SQLException | ExceptionDao e) {
                e.printStackTrace();
            }
        }
}