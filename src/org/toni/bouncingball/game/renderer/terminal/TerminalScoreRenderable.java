package org.toni.bouncingball.game.renderer.terminal;

import org.toni.bouncingball.game.model.Score;

public class TerminalScoreRenderable extends TerminalRenderable {

    private final Score score;

    public TerminalScoreRenderable(final Score score) {
        this.score = score;
    }

    @Override
    protected void render(final Character[][] gameArea) {
        final int y = (int)score.getY();
        final int x = (int)score.getX();

        final int value = score.getValue();
        final int hundreds = value / 100;
        int reminder = value % 100;
        final int tens = reminder / 10;
        reminder = reminder % 10;

        gameArea[y][x] = 'S';
        gameArea[y][x + 1] = ' ';
        gameArea[y][x + 2] = (char)('0' + hundreds);
        gameArea[y][x + 3] = (char)('0' + tens);
        gameArea[y][x + 4] = (char)('0' + reminder);
    }

}

