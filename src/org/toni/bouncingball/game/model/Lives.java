package org.toni.bouncingball.game.model;

public class Lives extends GameItem {

    private static final int HEIGHT = 1;
    private static final int WIDTH = 1;

    private static final int INITIAL_LIVES = 3;

    private int value = INITIAL_LIVES;

    public Lives(final double Y0, final double X0,
                 final double minY, final double maxY,
                 final double minX, final double maxX) {
        super(Y0, X0, HEIGHT, WIDTH, minY, maxY, minX, maxX);
    }

    public int getValue() {
        return value;
    }

    public void decreaseValue() {
        --value;
    }

}

