package org.toni.bouncingball.game.controller;

import org.toni.bouncingball.game.model.Ball;
import org.toni.bouncingball.game.renderer.terminal.TerminalBallRenderable;
import org.toni.bouncingball.game.renderer.GameRenderer;
import org.toni.bouncingball.game.renderer.Renderable;
import org.toni.bouncingball.game.updater.GameUpdater;

public class GameController implements GameUpdater {

    private final GameRenderer gameRenderer;

    private static final double BALL_VY_0 = 15.0;
    private static final double BALL_VX_0 = 20.0;
    private static final double BALL_Y_0 = 0;
    private static final double BALL_X_0 = 0;
    private Ball ball;

    public GameController(final GameRenderer gameRenderer, int gameAreaHeight, int gameAreaWidth) {
        this.gameRenderer = gameRenderer;

        ball = new Ball(BALL_VY_0, BALL_VX_0, BALL_Y_0, BALL_X_0, 0.0, gameAreaHeight, 0.0, gameAreaWidth);
        final Renderable<Character> ballRenderable = new TerminalBallRenderable(ball);

        this.gameRenderer.addRenderable(ballRenderable);
    }

    @Override
    public void update(final long deltaInNanos) {
        ball.update(deltaInNanos);
    }

}

