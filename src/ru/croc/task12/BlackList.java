package ru.croc.task12;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.nio.file.Path;
import java.util.*;

public class BlackList {
    /**
     * Return black list from path of file.
     *
     * @param path path on database in txt with "bad" words.
     */
    public static Set<String> createBlackList(Path path){
        Set<String> blacklist = new HashSet<>();

        try (Scanner scanner = new Scanner(new FileReader(path.toFile()))) {
            while (scanner.hasNextLine()) {
                String s = scanner.nextLine().toLowerCase(Locale.ROOT);
                if (!s.isEmpty()) blacklist.addAll(List.of(s.split("\s+")));
            }
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
        return blacklist;
    }
}
