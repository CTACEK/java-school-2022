package ru.croc.task14;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

public class Main {
    public static void main(String[] args) {
        BlackListFilter blackListFilter = new BlackListFilter() {
            @Override
            public <T> List<T> filterComments(Collection<T> comments, Predicate<T> blackListPredicat) {
                return BlackListFilter.super.filterComments(comments, blackListPredicat);
            }
        };

        List<String> comments = new ArrayList<>();

        comments.add("Арбуз конечно не супер, надо было купить другой!!!");
        comments.add("Симпл-димпл лучше попыта!");
        comments.add("Фотка супер ставлю \"Класс\"");
        comments.add("JavaScript тоже самое, что и Java");

        Predicate<String> containsWatermelon = t -> t.toLowerCase().contains("арбуз");
        Predicate<String> containsSimplDimpl = t -> t.toLowerCase().contains("симпл-димпл");
        Predicate<String> containJavaScript = t -> t.toLowerCase().contains("javascript");


        System.out.println(blackListFilter.filterComments(comments, containsWatermelon.or(containsSimplDimpl).or(containJavaScript)));

    }
}
