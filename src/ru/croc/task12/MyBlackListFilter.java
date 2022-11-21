package ru.croc.task12;

import java.util.List;
import java.util.Set;

public class MyBlackListFilter implements BlackListFilter {
    @Override
    public void filterComments(List<String> comments, Set<String> blackList) {
        List<String> oldComments = List.copyOf(comments);
        comments.clear();

        boolean flag;

        for (String oldComment : oldComments) {
            flag = true;
            String[] wordsOfOldComment = oldComment.split("[{.,!?\\s]+");

            for (String word : wordsOfOldComment) {
                if (blackList.contains(word.toLowerCase())) {
                    flag = false;
                    break;
                }
            }
            if (flag) comments.add(oldComment);
        }
    }
}
