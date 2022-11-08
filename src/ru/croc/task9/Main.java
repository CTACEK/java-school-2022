package ru.croc.task9;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String enteredStr = scanner.nextLine();
        scanner.close();

        String[] splitStr = enteredStr.split("/");

        for(int i = 0; i < splitStr.length ; i++){
            if (splitStr[i] != null && splitStr[i].equals(".")) {
                splitStr[i] = null;
            }

            if (splitStr[i] != null && splitStr[i].equals("..")) {
                for (int j = i - 1; j >= 0; j--) {
                    if (splitStr[j] != null && !splitStr[j].equals("..") && !splitStr[j].equals(".")) {
                        splitStr[j] = null;
                        splitStr[i] = null;
                        break;
                    }
                }
            }
        }

        LinkedList<String> list = new LinkedList<>();

        for (String s : splitStr) {
            if (s != null) list.add(s);
        }

        System.out.println(String.join("/", list));
    }
}