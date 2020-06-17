package com.tictactoe;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private Board board;

    private PlayerSpec firstPlayer;

    private PlayerSpec secondPlayer;

    private List<Move> moves = new ArrayList<>();

    private GameResult gameResult;

    private GameStatus gameStatus;

    private Player winner;

    private boolean isFirstPlayerMove = true;

    public Game(PlayerSpec firstPlayer, PlayerSpec secondPlayer) throws Exception {
        if(firstPlayer.getAssignedSymbol().equals(secondPlayer.getAssignedSymbol())){
            throw new Exception("Cannot start game - both players have same symbols assigned");
        }
        this.board = new Board();
        this.firstPlayer = firstPlayer;
        this.secondPlayer = secondPlayer;
        this.gameResult = GameResult.NOT_DECIDED;
        this.gameStatus = GameStatus.NOT_STARTED;
    }

    public Board getBoard() {
        return board;
    }

    public boolean isFirstPlayerMove() {
        return isFirstPlayerMove;
    }

    public void setFirstPlayerMove(boolean firstPlayerMove) {
        isFirstPlayerMove = firstPlayerMove;
    }

    public PlayerSpec getFirstPlayer() {
        return firstPlayer;
    }

    public PlayerSpec getSecondPlayer() {
        return secondPlayer;
    }

    public void setGameResult(GameResult gameResult) {
        this.gameResult = gameResult;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public List<Move> getMoves() {
        return moves;
    }

    public GameResult getGameResult() {
        return gameResult;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public Player getWinner() {
        return winner;
    }

    public void setWinner(Player winner) {
        this.winner = winner;
    }

    public void setMoves(List<Move> moves) {
        this.moves = moves;
    }
}
