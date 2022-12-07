package ru.croc.task17and18.databases.table;

import java.sql.SQLException;

public class CustomerOrders extends BaseTable implements TableOperations{

    public CustomerOrders() throws SQLException {
        super("CustomerOrders");
    }

    @Override
    public void createTable() throws SQLException {
        super.executeSqlStatement("CREATE TABLE IF NOT EXISTS customerorder(" +
                "idcustomer INTEGER NOT NULL," +
                "idorder INTEGER NOT NULL PRIMARY KEY)");
    }

    @Override
    public void createForeignKeys() throws SQLException {
        super.executeSqlStatement("ALTER TABLE customerorder ADD FOREIGN KEY (idcustomer) REFERENCES customers(id) ON DELETE CASCADE");
    }
}
