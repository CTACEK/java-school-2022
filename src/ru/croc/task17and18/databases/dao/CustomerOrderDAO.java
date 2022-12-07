package ru.croc.task17and18.databases.dao;

import ru.croc.task17and18.DatabaseWorker;
import ru.croc.task17and18.databases.pojomodel.CustomerOrder;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerOrderDAO extends AbstractDAO <Integer, CustomerOrder> {

    private static final String SQL_ADD_CUSTOMERORDER = "INSERT INTO CUSTOMERORDER(IDCUSTOMER, IDORDER) VALUES (?,?)";
    private static final String SQL_FIND_ITEM = "SELECT * FROM CUSTOMERORDER WHERE IDORDER = ?";

    @Override
    public CustomerOrder find(Integer idorder) {
        CustomerOrder customerOrder = null;
        try (Connection connection = DatabaseWorker.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_FIND_ITEM)) {
            statement.setInt(1, idorder);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                int idcustomer = resultSet.getInt(2);
                customerOrder = new CustomerOrder(idcustomer, idorder);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());

        }
        return customerOrder;
    }

    @Override
    public boolean delete(Integer id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean delete(CustomerOrder entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean create(CustomerOrder entity) {
        try (Connection connection = DatabaseWorker.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_ADD_CUSTOMERORDER)) {
            statement.setInt(1, entity.getIdUser());
            statement.setInt(2, entity.getIdOrder());
            statement.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public CustomerOrder update(CustomerOrder entity) {
        throw new UnsupportedOperationException();
    }
}
