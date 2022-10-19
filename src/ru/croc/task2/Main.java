package ru.croc.task2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        printBytes(scanner.nextLong());
        scanner.close();
    }

    public static void printBytes(double digit) {
        if (digit < 0) return;

        int i = -1;
        String[] measures = {"KB", "MB", "GB", "TB"};

        while (digit >= 1024 & i < measures.length - 1){
            digit /= 1024;
            i++;
        }

        System.out.printf("%.1f %s\n", digit, measures[i]);
    }

}
