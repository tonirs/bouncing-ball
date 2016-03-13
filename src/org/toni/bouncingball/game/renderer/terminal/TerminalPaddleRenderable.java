package org.toni.bouncingball.game.renderer.terminal;

import org.toni.bouncingball.game.model.Paddle;

public class TerminalPaddleRenderable extends TerminalRenderable {

    private final Paddle paddle;

    public TerminalPaddleRenderable(final Paddle paddle) {
        this.paddle = paddle;
    }

    @Override
    protected void render(final char[][] renderArea) {
        final int y = (int)paddle.getY();
        final int maxY = renderArea.length - paddle.getHeight();
        if(y >= 0 && y <= maxY) {
            final int x = (int)paddle.getX();
            final int maxX = renderArea[0].length - paddle.getWidth();
            if(x >= 0 && x <= maxX) {
                for (int j = 0; j < paddle.getHeight() ; ++j) {
                    for (int i = 0 ; i < paddle.getWidth() ; ++i) {
                        renderArea[y + j][x + i] = '#';
                    }
                }
            }
        }
    }

}

