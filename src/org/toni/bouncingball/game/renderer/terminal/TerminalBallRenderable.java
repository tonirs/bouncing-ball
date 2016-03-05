package org.toni.bouncingball.game.renderer.terminal;

import org.toni.bouncingball.game.model.Ball;

public class TerminalBallRenderable extends TerminalRenderable {

    private final Ball ball;

    public TerminalBallRenderable(final Ball ball) {
        this.ball = ball;
    }

    @Override
    protected void render(final Character[][] gameArea) {
        final int y = (int)ball.getY();
        if(y >= 0 && y < gameArea.length) {
            final int x = (int)ball.getX();
            if(x >= 0 && x < gameArea[0].length) {
                gameArea[y][x] = '*';
            }
        }
    }

}

