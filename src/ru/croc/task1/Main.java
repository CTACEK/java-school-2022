package ru.croc.task1;

import java.util.Scanner;

public class Main {

    static class Point{
        double x;
        double y;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Point[] points = new Point[3];

        for (int i = 0; i < 3; i++) {
            points[i] = new Point();

            System.out.print("Введите координату х вершины №" + (i + 1) + ": ");
            points[i].x = scanner.nextDouble();

            System.out.print("Введите координату y вершины №" + (i + 1) + ": ");
            points[i].y = scanner.nextDouble();
        }
        scanner.close();

        System.out.println("Площадь треугольника: " + squareTriangle(points));

    }
    public static double squareTriangle(Point[] points){
        return (0.5 * Math.abs(
                (points[0].x - points[1].x) * (points[0].y + points[1].y) +
                (points[1].x - points[2].x) * (points[1].y + points[2].y) +
                (points[2].x - points[0].x) * (points[2].y + points[0].y))
        );
    }
}

