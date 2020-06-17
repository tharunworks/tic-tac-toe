package com.tictactoe;

import java.util.Scanner;

public class HumanSpec extends PlayerSpec {
    public HumanSpec(Player player, Symbol assignedSymbol) {
        super(player, assignedSymbol);
    }

    public Move getRequestMove(Game game) {
        System.out.println("player " + this.getPlayer().getName() + " 's turn - Provide 2D coordinates (0 based)");
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        return new Move(x, y);
    }
}
