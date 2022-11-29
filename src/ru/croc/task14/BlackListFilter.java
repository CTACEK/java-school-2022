package ru.croc.task14;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.function.Predicate;

public interface BlackListFilter {
    /**
     * From the given list of comments keep only
     * which correct the predicate condition
     *
     * @param comments collection of comments
     * @param blackListPredicat the condition under which the element will be deleted
     */
    default <T> List<T> filterComments(Collection<T> comments, Predicate<T> blackListPredicat) {
        List<T> correctComments = new ArrayList<>(comments);
        correctComments.removeIf(blackListPredicat);
        return correctComments;
    }
}
