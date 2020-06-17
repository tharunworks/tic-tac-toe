package com.tictactoe;

public class Board {

    private int layoutSize = 3;

    private Symbol[][] layout;

    public Board() {
        this.layout = new Symbol[this.layoutSize][this.layoutSize];
        resetBoard();
    }

    void resetBoard() {
        for (int i = 0; i < this.layoutSize; i++) {
            for (int j = 0; j < this.layoutSize; j++) {
                this.layout[i][j] = Symbol.EMPTY;
            }
        }
    }

    public int getLayoutSize() {
        return layoutSize;
    }

    public Symbol[][] getLayout() {
        return layout;
    }

    public void setPlayerMove(Symbol symbol, Move move) {
        if (!(move.getxCoordinate() >= 0 && move.getxCoordinate() < getLayoutSize()
                && move.getyCoordinate() >= 0 && move.getyCoordinate() < getLayoutSize())) {
            return;
        }
        this.layout[move.getxCoordinate()][move.getyCoordinate()] = symbol;
    }

    public void displayBoard(){
        System.out.println("Current board state:");
        for (int i = 0; i < this.layoutSize; i++) {
            for (int j = 0; j < this.layoutSize; j++) {
                if(this.layout[i][j].equals(Symbol.EMPTY)) {
//                    System.out.print("(" + i + "," + j + ")" + "\t");
                    System.out.print("*\t");
                }else{
                    System.out.print(this.layout[i][j] + "\t");
                }
            }
            System.out.println("");
        }
    }
}
