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

        int i = 0;
        String measure;

        while (digit >= 1024){
            digit /= 1024;
            i++;
        }

        if (i == 1) measure = "KB";
        else if (i == 2) measure = "MB";
        else if (i == 3) measure = "GB";
        else if (i == 4) measure = "TB";
        else measure = "B";

        System.out.printf("%.1f %s\n", digit, measure);
    }

}
