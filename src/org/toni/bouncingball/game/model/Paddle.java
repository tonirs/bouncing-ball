package org.toni.bouncingball.game.model;

public class Paddle extends GameItem {

    private static final int HEIGHT = 6;
    private static final int WIDTH = 1;

    public Paddle(final double Y0, final double X0,
                  final double minY, final double maxY,
                  final double minX, final double maxX) {
        super(Y0, X0, HEIGHT, WIDTH, minY, maxY, minX, maxX);
    }

}

