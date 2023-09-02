package com.Expense.dao.interf;

import com.Expense.dao.dto.ExpenseDto;
import com.Expense.exceptions.ExceptionDao;

import java.util.List;

public interface ExpenseDao {
    ExpenseDto getById(int id) throws ExceptionDao;
    List<ExpenseDto> getAll() throws ExceptionDao;
    void insert(ExpenseDto expenseDto) throws ExceptionDao;
    void update(ExpenseDto expense) throws ExceptionDao;
    void delete(int id) throws ExceptionDao;

}
