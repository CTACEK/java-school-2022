package ru.croc.task17and18.databases.table;

import ru.croc.task17and18.DatabaseWorker;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

// Сервисный родительский класс, куда вынесена реализация общих действий для всех таблиц
public class BaseTable {
    String tableName;       // Имя таблицы

    BaseTable(String tableName) throws SQLException { // Для реальной таблицы передадим в конструктор её имя
        this.tableName = tableName;
    }

    void executeSqlStatement(String sql) throws SQLException {
        try (Connection connection = DatabaseWorker.getConnection();
        Statement statement = connection.createStatement()) {
             statement.execute(sql);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
