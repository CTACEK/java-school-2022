package ru.croc.task5and6.figures;

public class Rectangle extends Figure{
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

    public int getX1() {
        return x1;
    }

    public void setX1(int x1) {
        this.x1 = x1;
    }

    public int getY1() {
        return y1;
    }

    public void setY1(int y1) {
        this.y1 = y1;
    }

    @Override
    public boolean inFigure(int x, int y) {
        return (x >= x0 && x <= x1) && (y >= y0 && y <= y1);
    }

    @Override
    public void move(int dx, int dy) {
        this.x0 += dx;
        this.x1 += dx;

        this.y0 += dy;
        this.y1 += dy;
    }
}
