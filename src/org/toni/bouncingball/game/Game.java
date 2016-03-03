package org.toni.bouncingball.game;

import org.toni.bouncingball.game.controller.GameController;
import org.toni.bouncingball.game.controller.InputStreamInputController;
import org.toni.bouncingball.game.renderer.TerminalGameRenderer;

public class Game implements Runnable {

    private final InputController inputController;

    private final GameUpdater gameUpdater;

    private static final int GAME_AREA_WIDTH = 78;
    private static final int GAME_AREA_HEIGHT = 28;
    private final GameRenderer gameRenderer;

    private static final int TARGET_FPS = 60;
    private GameLoop gameLoop;

    public Game() {
        inputController = new InputStreamInputController(System.in);
        gameUpdater = new GameController(GAME_AREA_WIDTH, GAME_AREA_HEIGHT);
        gameRenderer = new TerminalGameRenderer(GAME_AREA_WIDTH, GAME_AREA_HEIGHT);
        gameLoop = new GameLoop(TARGET_FPS, inputController, gameUpdater, gameRenderer);
    }

    @Override
    public void run() {
        gameRenderer.setUp();
        gameLoop.run();
        gameRenderer.cleanUp();
    }

}

