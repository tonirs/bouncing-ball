package org.toni.bouncingball.game;

import org.toni.bouncingball.game.controller.GameController;
import org.toni.bouncingball.game.controller.InputController;
import org.toni.bouncingball.game.controller.InputStreamInputController;
import org.toni.bouncingball.game.renderer.GameRenderer;
import org.toni.bouncingball.game.renderer.terminal.TerminalGameRenderer;
import org.toni.bouncingball.game.updater.GameUpdater;

public class Game implements Runnable {

    public static final long NANOS_PER_MILLI = 1000000L;
    public static final long NANOS_PER_SECOND = 1000000000L;

    private final InputController inputController;

    private static final int GAME_AREA_HEIGHT = 28;
    private static final int GAME_AREA_WIDTH = 78;
    private final GameRenderer gameRenderer;

    private final GameUpdater gameUpdater;

    private static final int TARGET_FPS = 60;
    private GameLoop gameLoop;

    public Game() {
        inputController = new InputStreamInputController(System.in);
        gameRenderer = new TerminalGameRenderer(GAME_AREA_HEIGHT, GAME_AREA_WIDTH);
        gameUpdater = new GameController(gameRenderer, GAME_AREA_HEIGHT, GAME_AREA_WIDTH);
        gameLoop = new GameLoop(TARGET_FPS, inputController, gameUpdater, gameRenderer);
    }

    @Override
    public void run() {
        gameRenderer.setUp();
        gameLoop.run();
        gameRenderer.cleanUp();
    }

}

