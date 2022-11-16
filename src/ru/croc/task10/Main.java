package ru.croc.task10;

import ru.croc.task10.tests.PasswordHashTest;

import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        String str = PasswordHashTest.hashPassword("baaaaaa");

        System.out.println(Solution.calculatePassword(5, str));
    }
}
