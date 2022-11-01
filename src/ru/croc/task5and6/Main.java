package ru.croc.task5and6;

import ru.croc.task5and6.figures.Circle;
import ru.croc.task5and6.figures.Rectangle;

public class Main {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(1,0,2,0);
//        System.out.println(rectangle);

        Circle circle = new Circle(1,0,2);
//        System.out.println(circle);

        Annotation annotation1 = new Annotation(rectangle, "Biba");
        Annotation annotation2 = new Annotation(circle, "Boba");

        System.out.println(annotation1);
        System.out.println(annotation2);
    }
}
