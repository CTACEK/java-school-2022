package ru.croc.task17and18;

import ru.croc.task17and18.databases.dao.CustomerDAO;
import ru.croc.task17and18.databases.dao.CustomerOrderDAO;
import ru.croc.task17and18.databases.dao.ItemDAO;
import ru.croc.task17and18.databases.dao.OrderDAO;
import ru.croc.task17and18.databases.pojomodel.Customer;
import ru.croc.task17and18.databases.pojomodel.CustomerOrder;
import ru.croc.task17and18.databases.pojomodel.Item;
import ru.croc.task17and18.databases.pojomodel.Order;
import ru.croc.task17and18.databases.table.CustomerOrders;
import ru.croc.task17and18.databases.table.Customers;
import ru.croc.task17and18.databases.table.Items;
import ru.croc.task17and18.databases.table.Orders;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Path;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class DatabaseWorker {
    private static final String dataBaseDriver = "org.h2.Driver";
    private static final String connectionUrl = "jdbc:h2:tcp://localhost/~/test";
    private static final String user = "sa";
    private static final String password = "";
    public static final String regex = ",";

    private final Items items;
    private final Orders orders;
    private final CustomerOrders ordersCustomers;
    private final Customers customers;


    public DatabaseWorker() throws SQLException, ClassNotFoundException {
        Class.forName(dataBaseDriver);
        // Создание базы данных заказов
        orders = new Orders();
        // Создание базы данных покупателей
        customers = new Customers();
        // Создание базы данных товаров
        items = new Items();
        // Создание базы данных соответствия заказов и покупателей
        ordersCustomers = new CustomerOrders();
    }


    public void createTablesAndForeignKeys() throws SQLException {
        try {
            items.createTable();
            customers.createTable();
            orders.createTable();
            ordersCustomers.createTable();

            ordersCustomers.createForeignKeys();
            orders.createForeignKeys();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(connectionUrl, user, password);
    }


    public void uploadDatabasesFromCsv(Path pathDb) throws SQLException {

        try (Scanner scanner = new Scanner(new FileReader(pathDb.toFile()))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] partsOfOrders = line.split(regex);

                ItemDAO itemDAO = new ItemDAO();
                if (itemDAO.find(partsOfOrders[2]) == null)
                    itemDAO.create(new Item(partsOfOrders[3], partsOfOrders[2], Integer.parseInt(partsOfOrders[4])));

                CustomerDAO customerDAO = new CustomerDAO();
                if (customerDAO.find(partsOfOrders[1]) == null) customerDAO.create(new Customer(partsOfOrders[1]));

                CustomerOrderDAO customerOrderDAO = new CustomerOrderDAO();
                if (customerOrderDAO.find(Integer.parseInt(partsOfOrders[0])) == null) customerOrderDAO.create(
                        new CustomerOrder(customerDAO.find(partsOfOrders[1]).getId(), Integer.parseInt(partsOfOrders[0])));

                OrderDAO orderDAO = new OrderDAO();
                orderDAO.create(new Order(partsOfOrders[2], Integer.parseInt(partsOfOrders[0])));

            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException();
        }

    }


}
