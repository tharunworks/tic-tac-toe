package com.tictactoe;

public class Client {

    void initialize() {
        usecase1();
//        usecase2();
//        usecase3();
    }

    private void playGame(Game game) {
        GameController gameController = new GameController();
        try {
            gameController.setGame(game);
            gameController.initiateGame();
            System.out.println("game result: " + game.getGameResult());
            if (game.getWinner() != null){
                System.out.println("game winner: " + game.getWinner().getName());
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void usecase1() {
        Human human1 = new Human("mike");
        Computer computer1 = new Computer("alphago");
        Engine sequenceEngine1 = new SequenceEngine();
        computer1.setEngine(sequenceEngine1);
        PlayerSpec human1spec = new HumanSpec(human1, Symbol.P);
        PlayerSpec computer1spec = new ComputerSpec(computer1, Symbol.Q);
        try {
            Game game2 = new Game(human1spec, computer1spec);
            playGame(game2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void usecase2() {
        Human human1 = new Human("jeff");
        Computer computer1 = new Computer("beta");
        Engine randomEngine1 = new RandomEngine();
        computer1.setEngine(randomEngine1);
        PlayerSpec human1spec = new HumanSpec(human1, Symbol.P);
        PlayerSpec computer1spec = new ComputerSpec(computer1, Symbol.Q);
        try {
            Game game2 = new Game(human1spec, computer1spec);
            playGame(game2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void usecase3() {
        Human human2 = new Human("elon");
        Human human3 = new Human("bill");
        PlayerSpec human2spec = new HumanSpec(human2, Symbol.P);
        PlayerSpec human3spec = new HumanSpec(human3, Symbol.O);
        try {
            Game game2 = new Game(human2spec, human3spec);
            playGame(game2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
