package ru.croc.task17and18.databases.table;

import java.sql.SQLException;

public class Customers extends BaseTable implements TableOperations{

    public Customers() throws SQLException {
        super("customers");
    }


    @Override
    void executeSqlStatement(String sql) throws SQLException {
        super.executeSqlStatement(sql);
    }

    @Override
    public void createTable() throws SQLException {
        super.executeSqlStatement("CREATE TABLE IF NOT EXISTS customers(" +
                "id BIGINT AUTO_INCREMENT PRIMARY KEY," +
                "name VARCHAR(255) NOT NULL)");
    }

    @Override
    public void createForeignKeys() throws SQLException {

    }
}
