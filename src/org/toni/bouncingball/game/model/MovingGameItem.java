package org.toni.bouncingball.game.model;

import org.toni.bouncingball.game.Game;

public class MovingGameItem extends GameItem {

    protected double vY;
    protected double vX;

    public MovingGameItem(final double vY0, final double vX0,
                          final double Y0, final double X0,
                          final int height, final int width,
                          final double minY, final double maxY,
                          final double minX, final double maxX) {
        super(Y0, X0, height, width, minY, maxY, minX, maxX);

        this.vY = vY0;
        this.vX = vX0;
    }

    public double getvX() {
        return vX;
    }

    public double getvY() {
        return vY;
    }

    public void increaseVelocity() {
        vY += vY > 0.0 ? 1.0 : -1.0;
        vX += vX > 0.0 ? 1.0 : -1.0;
    }

    public void decreaseVelocity() {
        vY -= vY > 0.0 ? 1.0 : -1.0;
        vX -= vX > 0.0 ? 1.0 : -1.0;
    }

    @Override
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
            invertVelocityX();
        }
    }

    public void invertVelocityX() {
        vX *= -1;
    }
}

