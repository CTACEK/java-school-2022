package ru.croc.task5and6;

import ru.croc.task5and6.figures.Figure;

public class Annotation {
    private Figure figure;
    private String label;

    public Annotation(Figure figure, String label) {
        this.figure = figure;
        this.label = label;
    }

    @Override
    public String toString() {
        return figure + ": " + label;
    }

    public Figure getFigure() {
        return figure;
    }

    public boolean containsStr(String enteredStr){
        return label.contains(enteredStr);
    }
}
