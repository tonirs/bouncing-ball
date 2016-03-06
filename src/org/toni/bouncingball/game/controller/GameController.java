package org.toni.bouncingball.game.controller;

import org.toni.bouncingball.game.controller.input.InputController;
import org.toni.bouncingball.game.event.input.InputEvent;
import org.toni.bouncingball.game.event.input.InputEventHandler;
import org.toni.bouncingball.game.model.Ball;
import org.toni.bouncingball.game.renderer.terminal.TerminalBallRenderable;
import org.toni.bouncingball.game.renderer.GameRenderer;
import org.toni.bouncingball.game.renderer.Renderable;
import org.toni.bouncingball.game.updater.GameUpdater;

public class GameController implements GameUpdater, InputEventHandler {

    private final InputController inputController;

    private final GameRenderer gameRenderer;

    private final int gameAreaHeight;
    private final int gameAreaWidth;

    private static final double BALL_VY_0 = 15.0;
    private static final double BALL_VX_0 = 20.0;
    private static final double BALL_Y_0 = 0;
    private static final double BALL_X_0 = 0;
    private Ball ball = null;

    private Renderable<Character> ballRenderable = null;

    public GameController(final InputController inputController,
                          final GameRenderer gameRenderer, int gameAreaHeight, int gameAreaWidth) {
        this.inputController = inputController;

        this.gameRenderer = gameRenderer;

        this.gameAreaHeight = gameAreaHeight;
        this.gameAreaWidth = gameAreaWidth;
    }

    @Override
    public void setUp() {
        ball = new Ball(BALL_VY_0, BALL_VX_0, BALL_Y_0, BALL_X_0, 0.0, gameAreaHeight, 0.0, gameAreaWidth);
        ballRenderable = new TerminalBallRenderable(ball);

        gameRenderer.addRenderable(ballRenderable);

        inputController.addInputEventHandler(this);
    }

    @Override
    public void cleanUp() {
        inputController.removeInputEventHandler(this);

        gameRenderer.removeRenderable(ballRenderable);

        ballRenderable = null;
        ball = null;
    }

    @Override
    public void update(final long deltaInNanos) {
        ball.update(deltaInNanos);
    }

    @Override
    public void handle(final InputEvent inputEvent) {
        switch (inputEvent) {
            case QUIT:
                break;
            case PAUSE:
                break;
        }
    }
}

