package ru.croc.task12;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class MyBlackListFilter implements BlackListFilter {
    @Override
    public void filterComments(List<String> comments, Set<String> blackList) {
        Iterator<String> stringIterator = comments.iterator();
        while (stringIterator.hasNext()) {
            String[] words0fComment = stringIterator.next().split("[{.,!?\\s]+");
            if (wordsContainsInBlackList(words0fComment, blackList)) stringIterator.remove();
        }
    }
    public boolean wordsContainsInBlackList(String[] words, Set<String> blackList) {
        for (String word : words) {
            if (blackList.contains(word.toLowerCase())) return true;
        }
        return false;
    }
}
