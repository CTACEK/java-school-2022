package ru.croc.task5.figures;

public class Circle extends Figure {
    private int x0;
    private int y0;
    private int r;

    public Circle(String label, int x0, int y0, int r) {
        super(label);
        this.x0 = x0;
        this.y0 = y0;
        this.r = r;
    }

    @Override
    public String toString() {
        return "C " +
                "(" + x0 + ", " +
                y0 + ") " + r + ": " +
                label + "\n";
    }
}
