package ru.croc.task10;

import java.util.concurrent.ExecutionException;

public class Main {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
//        String str = PasswordHashTest.hashPassword("baaaaaa");

        System.out.println(Solution.calculatePassword(5, "40682260CC011947FC2D0B1A927138C5"));
    }
}
