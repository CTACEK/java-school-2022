package ru.croc.task12;

import java.util.List;
import java.util.Set;

public class MyBlackListFilter implements BlackListFilter {
    @Override
    public void filterComments(List<String> comments, Set<String> blackList) {
        List<String> oldComments = List.copyOf(comments);
        comments.clear();

        for (String oldComment : oldComments) {
            String[] wordsOfOldComment = oldComment.split("[{.,!?\\s]+");
            if (!wordsContainsInBlackList(wordsOfOldComment, blackList)) comments.add(oldComment);
        }
    }

    public boolean wordsContainsInBlackList(String[] words, Set<String> blackList){
        for (String word : words) {
            if (blackList.contains(word.toLowerCase())) return true;
        }
        return false;
    }
}
