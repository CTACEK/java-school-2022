package ru.croc.task17and18.databases.dao;

import ru.croc.task17and18.DatabaseWorker;
import ru.croc.task17and18.databases.pojomodel.Item;
import ru.croc.task17and18.exceptions.ItemAlreadyExist;

import java.sql.*;

public class ItemDAO extends AbstractDAO <Integer, Item> {

    private static final String SQL_ADD_ITEM = "INSERT INTO ITEMS(CODE,NAME,PRICE) VALUES (?,?,?)";
    private static final String SQL_UPDATE_ITEM = "UPDATE ITEMS SET NAME=?, PRICE = ? WHERE CODE=?";
    private static final String SQL_FIND_ITEM = "SELECT * FROM ITEMS WHERE CODE = ?";
    private static final String SQL_DELETE_ITEM_CODE = "DELETE FROM ITEMS WHERE CODE = ?";



    public Item find(String code) {
        Item item = null;
        try (Connection connection = DatabaseWorker.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_FIND_ITEM)) {
            statement.setString(1, code);
            ResultSet resultSet = statement.executeQuery();

            if (resultSet.next()) {
                String name = resultSet.getString(3);
                Integer price = resultSet.getInt(4);
                item = new Item(name, code, price);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return item;
    }


    public boolean delete(String productCode) {
        try (Connection connection = DatabaseWorker.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_DELETE_ITEM_CODE)) {
            statement.setString(1, productCode);
            statement.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public void deleteProduct(String productCode){
        /*
        Удаление товара и всех упоминаний о нем в заказах.
        Вас смущает необходимость изменения уже выданных заказов,
        но заказчик настаивает.
         */
        try (Connection connection = DatabaseWorker.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_DELETE_ITEM_CODE)) {
            statement.setString(1, productCode);
            statement.execute();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Item find(Integer id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean delete(Integer id) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean delete(Item entity) {
        throw new UnsupportedOperationException();
    }

    @Override
    public boolean create(Item entity) {
        try (Connection connection = DatabaseWorker.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_ADD_ITEM)) {
            statement.setString(1, entity.getItemNumber());
            statement.setString(2, entity.getName());
            statement.setInt(3, entity.getPrice());
            statement.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
            return false;
        }
        return true;
    }

    public Item createProduct(Item entity) throws ItemAlreadyExist {
        Item item = find(entity.getItemNumber());
        if (item != null) throw new ItemAlreadyExist(item);

        try (Connection connection = DatabaseWorker.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_ADD_ITEM)) {
            statement.setString(1, entity.getItemNumber());
            statement.setString(2, entity.getName());
            statement.setInt(3, entity.getPrice());
            statement.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return entity;
    }

    @Override
    public Item update(Item entity) {
        try (Connection connection = DatabaseWorker.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_ITEM)) {
            statement.setString(1, entity.getItemNumber());
            statement.setString(2, entity.getName());
            statement.setInt(3, entity.getPrice());
            statement.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return entity;
    }

    public Item updateProduct(Item product) {
        try (Connection connection = DatabaseWorker.getConnection();
             PreparedStatement statement = connection.prepareStatement(SQL_UPDATE_ITEM)) {
            statement.setString(1, product.getName());
            statement.setInt(2, product.getPrice());
            statement.setString(3, product.getItemNumber());
            statement.execute();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return product;
    }
}
