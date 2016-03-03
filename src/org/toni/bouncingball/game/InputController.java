package org.toni.bouncingball.game;

public interface InputController {

    void read();

    boolean hasQuitBeenInput();
    boolean hasPauseBeenInput();

}

