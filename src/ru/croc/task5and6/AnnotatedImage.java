package ru.croc.task5and6;

import ru.croc.task5and6.figures.Circle;

class AnnotatedImage {

    private final String imagePath;

    private final Annotation[] annotations;

    public AnnotatedImage(String imagePath, Annotation... annotations) {
        this.imagePath = imagePath;
        this.annotations = annotations;
    }

    public String getImagePath() {
        return this.imagePath;
    }

    public Annotation[] getAnnotations() {
        return this.annotations;
    }

    public Annotation findByPoint(int x, int y){
        for (Annotation annotation: annotations) {
            if (annotation.getFigure().inFigure(x,y)) return annotation;
        }
        return new Annotation(new Circle(-1,-1, 0),"None");
    }

    public Annotation findByLabel(String label){
        for (Annotation annotation: annotations) {
            if (annotation.containsStr(label)) return annotation;
        }
        return new Annotation(new Circle(-1,-1, 0),"None");
    }
}

