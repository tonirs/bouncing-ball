package org.toni.bouncingball.game.controller;

import org.toni.bouncingball.game.controller.input.InputController;
import org.toni.bouncingball.game.event.input.InputEvent;
import org.toni.bouncingball.game.event.input.InputEventHandler;
import org.toni.bouncingball.game.model.Ball;
import org.toni.bouncingball.game.model.Paddle;
import org.toni.bouncingball.game.model.Score;
import org.toni.bouncingball.game.renderer.terminal.TerminalBallRenderable;
import org.toni.bouncingball.game.renderer.GameRenderer;
import org.toni.bouncingball.game.renderer.Renderable;
import org.toni.bouncingball.game.renderer.terminal.TerminalPaddleRenderable;
import org.toni.bouncingball.game.renderer.terminal.TerminalScoreRenderable;
import org.toni.bouncingball.game.updater.GameUpdater;

public class GameController implements GameUpdater, InputEventHandler {

    private final InputController inputController;

    private final GameRenderer gameRenderer;

    private final double maxY;
    private final double maxX;

    private static final double SCORE_Y_0 = 0.0;
    private static final double SCORE_X_0 = 1.0;
    private Score score = null;
    private Renderable<Character> scoreRenderable = null;

    private static final double BALL_VY_0 = 15.0;
    private static final double BALL_VX_0 = 20.0;
    private static final double BALL_Y_0 = 15.0;
    private static final double BALL_X_0 = 100.0;
    private Ball ball = null;
    private Renderable<Character> ballRenderable = null;

    private static final double PADDLE_Y_0 = 10.0;
    private static final double PADDLE_X_0 = 10.0;
    private Paddle paddle = null;
    private Renderable<Character> paddleRenderable = null;

    public GameController(final InputController inputController,
                          final GameRenderer gameRenderer, int gameAreaHeight, int gameAreaWidth) {
        this.inputController = inputController;

        this.gameRenderer = gameRenderer;

        this.maxY = gameAreaHeight - 1;
        this.maxX = gameAreaWidth - 1;
    }

    @Override
    public void setUp() {
        score = new Score(SCORE_Y_0, SCORE_X_0, 0.0, maxY, 0.0, maxX);
        scoreRenderable = new TerminalScoreRenderable(score);
        gameRenderer.addRenderable(scoreRenderable);

        ball = new Ball(BALL_VY_0, BALL_VX_0, BALL_Y_0, BALL_X_0, 0.0, maxY, 0.0, maxX);
        ballRenderable = new TerminalBallRenderable(ball);
        gameRenderer.addRenderable(ballRenderable);

        paddle = new Paddle(PADDLE_Y_0, PADDLE_X_0, 0.0, maxY, 0.0, maxX);
        paddleRenderable = new TerminalPaddleRenderable(paddle);
        gameRenderer.addRenderable(paddleRenderable);

        inputController.addInputEventHandler(this);
    }

    @Override
    public void cleanUp() {
        inputController.removeInputEventHandler(this);

        gameRenderer.removeRenderable(paddleRenderable);
        gameRenderer.removeRenderable(ballRenderable);

        paddleRenderable = null;
        paddle = null;

        ballRenderable = null;
        ball = null;
    }

    @Override
    public void update(final long deltaInNanos) {
        ball.update(deltaInNanos);
        paddle.update(deltaInNanos);

        final double ballLostX = Math.max(paddle.getX() - 2.0, 0.0);
        if(ball.getX() <= ballLostX) {
            score.increaseValue();
            ball.setX(BALL_X_0);
        } else {
            bounceBallIfBumpedOnPaddle();
        }
    }

    private void bounceBallIfBumpedOnPaddle() {
        final double upperBumpY = paddle.getY() - ball.getHeight();
        if(ball.getY() <= upperBumpY) {
            return;
        }

        final double lowerBumpY = paddle.getY() + paddle.getHeight();
        if(ball.getY() >= lowerBumpY) {
            return;
        }

        final double rigthBumpX = paddle.getX() + paddle.getWidth();
        if(ball.getX() > rigthBumpX) {
            return;
        }

        if(ball.getX() > paddle.getX()) {
            ball.invertVelocityX();
            return;
        }

        final double leftBumpX = paddle.getX() - ball.getWidth();
        if(ball.getX() < leftBumpX) {
            return;
        }

        ball.invertVelocityX();
    }

    @Override
    public void handle(final InputEvent inputEvent) {
        switch (inputEvent) {
            case PLUS:
                ball.increaseVelocity();
                break;
            case MINUS:
                ball.decreaseVelocity();
                break;
            case Q:
                paddle.decreaseY();
                break;
            case A:
                paddle.increaseY();
                break;
        }
    }
}

