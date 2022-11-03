package ru.croc.task7;

import ru.croc.task7.exceptions.IllegalMoveException;
import ru.croc.task7.exceptions.IllegalPositionException;

public class ChessPosition {

    private int x;
    private int y;

    public ChessPosition(int x, int y) throws IllegalPositionException{
        if (x < 0 || x > 7 || y < 0 || y > 7) throw new IllegalPositionException(x,y);
        this.x = x;
        this.y = y;
    }

    public static ChessPosition parse(String position) throws IllegalPositionException {
        int x = position.charAt(0) - 'a';
        int y = Integer.parseInt(String.valueOf(position.charAt(1))) - 1;
        if (x < 0 || x > 7 || y < 0 || y > 7) throw new IllegalPositionException(x,y);
        return new ChessPosition(x, y);
    }

    public static boolean isValidMove(ChessPosition from, ChessPosition to) throws IllegalMoveException {
        if ((Math.abs(from.getX() - to.getX()) == 1 && Math.abs(from.getY() - to.getY()) == 2) ||
                (Math.abs(from.getX() - to.getX()) == 2 && Math.abs(from.getY() - to.getY()) == 1)) return true;
        else throw new IllegalMoveException(from, to);
    }

    public static void checkSequenceOfMoves(String... positions) throws IllegalPositionException {
    try{
        for (int i = 0; i < positions.length - 1; i++) {
            ChessPosition from = ChessPosition.parse(positions[i]);
            ChessPosition to = ChessPosition.parse(positions[i + 1]);
                if (isValidMove(from, to)) continue;
                else break;
            }
    } catch (IllegalMoveException e) {
        System.out.println(e.getMessage());
        return;
    }
        System.out.println("OK");
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }


    @Override
    public String toString() {
        return Character.toString(x + 'a') + (y + 1);
    }
}
