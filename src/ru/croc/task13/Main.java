package ru.croc.task13;

import ru.croc.task13.exceptions.UserNotFoundException;

import java.nio.file.Path;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws UserNotFoundException {
        Path path_db_films = Path.of("/Users/ctacek/IdeaProjects/java-school-2022/src/ru/croc/task13/databases/db_films.txt");
        Path path_db_history = Path.of("/Users/ctacek/IdeaProjects/java-school-2022/src/ru/croc/task13/databases/db_history_of_wathcing.txt");

//        System.out.println(Parser.pasreDbFilms(path_db_films));
//        System.out.println(Parser.pasreDbHistory(path_db_history));

        OnlineStreaming netflix = new OnlineStreaming(path_db_films, path_db_history);

        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();


        int id = netflix.addUserInHistory(line);
        System.out.println(netflix.getRecommendation(id));

    }
}
