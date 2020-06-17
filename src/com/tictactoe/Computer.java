package com.tictactoe;

public class Computer extends Player {

    private Engine engine;

    public Computer(String name) {
        super(name);
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public Engine getEngine() {
        return engine;
    }
}
