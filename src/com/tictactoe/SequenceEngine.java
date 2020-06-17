package com.tictactoe;

public class SequenceEngine implements Engine {

    @Override
    public Move makeNextMove(Game game) throws Exception {
        Board board = game.getBoard();
        for (int i = 0; i < board.getLayoutSize(); i++) {
            for (int j = 0; j < board.getLayoutSize(); j++) {
                if (Symbol.EMPTY.equals(game.getBoard().getLayout()[i][j] )) {
                    return new Move(i, j);
                }
            }
        }
        throw new Exception("No valid move");
    }
}
