package org.toni.bouncingball.game.renderer.terminal;

import org.toni.bouncingball.game.model.Lives;

public class TerminalLivesRenderable extends TerminalRenderable {

    private final Lives lives;

    public TerminalLivesRenderable(final Lives lives) {
        this.lives = lives;
    }

    @Override
    protected void render(final char[][] renderArea) {
        final int y = (int)lives.getY();
        final int x = (int)lives.getX();

        final int value = lives.getValue();

        renderArea[y][x] = 'L';
        renderArea[y][x + 1] = ' ';
        renderArea[y][x + 2] = (char)('0' + value);
    }

}

