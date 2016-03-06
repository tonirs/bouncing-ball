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
        final int maxY = gameArea.length - ball.getHeight();
        if(y >= 0 && y <= maxY) {
            final int x = (int)ball.getX();
            final int maxX = gameArea[0].length - ball.getWidth();
            if(x >= 0 && x <= maxX) {
                for (int j = 0; j < ball.getHeight() ; ++j) {
                    for (int i = 0 ; i < ball.getWidth() ; ++i) {
                        gameArea[y + j][x + i] = '*';
                    }
                }
                gameArea[y][x] = ' ';
                gameArea[y][x + ball.getWidth() - 1] = ' ';
                gameArea[y + ball.getHeight() - 1][x] = ' ';
                gameArea[y + ball.getHeight() - 1][x + ball.getWidth() - 1] = ' ';
            }
        }
    }

}

