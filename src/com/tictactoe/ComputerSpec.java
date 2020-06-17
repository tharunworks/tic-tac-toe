package com.tictactoe;

public class ComputerSpec extends PlayerSpec {
    public ComputerSpec(Player player, Symbol assignedSymbol) {
        super(player, assignedSymbol);
    }

    @Override
    Move getRequestMove(Game game) throws Exception {
        Computer computer = (Computer) this.getPlayer();
        return computer.getEngine().makeNextMove(game);
    }
}
