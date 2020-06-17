package com.tictactoe;

public class GameController {

    private Game game;

    private PlayerSpec currentPlayerSpec;

    private boolean isValidMove(Move move) {
        if (!(move.getxCoordinate() >= 0 && move.getxCoordinate() < this.game.getBoard().getLayoutSize()
                && move.getyCoordinate() >= 0 && move.getyCoordinate() < this.game.getBoard().getLayoutSize())) {
            return false;
        }
        int x = move.getxCoordinate(), y = move.getyCoordinate();
        if (!game.getBoard().getLayout()[x][y].equals(Symbol.EMPTY)) {
            return false;
        }
        return true;
    }

    private void setPlayerMove(Move move) throws Exception {
        game.getBoard().setPlayerMove(this.currentPlayerSpec.getAssignedSymbol(), move);
    }

    private boolean isWin(Move move) {
        int strikes = 0;
        boolean isWin = false;
        for (int i = 0; i < this.game.getBoard().getLayoutSize(); i++) {
            if (this.game.getBoard().getLayout()[i][move.getyCoordinate()].equals(this.currentPlayerSpec.getAssignedSymbol())) {
                strikes++;
            }
        }
        isWin = isWin || isStrike(strikes);

        strikes = 0;
        for (int j = 0; j < this.game.getBoard().getLayoutSize(); j++) {
            if (this.game.getBoard().getLayout()[move.getxCoordinate()][j].equals(this.currentPlayerSpec.getAssignedSymbol())) {
                strikes++;
            }
        }
        isWin = isWin || isStrike(strikes);

        strikes = 0;
        for (int i = 0, j = 0; i < this.game.getBoard().getLayoutSize(); i++, j++) {
            if (this.game.getBoard().getLayout()[i][j].equals(this.currentPlayerSpec.getAssignedSymbol())) {
                strikes++;
            }
        }
        isWin = isWin || isStrike(strikes);

        strikes = 0;
        for (int i = 0, j = this.game.getBoard().getLayoutSize() - 1; j >= 0; i++, j--) {
            if (this.game.getBoard().getLayout()[i][j].equals(this.currentPlayerSpec.getAssignedSymbol())) {
                strikes++;
            }
        }
        isWin = isWin || isStrike(strikes);
        return isWin;
    }

    private boolean isDraw() {
        for (int i = 0; i < this.game.getBoard().getLayoutSize(); i++) {
            for (int j = 0; j < this.game.getBoard().getLayoutSize(); j++) {
                if (this.game.getBoard().getLayout()[i][j].equals(Symbol.EMPTY)) {
                    return false;
                }
            }
        }
        return true;
    }

    private void getNextPlayer() {
        if (this.game.isFirstPlayerMove()) {
            this.game.setFirstPlayerMove(!this.game.isFirstPlayerMove());
            this.currentPlayerSpec = this.game.getFirstPlayer();
        } else {
            this.game.setFirstPlayerMove(!this.game.isFirstPlayerMove());
            this.currentPlayerSpec = this.game.getSecondPlayer();
        }
    }

    public void initiateGame() throws Exception {
        this.game.setGameStatus(GameStatus.IN_PROGRESS);
        this.game.getBoard().displayBoard();
        while (this.game.getGameStatus().equals(GameStatus.IN_PROGRESS)) {
            getNextPlayer();
            boolean isMoveUpdated = false;
            while(!isMoveUpdated){
                Move move = this.currentPlayerSpec.getRequestMove(this.game);
                if(isValidMove(move)) {
                    this.game.getMoves().add(move);
                    setPlayerMove(move);
                    if (isWin(move)) {
                        this.game.setGameStatus(GameStatus.COMPLETED);
                        this.game.setGameResult(GameResult.WIN_LOSE);
                        this.game.setWinner(this.currentPlayerSpec.getPlayer());
                    } else if (isDraw()) {
                        this.game.setGameStatus(GameStatus.COMPLETED);
                        this.game.setGameResult(GameResult.DRAW);
                    }
                    isMoveUpdated = true;
                }
            }
            this.game.getBoard().displayBoard();
        }
    }

    public void setGame(Game game) {
        this.game = game;
    }

    public Game getGame() {
        return game;
    }

    private boolean isStrike(int strikes){
        return strikes == this.game.getBoard().getLayoutSize();
    }
}
