package org.toni.bouncingball.game.renderer.terminal;

import org.toni.bouncingball.game.model.Lives;

public class TerminalLivesRenderable extends TerminalRenderable {

    private final Lives lives;

    public TerminalLivesRenderable(final Lives lives) {
        this.lives = lives;
    }

    @Override
    protected void render(final Character[][] gameArea) {
        final int y = (int)lives.getY();
        final int x = (int)lives.getX();

        final int value = lives.getValue();

        gameArea[y][x] = 'L';
        gameArea[y][x + 1] = ' ';
        gameArea[y][x + 2] = (char)('0' + value);
    }

}

