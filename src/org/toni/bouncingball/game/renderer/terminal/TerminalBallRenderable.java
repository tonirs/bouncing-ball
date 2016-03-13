package org.toni.bouncingball.game.renderer.terminal;

import org.toni.bouncingball.game.model.Ball;

public class TerminalBallRenderable extends TerminalRenderable {

    private final Ball ball;

    public TerminalBallRenderable(final Ball ball) {
        this.ball = ball;
    }

    @Override
    protected void render(final char[][] renderArea) {
        final int y = (int)ball.getY();
        final int maxY = renderArea.length - ball.getHeight();
        if(y >= 0 && y <= maxY) {
            final int x = (int)ball.getX();
            final int maxX = renderArea[0].length - ball.getWidth();
            if(x >= 0 && x <= maxX) {
                for (int j = 0; j < ball.getHeight() ; ++j) {
                    for (int i = 0 ; i < ball.getWidth() ; ++i) {
                        renderArea[y + j][x + i] = '*';
                    }
                }
                if(ball.getWidth() > 2) {
                    renderArea[y][x] = ' ';
                    renderArea[y][x + ball.getWidth() - 1] = ' ';
                }
                if(ball.getHeight() > 2) {
                    renderArea[y + ball.getHeight() - 1][x] = ' ';
                    renderArea[y + ball.getHeight() - 1][x + ball.getWidth() - 1] = ' ';
                }
            }
        }
    }

}

