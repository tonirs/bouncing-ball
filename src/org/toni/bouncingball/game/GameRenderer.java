package org.toni.bouncingball.game;

public interface GameRenderer {

    void setUp();
    void cleanUp();

    void render(final int fps);

}

