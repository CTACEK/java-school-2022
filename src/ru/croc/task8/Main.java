package ru.croc.task8;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class Main {
    /*
    * В текстовом файле слова могут быть разделены одним или несколькими пробелами или символами перевода строки.
    * Необходимо реализовать программу, считающую количество слов в файле и выводящую результат на экран.
    * Путь к файлу задается первым аргументом командной строки (args[0]).
    * */

    public static void main(String[] args) {

        int n = 0;

        try (Scanner scanner = new Scanner(new FileReader(args[0]))) {
            while (scanner.hasNextLine()) {
                String s = scanner.nextLine();
                if (!s.isEmpty()) n += s.split("\s+").length;
            }
            System.out.println(n);
        }
        catch(FileNotFoundException e){
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }
}
