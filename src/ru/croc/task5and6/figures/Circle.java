package ru.croc.task5and6.figures;

public class Circle extends Figure implements Movable{
    private int x0;
    private int y0;
    private int r;

    public Circle(int x0, int y0, int r) {
        this.x0 = x0;
        this.y0 = y0;
        this.r = r;
    }

    @Override
    public String toString() {
        return "C " +
                "(" + x0 + ", " +
                y0 + "), " + r;
    }

    public int getX0() {
        return x0;
    }

    public void setX0(int x0) {
        this.x0 = x0;
    }

    public int getY0() {
        return y0;
    }

    public void setY0(int y0) {
        this.y0 = y0;
    }

    public int getR() {
        return r;
    }

    public void setR(int r) {
        this.r = r;
    }


    @Override
    public boolean inFigure(int x, int y) {
        return ((x - x0) * (x - x0) + (y - y0) * (y - y0)) <= r * r;
    }

    @Override
    public void move(int dx, int dy) {
        this.x0 += dx;
        this.y0 += dy;
    }
}
