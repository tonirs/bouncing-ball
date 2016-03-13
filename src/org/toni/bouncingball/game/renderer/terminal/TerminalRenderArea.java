package org.toni.bouncingball.game.renderer.terminal;

public class TerminalRenderArea {

    private final int height;
    private final int width;

    private final char[][] renderArea;

    private final char clearValue;

    public TerminalRenderArea(final int height, final int width, final char clearValue) {
        this.height = height;
        this.width = width;

        renderArea = new char[height][width];

        this.clearValue = clearValue;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public char[][] getRenderArea() {
        return renderArea;
    }

    public void clear() {
        for (int y = 0; y < height; ++y) {
            for (int x = 0; x < width; ++x) {
                renderArea[y][x] = clearValue;
            }
        }
    }

}

