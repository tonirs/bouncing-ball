package org.toni.bouncingball;

public class GameRunner {

    public void run() {
        Thread thread = new Thread(new Game(), "Game");
        thread.start();
    }

    public static void main(String[] args) {
        GameRunner gameRunner = new GameRunner();
        gameRunner.run();
    }

}

