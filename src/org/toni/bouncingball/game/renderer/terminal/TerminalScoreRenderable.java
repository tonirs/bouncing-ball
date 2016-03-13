package org.toni.bouncingball.game.renderer.terminal;

import org.toni.bouncingball.game.model.Score;

public class TerminalScoreRenderable extends TerminalRenderable {

    private final Score score;

    public TerminalScoreRenderable(final Score score) {
        this.score = score;
    }

    @Override
    protected void render(final char[][] renderArea) {
        final int y = (int)score.getY();
        final int x = (int)score.getX();

        final int value = score.getValue();
        final int hundreds = value / 100;
        int reminder = value % 100;
        final int tens = reminder / 10;
        reminder = reminder % 10;

        renderArea[y][x] = 'S';
        renderArea[y][x + 1] = ' ';
        renderArea[y][x + 2] = (char)('0' + hundreds);
        renderArea[y][x + 3] = (char)('0' + tens);
        renderArea[y][x + 4] = (char)('0' + reminder);
    }

}

