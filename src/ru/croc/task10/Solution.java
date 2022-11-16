package ru.croc.task10;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class Solution {

    public static String calculatePassword(int threadsNumber , String hashPass)  throws ExecutionException, InterruptedException{
        String result = "";

        ExecutorService service = Executors.newFixedThreadPool(threadsNumber);

        List<Future<String>> tasks = new ArrayList<>();

        for (int i = 0; i < threadsNumber; i++) {
            tasks.add(service.submit(new BruteForse(hashPass, i, threadsNumber)));
        }


        for (Future<String> task : tasks) {
            if (task.get() != null) {
                result = task.get();
                break;
            }
        }
        service.shutdownNow();

        return result;
    }
}