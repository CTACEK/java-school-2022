package ru.croc.task7;


import ru.croc.task7.exceptions.IllegalMoveException;
import ru.croc.task7.exceptions.IllegalPositionException;

public class Main {
    public static void main(String[] args) throws IllegalPositionException, IllegalMoveException {


//        String[] test1 = {"g8", "e7", "c8"};
        String[] test2 = {"g8", "e7", "e6"};


//        ChessPosition.checkSequenceOfMoves(test1);
        ChessPosition.checkSequenceOfMoves(test2);

//        ChessPosition chessPosition = ChessPosition.parse("a1");
//        System.out.println(chessPosition);

    }
}
