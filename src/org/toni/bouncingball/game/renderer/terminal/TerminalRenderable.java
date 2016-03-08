package org.toni.bouncingball.game.renderer.terminal;

import org.toni.bouncingball.game.renderer.GenericGameArea;
import org.toni.bouncingball.game.renderer.Renderable;

public abstract class TerminalRenderable implements Renderable {

    @Override
    public void render(final Object gameAreaObject) {
        final GenericGameArea<Character> genericGameArea = (GenericGameArea<Character>) gameAreaObject;
        render(genericGameArea.getGameArea());
    }

    protected abstract void render(final Character[][] gameArea);

}

