package org.toni.bouncingball.game.model;

public class Ball extends MovingGameItem {

    private static final int HEIGHT = 3;
    private static final int WIDTH = 7;

    public Ball(final double vY0, final double vX0,
                final double Y0, final double X0,
                final double minY, final double maxY,
                final double minX, final double maxX) {
        super(vY0, vX0, Y0, X0, HEIGHT, WIDTH, minY, maxY, minX, maxX);
    }

}

