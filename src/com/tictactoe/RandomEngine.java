package com.tictactoe;

import java.util.HashSet;
import java.util.Set;

public class RandomEngine implements Engine {

    @Override
    public Move makeNextMove(Game game) throws Exception {
        Set<Move> possibleMoves = new HashSet<>();
        for (int i = 0; i < game.getBoard().getLayoutSize(); i++) {
            for (int j = 0; j < game.getBoard().getLayoutSize(); j++) {
                if (Symbol.EMPTY.equals(game.getBoard().getLayout()[i][j])) {
                    possibleMoves.add(new Move(i, j));
                }
            }
        }
        if (!possibleMoves.isEmpty()) {
            return possibleMoves.iterator().next();
        }
        throw new Exception("No valid move");
    }
}
