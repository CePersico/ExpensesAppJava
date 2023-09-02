CREATE TABLE GESTION.Expense (
    id INT PRIMARY KEY AUTO_INCREMENT,
    quantity DOUBLE NOT NULL,
    id_category INT,
    date VARCHAR(10),
    FOREIGN KEY (id_category) REFERENCES Category(id)
);