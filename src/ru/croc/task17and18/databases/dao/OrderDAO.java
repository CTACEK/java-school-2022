package ru.croc.task17and18.databases.dao;

import ru.croc.task17and18.DatabaseWorker;
import ru.croc.task17and18.databases.pojomodel.Customer;
import ru.croc.task17and18.databases.pojomodel.CustomerOrder;
import ru.croc.task17and18.databases.pojomodel.Item;
import ru.croc.task17and18.databases.pojomodel.Order;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class OrderDAO extends AbstractDAO<Integer, Order> {
    private static final String SQL_ADD_ORDER = "INSERT INTO ORDERS(IDORDER, CODEITEM) VALUES (?,?)";
    private static final String SQL_MAX_ORDER_ID = "SELECT MAX(IDORDER) FROM ORDERS";

    @Override
    public Order find(Integer id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean delete(Integer id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean delete(Order entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean create(Order entity) {
        try (Connection connection = DatabaseWorker.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_ADD_ORDER)) {
            statement.setInt(1, entity.getIdOrder());
            statement.setString(2, entity.getCodeItem());
            statement.execute();
        } catch (SQLException e) {
            System.out.println(entity);
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    private Integer getMaxOrderID() {
        Integer max = null;
        try (Connection connection = DatabaseWorker.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_MAX_ORDER_ID)) {
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                max = resultSet.getInt(1);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return max;
    }

    public Order createOrder(String userLogin, List<Item> products) {

        int newIdOrder = getMaxOrderID() + 1;

        Order order = null;

        for (Item product : products) {
            ItemDAO itemDAO = new ItemDAO();
            if (itemDAO.find(product.getItemNumber()) == null) itemDAO.create(product);

            CustomerDAO customerDAO = new CustomerDAO();
            if (customerDAO.find(userLogin) == null) customerDAO.create(new Customer(userLogin));

            CustomerOrderDAO customerOrderDAO = new CustomerOrderDAO();
            if (customerOrderDAO.find(newIdOrder) == null)
                customerOrderDAO.create(new CustomerOrder(customerDAO.find(userLogin).getId(), newIdOrder));

            order = new Order(product.getItemNumber(), newIdOrder);
            OrderDAO orderDAO = new OrderDAO();
            orderDAO.create(order);
        }

        return order;
    }

    @Override
    public Order update(Order entity) {
        throw new UnsupportedOperationException();
    }
}
