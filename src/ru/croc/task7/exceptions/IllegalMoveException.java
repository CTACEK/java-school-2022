package ru.croc.task7.exceptions;

import ru.croc.task7.ChessPosition;


public class IllegalMoveException extends Exception{
    final private ChessPosition from;
    final private ChessPosition to;

    public IllegalMoveException(ChessPosition from, ChessPosition to) {
        this.from = from;
        this.to = to;
    }

    @Override
    public String getMessage() {
        return "Knight can't do this move " + from + " -> " + to;
    }
}
