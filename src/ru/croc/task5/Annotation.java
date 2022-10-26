package ru.croc.task5;

import ru.croc.task5.figures.Figure;

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
}
