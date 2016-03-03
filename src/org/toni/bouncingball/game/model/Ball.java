package org.toni.bouncingball.game.model;

import java.io.IOException;
import java.io.InputStream;

public class Ball {

    private final InputStream inputStream;
    private int velocity;
    private int position;

    public Ball(final InputStream inputStream, final int initialVelocity) {
        this.inputStream = inputStream;
        this.velocity = initialVelocity;
        this.position = 0;
    }

    public void update(final double delta) {
        updateVelocityIfInputAvailable();
        updatePosition(delta);
    }

    private void updateVelocityIfInputAvailable() {
        try {
            if(inputStream.available() > 0) {
                final char key = (char)System.in.read();
                switch (key) {
                    case '+':
//                        keepRunning = false;
                        break;
                    case '-':
//                        pause = !pause;
                        break;
                }
            }
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

    private void updatePosition(final double delta) {
        position += velocity * delta;
    }

}

