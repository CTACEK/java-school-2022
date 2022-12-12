package ru.croc.task13.utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Path;
import java.util.*;

public class Parser {

    final static private String regex = ",";

    static public List<Integer> pasreEnteredHistory(String history){
        List<Integer> integerList = new ArrayList<>();
        String[] strings = history.split(regex);
        for (String string : strings) {
            integerList.add(Integer.parseInt(string));
        }
        return integerList;
    }
    static public Map<Integer, String> pasreDbFilms(Path path){
        Map<Integer, String> films = new HashMap<>();

        try (Scanner scanner = new Scanner(new FileReader(path.toFile()))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] indexFilm = line.split(regex);
                if (indexFilm.length == 2) films.put(Integer.valueOf(indexFilm[0]), indexFilm[1]);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException();
        }
        return films;
    }

    static public Map<Integer, List<Integer>> pasreDbHistory(Path path) throws NumberFormatException{
        Map<Integer, List<Integer>> history = new HashMap<>();
        int id_person = 100;

        try (Scanner scanner = new Scanner(new FileReader(path.toFile()))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] films = line.split(regex);

                ArrayList<Integer> temp = new ArrayList<>();
                for (String film : films) {
                    temp.add(Integer.parseInt(film));
                }

                if (films.length != 0) history.put(id_person++, temp);
            }
        } catch (FileNotFoundException | NumberFormatException e) {
            System.out.println(e.getMessage());
            throw new RuntimeException();
        }
        return history;
    }
}
