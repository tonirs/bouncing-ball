package org.toni.bouncingball.game.updater;

public interface GameUpdater {

    void setUp();
    void cleanUp();

    void update(final long deltaInNanos);

}

