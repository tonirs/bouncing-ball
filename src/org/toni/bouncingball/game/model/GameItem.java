package org.toni.bouncingball.game.model;

public class GameItem {
    protected double y;
    protected double x;

    private final int height;
    private final int width;

    protected final double minY;
    protected final double maxY;
    protected final double minX;
    protected final double maxX;

    public GameItem(final double Y0, final double X0,
                    final int height, final int width,
                    final double minY, final double maxY,
                    final double minX, final double maxX) {
        this.y = Y0;
        this.x = X0;
        this.height = height;
        this.width = width;
        this.minY = minY;
        this.maxY = maxY - height + 1;
        this.minX = minX;
        this.maxX = maxX - width + 1;
    }

    public double getY() {
        return y;
    }

    public void increaseY() {
        if(y < maxY) {
            ++y;
        }
    }

    public void decreaseY() {
        if(y > 0.0) {
            --y;
        }
    }

    public double getX() {
        return x;
    }

    public void increaseX() {
        if(x < maxX) {
            ++x;
        }
    }

    public void decreaseX() {
        if(x > 0.0) {
            --x;
        }
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void update(final double deltaInNanos) {
    }

}

