package org.toni.bouncingball.game;

import org.toni.bouncingball.game.controller.GameController;
import org.toni.bouncingball.game.controller.input.InputController;
import org.toni.bouncingball.game.controller.input.InputStreamInputController;
import org.toni.bouncingball.game.renderer.GameRenderer;
import org.toni.bouncingball.game.renderer.GameRendererFactory;
import org.toni.bouncingball.game.renderer.RenderableFactory;

public class Game implements Runnable {

    public static final long NANOS_PER_MILLI = 1000000L;
    public static final long NANOS_PER_SECOND = 1000000000L;

    private static final int GAME_AREA_HEIGHT = 27;
    private static final int GAME_AREA_WIDTH = 118;
    private final GameRenderer gameRenderer;

    private final GameController gameController;

    private static final int TARGET_FPS = 60;
    private GameLoop gameLoop;

    public Game(final GameRendererFactory gameRendererFactory, final RenderableFactory renderableFactory) {
        final InputController inputController = new InputStreamInputController(System.in);
        gameRenderer = gameRendererFactory.createGameRenderer(GAME_AREA_HEIGHT, GAME_AREA_WIDTH);
        gameController = new GameController(inputController, renderableFactory, gameRenderer, GAME_AREA_HEIGHT, GAME_AREA_WIDTH);
        gameLoop = new GameLoop(TARGET_FPS, inputController, gameController, gameRenderer);
    }

    @Override
    public void run() {
        gameRenderer.setUp();
        gameController.setUp();

        gameLoop.run();

        gameController.cleanUp();
        gameRenderer.cleanUp();
    }

}

