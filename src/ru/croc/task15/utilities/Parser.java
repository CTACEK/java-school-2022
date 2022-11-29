package ru.croc.task15.utilities;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Path;
import java.util.*;

public class Parser {

    final static private String regex = ",";

    static public List<String[]> pasreConfig(Path path){

        List<String[]> config = new ArrayList<>();

        try (Scanner scanner = new Scanner(new FileReader(path.toFile()))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] words = line.split(regex);
                config.add(words);
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
        return config;
    }
}
