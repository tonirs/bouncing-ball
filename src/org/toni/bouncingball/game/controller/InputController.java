package org.toni.bouncingball.game.controller;

public interface InputController {

    void read();

    boolean hasQuitBeenInput();
    boolean hasPauseBeenInput();

}

