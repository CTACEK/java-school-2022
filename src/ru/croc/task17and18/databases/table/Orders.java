package ru.croc.task17and18.databases.table;

import java.sql.SQLException;

public class Orders extends BaseTable implements TableOperations{

    public Orders() throws SQLException {
        super("orders");
    }
    @Override
    public void createTable() throws SQLException {
        super.executeSqlStatement("CREATE TABLE IF NOT EXISTS orders(" +
                "id BIGINT AUTO_INCREMENT PRIMARY KEY," +
                "idorder INTEGER NOT NULL," +
                "codeitem VARCHAR(255) NOT NULL)");
    }

    @Override
    public void createForeignKeys() throws SQLException {
        super.executeSqlStatement("ALTER TABLE orders ADD FOREIGN KEY (idorder) REFERENCES customerorder(idorder) ON DELETE CASCADE");
        super.executeSqlStatement("ALTER TABLE orders ADD FOREIGN KEY (codeitem) REFERENCES items(code) ON DELETE CASCADE");
    }

}
