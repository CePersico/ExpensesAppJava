package com.Expense.clases;

public class Expense {
    private double quantity;
    private int idCategory;
    private String date;
    private int id;

    public Expense() {}

    public Expense(double quantity, int idCategory, String date, int id) {
        this.quantity = quantity;
        this.idCategory = idCategory;
        this.date = date;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public int getIdCategory() {
        return idCategory;
    }

    public void setIdCategory(int idCategory) {
        this.idCategory = idCategory;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "quantity=" + quantity +
                ", idCategory=" + idCategory +
                ", date='" + date + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}