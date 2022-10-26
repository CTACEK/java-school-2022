package ru.croc.task5.figures;

public class Rectangle extends Figure {
    private int x0;
    private int y0;
    private int x1;
    private int y1;

    public Rectangle(int x0, int y0, int x1, int y1) {
        this.x0 = x0;
        this.y0 = y0;
        this.x1 = x1;
        this.y1 = y1;
    }

    @Override
    public String toString() {
        return "R " +
                "(" + x0 + ", "
                + y0 + ")"+
                " (" + x1 + ", "
                + y1 + ")";
    }
}
