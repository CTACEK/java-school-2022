package ru.croc.task17and18.databases.dao;

import ru.croc.task17and18.DatabaseWorker;
import ru.croc.task17and18.databases.pojomodel.Customer;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class CustomerDAO extends AbstractDAO<Integer, Customer> {

    private static final String SQL_ADD_USER = "INSERT INTO CUSTOMERS(NAME) VALUES (?)";
    private static final String SQL_FIND_USER = "SELECT * FROM CUSTOMERS WHERE NAME = ?";


    @Override
    public Customer find(Integer id) {
        throw new UnsupportedOperationException();
    }

    public Customer find(String name) {
        Customer customer = null;
        try (Connection connection = DatabaseWorker.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_FIND_USER)) {
            statement.setString(1, name);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                Integer id = resultSet.getInt(1);
                customer = new Customer(id, name);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return customer;
    }

    @Override
    public boolean delete(Integer id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean delete(Customer entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean create(Customer entity) {

        try (Connection connection = DatabaseWorker.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_ADD_USER)) {
            statement.setString(1, entity.getName());
            statement.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    @Override
    public Customer update(Customer entity) {
        throw new UnsupportedOperationException();
    }
}
