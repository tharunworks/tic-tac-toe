package com.tictactoe;

public abstract class PlayerSpec {

    private Player player;

    private Symbol assignedSymbol;

    public PlayerSpec(Player player, Symbol assignedSymbol) {
        this.player = player;
        this.assignedSymbol = assignedSymbol;
    }

    public Symbol getAssignedSymbol() {
        return assignedSymbol;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    abstract Move getRequestMove(Game game) throws Exception;
}
