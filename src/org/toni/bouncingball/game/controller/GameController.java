package org.toni.bouncingball.game.controller;

import org.toni.bouncingball.game.GameUpdater;

public class GameController implements GameUpdater {

    private final int gameAreaWidth;
    private final int gameAreaHeight;

//    private static final int INITIAL_BALL_VELOCITY = 3;
//    private Ball ball;

    public GameController(final int gameAreaWidth, final int gameAreaHeight) {
        this.gameAreaWidth = gameAreaWidth;
        this.gameAreaHeight = gameAreaHeight;

//        ball = new Ball(inputStream, INITIAL_BALL_VELOCITY);
    }

    @Override
    public void update(final long delta) {
//        ball.update(delta);
    }

}

