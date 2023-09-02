package com.Expense.clases;

public class User {
    private String firstName;
    private String lastName;
    private String Email;
    private String Password;
    private String Document;
    private int idExpense;

    public User() {}

    public User(String firstName, String lastName, String email, String password, String document) {
        this.firstName = firstName;
        this.lastName = lastName;
        Email = email;
        Password = password;
        Document = document;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getDocument() {
        return Document;
    }

    public void setDocument(String document) {
        Document = document;
    }

    public int getIdExpense() {
        return idExpense;
    }

    public void setIdExpense(int idExpense) {
        this.idExpense = idExpense;
    }

    @Override
    public String toString() {
        return "User{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", Email='" + Email + '\'' +
                ", Password='" + Password + '\'' +
                ", Document='" + Document + '\'' +
                ", idExpense=" + idExpense +
                '}';
    }
}
