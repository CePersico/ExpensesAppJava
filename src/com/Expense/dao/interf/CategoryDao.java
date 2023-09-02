package com.Expense.dao.interf;

import com.Expense.clases.Category;
import com.Expense.dao.dto.CategoryDto;
import com.Expense.exceptions.ExceptionDao;

public interface CategoryDao {
    void insert(CategoryDto category) throws ExceptionDao;
    Category getCategoryByName(String name) throws ExceptionDao;
}