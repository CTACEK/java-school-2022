package ru.croc.task17and18.databases.table;

import java.sql.SQLException;

public class Items extends BaseTable implements TableOperations{

    public Items() throws SQLException {
        super("items");
    }


    @Override
    public void createTable() throws SQLException {
        super.executeSqlStatement("CREATE TABLE IF NOT EXISTS items(" +
                "id BIGINT AUTO_INCREMENT PRIMARY KEY," +
                "code VARCHAR(255) UNIQUE,"+
                "name VARCHAR(255) NOT NULL,"+
                "price INTEGER NOT NULL)");
    }

    @Override
    public void createForeignKeys() throws SQLException {

    }
}
