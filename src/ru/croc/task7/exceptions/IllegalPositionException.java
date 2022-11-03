package ru.croc.task7.exceptions;

public class IllegalPositionException extends Exception{

    final private int x;
    final private int y;

    public IllegalPositionException(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String getMessage() {
        return "Illegal position " + Character.toString(x + 'a') + y + " in game! You can do step on board 8X8.";
    }
}
