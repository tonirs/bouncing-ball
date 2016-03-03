package org.toni.bouncingball;

import org.toni.terminal.TerminalController;

public class Game implements Runnable, GameUpdater, GameRenderer {

    private TerminalController terminalController = new TerminalController();

    private static final int TARGET_FPS = 60;
    private GameLoop gameLoop = new GameLoop(TARGET_FPS, System.in, this, this);

//    private static final int INITIAL_BALL_VELOCITY = 3;
//    private Ball ball;

    public Game() {
//        ball = new Ball(inputStream, INITIAL_BALL_VELOCITY);
    }

    @Override
    public void run() {
        setUp();
        gameLoop.run();
        cleanUp();
    }

    private void setUp() {
        terminalController.loadTerminalConfiguration();
        terminalController.setTerminalAsCharacterBuffered();
    }

    private void cleanUp() {
        terminalController.restoreTerminalConfiguration();
    }

    @Override
    public void update(final long delta) {
//        ball.update(delta);
    }

    @Override
    public void render(final int fps) {
        System.out.println("p/P (pause/resume), s/S (stop)                                             FPS: " + fps);
        System.out.println("----------------------------------------------------------------------------------");
        System.out.println("|                                                                                |");
        System.out.println("|                                                                                |");
        System.out.println("|                                                                                |");
        System.out.println("|                                                                                |");
        System.out.println("|                                                                                |");
        System.out.println("|                                                                                |");
        System.out.println("|                                                                                |");
        System.out.println("|                                                                                |");
        System.out.println("|                                                                                |");
        System.out.println("|                                                                                |");
        System.out.println("|                                                                                |");
        System.out.println("|                                                                                |");
        System.out.println("|                                                                                |");
        System.out.println("|                                                                                |");
        System.out.println("|                                                                                |");
        System.out.println("|                                                                                |");
        System.out.println("|                                                                                |");
        System.out.println("|                                                                                |");
        System.out.println("|                                                                                |");
        System.out.println("|                                                                                |");
        System.out.println("|                                                                                |");
        System.out.println("|                                                                                |");
        System.out.println("|                                                                                |");
        System.out.println("|                                                                                |");
        System.out.println("|                                                                                |");
        System.out.println("|                                                                                |");
        System.out.println("|                                                                                |");
        System.out.println("|                                                                                |");
        System.out.println("|                                                                                |");
        System.out.println("|                                                                                |");
        System.out.println("----------------------------------------------------------------------------------");
    }

}

