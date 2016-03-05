package org.toni.bouncingball.game.renderer.terminal;

import org.toni.bouncingball.game.renderer.GenericGameArea;
import org.toni.bouncingball.game.renderer.Renderable;

public abstract class TerminalRenderable implements Renderable<Character> {

    @Override
    public void render(final GenericGameArea<Character> genericGameArea) {
        render(genericGameArea.getGameArea());
    }

    protected abstract void render(final Character[][] gameArea);

}

