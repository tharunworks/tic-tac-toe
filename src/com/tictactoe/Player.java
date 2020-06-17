package com.tictactoe;


import java.util.UUID;

public class Player {

    private String id;

    private String name;

    public Player(String name) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
