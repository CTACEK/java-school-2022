package ru.croc.task12;

import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        MyBlackListFilter myBlackListFilter = new MyBlackListFilter();

        Set<String> blackList = BlackList.createBlackList(Path.of("/Users/ctacek/IdeaProjects/java-school-2022/src/ru/croc/task12/db_blacklist.txt"));

        List<String> comments = new ArrayList<>();

        comments.add("Арбуз конечно не супер, надо было купить другой!!!");
        comments.add("Симпл-димпл лучше попыта!");
        comments.add("Фотка супер ставлю \"Класс\"");
        comments.add("JavaScript тоже самое, что и Java");

        myBlackListFilter.filterComments(comments, blackList);

        System.out.println(comments);
    }
}
