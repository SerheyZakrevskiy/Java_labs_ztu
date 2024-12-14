
package com.education.ztu;

import java.sql.*;
import java.util.ResourceBundle;

public class Main {
    private static final String PROPERTIES_FILE = "db";

    public static void main(String[] args) {
        System.out.println("Лабораторна робота №11: Робота з базою даних у Java");

        ResourceBundle resource = ResourceBundle.getBundle(PROPERTIES_FILE);
        String url = resource.getString("db.url");
        String user = resource.getString("db.user");
        String password = resource.getString("db.password");

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            System.out.println("З'єднання з базою даних встановлено успішно.");


            try (Statement statement = connection.createStatement()) {

                String createTableSQL = "CREATE TABLE IF NOT EXISTS products ("
                        + "id SERIAL PRIMARY KEY, "
                        + "name VARCHAR(100), "
                        + "brand VARCHAR(50), "
                        + "category VARCHAR(50), "
                        + "price DECIMAL(10, 2));";
                statement.executeUpdate(createTableSQL);

                connection.setAutoCommit(false);
                statement.addBatch("INSERT INTO products (name, brand, category, price) VALUES ('Product1', 'BrandA', 'CategoryX', 100.50);");
                statement.addBatch("INSERT INTO products (name, brand, category, price) VALUES ('Product2', 'BrandA', 'CategoryY', 200.00);");
                statement.addBatch("INSERT INTO products (name, brand, category, price) VALUES ('Product3', 'BrandB', 'CategoryX', 150.75);");
                statement.addBatch("INSERT INTO products (name, brand, category, price) VALUES ('Product4', 'BrandC', 'CategoryZ', 99.99);");
                statement.addBatch("INSERT INTO products (name, brand, category, price) VALUES ('Product5', 'BrandD', 'CategoryX', 300.00);");
                statement.addBatch("INSERT INTO products (name, brand, category, price) VALUES ('Product6', 'BrandA', 'CategoryY', 120.00);");
                statement.addBatch("INSERT INTO products (name, brand, category, price) VALUES ('Product7', 'BrandE', 'CategoryZ', 250.50);");
                statement.addBatch("INSERT INTO products (name, brand, category, price) VALUES ('Product8', 'BrandB', 'CategoryY', 180.20);");
                statement.addBatch("INSERT INTO products (name, brand, category, price) VALUES ('Product9', 'BrandF', 'CategoryX', 75.99);");
                statement.addBatch("INSERT INTO products (name, brand, category, price) VALUES ('Product10', 'BrandG', 'CategoryZ', 50.00);");
                statement.executeBatch();
                connection.commit();
                System.out.println("Таблиця заповнена даними.");


                ResultSet resultSet = statement.executeQuery("SELECT * FROM products;");
                while (resultSet.next()) {
                    System.out.printf("ID: %d, Name: %s, Brand: %s, Category: %s, Price: %.2f%n",
                            resultSet.getInt("id"),
                            resultSet.getString("name"),
                            resultSet.getString("brand"),
                            resultSet.getString("category"),
                            resultSet.getDouble("price"));
                }
            }


            try (PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO products (name, brand, category, price) VALUES (?, ?, ?, ?);")) {
                preparedStatement.setString(1, "Product11");
                preparedStatement.setString(2, "BrandH");
                preparedStatement.setString(3, "CategoryY");
                preparedStatement.setDouble(4, 99.99);
                preparedStatement.executeUpdate();

                preparedStatement.setString(1, "Product12");
                preparedStatement.setString(2, "BrandI");
                preparedStatement.setString(3, "CategoryZ");
                preparedStatement.setDouble(4, 49.99);
                preparedStatement.executeUpdate();

                System.out.println("Додано ще два товари.");


                try (PreparedStatement selectStatement = connection.prepareStatement(
                        "SELECT * FROM products WHERE category = ?;")) {
                    selectStatement.setString(1, "CategoryY");
                    ResultSet resultSet = selectStatement.executeQuery();
                    System.out.println("Товари з категорії 'CategoryY':");
                    while (resultSet.next()) {
                        System.out.printf("ID: %d, Name: %s, Brand: %s, Price: %.2f%n",
                                resultSet.getInt("id"),
                                resultSet.getString("name"),
                                resultSet.getString("brand"),
                                resultSet.getDouble("price"));
                    }
                }

                try (PreparedStatement deleteStatement = connection.prepareStatement("DELETE FROM products;")) {
                    deleteStatement.executeUpdate();
                    System.out.println("Всі записи видалено.");
                }
            }

            try {
                connection.setAutoCommit(false);
                Savepoint savepoint = connection.setSavepoint("BeforeInsert");

                try (PreparedStatement ps = connection.prepareStatement(
                        "INSERT INTO products (name, brand, category, price) VALUES (?, ?, ?, ?);")) {
                    ps.setString(1, "Product13");
                    ps.setString(2, "BrandJ");
                    ps.setString(3, "CategoryX");
                    ps.setDouble(4, 199.99);
                    ps.executeUpdate();


                    ps.setString(1, "Product14");
                    ps.setString(2, "BrandK");
                    ps.setString(3, "CategoryX");
                    ps.setDouble(4, 0);
                    ps.executeUpdate();
                } catch (SQLException e) {
                    System.out.println("Помилка при виконанні транзакції: " + e.getMessage());
                    connection.rollback(savepoint);
                }

                connection.commit();
            } catch (SQLException e) {
                System.out.println("Помилка при роботі з транзакціями: " + e.getMessage());
            }
        } catch (SQLException e) {
            System.out.println("Помилка підключення до бази даних: " + e.getMessage());
        }
    }
}
