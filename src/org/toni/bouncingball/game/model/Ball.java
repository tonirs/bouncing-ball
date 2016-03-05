package org.toni.bouncingball.game.model;

import org.toni.bouncingball.game.Game;

import java.io.InputStream;

public class Ball {

    private final InputStream inputStream;

    private double vY;
    private double vX;

    private double y;
    private double x;

    private final double minY;
    private final double maxY;
    private final double minX;
    private final double maxX;

    public Ball(final InputStream inputStream,
                final double vY0, final double vX0,
                final double Y0, final double X0,
                final double minY, final double maxY,
                final double minX, final double maxX) {
        this.inputStream = inputStream;
        this.vY = vY0;
        this.vX = vX0;
        this.y = Y0;
        this.x = X0;
        this.minY = minY;
        this.maxY = maxY;
        this.minX = minX;
        this.maxX = maxX;
    }

    public double getY() {
        return y;
    }

    public double getX() {
        return x;
    }

    public void update(final double deltaInNanos) {
//        updateVelocityIfInputAvailable();
        updatePosition(deltaInNanos);
    }

//    private void updateVelocityIfInputAvailable() {
//        try {
//            if(inputStream.available() > 0) {
//                final char key = (char)System.in.read();
//                switch (key) {
//                    case '+':
////                        keepRunning = false;
//                        break;
//                    case '-':
////                        pause = !pause;
//                        break;
//                }
//            }
//        } catch (final IOException e) {
//            e.printStackTrace();
//        }
//    }

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

}

