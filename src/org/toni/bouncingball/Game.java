package org.toni.bouncingball;

import org.toni.terminal.TerminalController;

import java.util.Arrays;

public class Game implements Runnable, GameUpdater, GameRenderer {

    private TerminalController terminalController = new TerminalController();

    private static final int TARGET_FPS = 60;
    private GameLoop gameLoop = new GameLoop(TARGET_FPS, System.in, this, this);

    private static final int SCREEN_WIDTH = 80;
    private static final int SCREEN_HEIGHT = 30;

    private static final int GAME_AREA_WIDTH = SCREEN_WIDTH - 2;
    private static final int GAME_AREA_HEIGHT = SCREEN_HEIGHT - 2;

    private final String horizontalLine;
    private final String header;

//    private static final int INITIAL_BALL_VELOCITY = 3;
//    private Ball ball;

    public Game() {
        header = new String("p/P (pause/resume), s/S (stop)                                           FPS: ");

        char[] horizontalLineAsArray = new char[SCREEN_WIDTH];
        Arrays.fill(horizontalLineAsArray, '-');
        horizontalLine = new String(horizontalLineAsArray);

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
        char[][] gameArea = createGameArea();

//        renderables.render(gameArea, GAME_AREA_WIDTH, GAME_AREA_HEIGHT);
gameArea[(int)(Math.random() * GAME_AREA_HEIGHT)][(int)(Math.random() * GAME_AREA_WIDTH)] = '*';

        StringBuffer stringBuffer = new StringBuffer(header);
        stringBuffer.append(fps);
        System.out.println(stringBuffer.toString());

        System.out.println(horizontalLine);

        for (int y = 0 ; y < GAME_AREA_HEIGHT ; ++y) {
            stringBuffer.setLength(0);
            stringBuffer.append('|');
            stringBuffer.append(gameArea[y]);
            stringBuffer.append('|');
            System.out.println(stringBuffer);
        }

        System.out.println(horizontalLine);
    }

    private char[][] createGameArea() {
        char[][] gameArea = new char[GAME_AREA_HEIGHT][GAME_AREA_WIDTH];
        for (int y = 0 ; y < GAME_AREA_HEIGHT ; ++y) {
            Arrays.fill(gameArea[y], ' ');
        }
        return gameArea;
    }

}

