package ru.croc.task3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[] array;

        array = enterArray();

        swap(findMin(array), 0, array);
        swap(findMax(array), array.length - 1, array);

        printArray(array);

    }
    static void swap(Integer i, Integer j, int[] array){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    static int findMax(int[] array){
        int max_i = 0;
        int max = array[0];

        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
                max_i = i;
            }
        }
        return max_i;
    }

    static int findMin(int[] array){
        int min_i = 0;
        int min = array[0];

        for (int i = 0; i < array.length; i++) {
            if (array[i] < min) {
                min = array[i];
                min_i = i;
            }
        }
        return min_i;
    }

    static void printArray(int[] array){
        for (int number : array) {
            System.out.print(number + " ");
        }
        System.out.print('\n');
    }

    static int[] enterArray(){
        String[] arrayOfStrigs;
        int[] arrayOfIntegers;

        Scanner scanner = new Scanner(System.in);
        arrayOfStrigs = scanner.nextLine().split(" ");
        scanner.close();

        arrayOfIntegers = new int[arrayOfStrigs.length];

        for (int i = 0; i < arrayOfIntegers.length; i++) {
            try {
                arrayOfIntegers[i] = Integer.parseInt(arrayOfStrigs[i]);
            }
            catch (NumberFormatException nfe){
                System.out.println("NumberFormatException: " + nfe.getMessage());
                System.out.print("Enter another data");
                System.exit(1);
            }
        }
        return arrayOfIntegers;
    }
}
