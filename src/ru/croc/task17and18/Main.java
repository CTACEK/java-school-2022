package ru.croc.task17and18;

import ru.croc.task17and18.databases.dao.ItemDAO;
import ru.croc.task17and18.databases.dao.OrderDAO;
import ru.croc.task17and18.databases.pojomodel.Item;
import ru.croc.task17and18.exceptions.ItemAlreadyExist;

import java.nio.file.Path;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {

        Scanner scanner = new Scanner(System.in);
//        String s = "/Users/ctacek/IdeaProjects/java-school-2022/src/ru/croc/task17and18/test_db.csv";


        Path path = Path.of(scanner.nextLine());
        DatabaseWorker shopDbWorker = new DatabaseWorker();

        scanner.close();

        shopDbWorker.createTablesAndForeignKeys();
        shopDbWorker.uploadDatabasesFromCsv(path);

        System.out.println("################ 18 #################");

        ItemDAO itemDAO = new ItemDAO();
        System.out.println(itemDAO.find("Т1"));

        try {
            itemDAO.createProduct(new Item("Amogus", "Т1", 120));
        } catch (ItemAlreadyExist e) {
            System.out.println(e.getMessage());
        }

        itemDAO.updateProduct(new Item("Monitor", "Т1", 499));
        System.out.println(itemDAO.find("Т1"));

        itemDAO.deleteProduct("Т1");
        System.out.println("T1: " + itemDAO.find("Т1"));

        List<Item> ikea = new ArrayList<>();
        ikea.add(new Item("Акула БЛОХЭЙ", "Т11", 1499));
        ikea.add(new Item("Собака хаски", "Т12", 1439));
        ikea.add(new Item("ДЬЮНГЕЛЬСКОГ Орангутанг", "Т13", 1439));

        OrderDAO orderDAO = new OrderDAO();
        orderDAO.createOrder("ctacek", ikea);

    }
}
