package org.toni.bouncingball.game.model;

import org.toni.bouncingball.game.Game;

public class Ball {

    private static final int BALL_HEIGTH = 3;
    private static final int BALL_WIDTH = 7;

    private double vY;
    private double vX;

    private double y;
    private double x;

    private final double minY;
    private final double maxY;
    private final double minX;
    private final double maxX;

    public Ball(final double vY0, final double vX0,
                final double Y0, final double X0,
                final double minY, final double maxY,
                final double minX, final double maxX) {
        this.vY = vY0;
        this.vX = vX0;
        this.y = Y0;
        this.x = X0;
        this.minY = minY;
        this.maxY = maxY - BALL_HEIGTH + 1;
        this.minX = minX;
        this.maxX = maxX - BALL_WIDTH + 1;
    }

    public double getY() {
        return y;
    }

    public double getX() {
        return x;
    }

    public int getHeigth() {
        return BALL_HEIGTH;
    }

    public int getWidth() {
        return BALL_WIDTH;
    }

    public void update(final double deltaInNanos) {
        updatePosition(deltaInNanos);
    }

    private void updatePosition(final double deltaInNanos) {
        y += vY * deltaInNanos / Game.NANOS_PER_SECOND;
        if(y > maxY || y < minY) {
            vY *= -1;
        }

        x += vX * deltaInNanos / Game.NANOS_PER_SECOND;
        if(x > maxX || x < minX) {
            vX *= -1;
        }
    }

    public void increaseVelocity() {
        vY += vY > 0.0 ? 1.0 : -1.0;
        vX += vX > 0.0 ? 1.0 : -1.0;
    }

    public void decreaseVelocity() {
        vY -= vY > 0.0 ? 1.0 : -1.0;
        vX -= vX > 0.0 ? 1.0 : -1.0;
    }

}

