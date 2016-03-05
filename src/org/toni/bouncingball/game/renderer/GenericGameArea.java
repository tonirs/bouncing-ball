package org.toni.bouncingball.game.renderer;

import java.lang.reflect.Array;

public class GenericGameArea<T> {

    private final int height;
    private final int width;

    private T[][] gameArea;

    @SuppressWarnings("unchecked")
    public GenericGameArea(final Class<T> valueClass, final int height, final int width) {
        this.height = height;
        this.width = width;

        gameArea = (T[][])Array.newInstance(valueClass, height, width);
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public T[][] getGameArea() {
        return gameArea;
    }

    public void clear(final T value) {
        for (int y = 0; y < height; ++y) {
            for (int x = 0; x < width; ++x) {
                gameArea[y][x] = value;
            }
        }
    }

}

