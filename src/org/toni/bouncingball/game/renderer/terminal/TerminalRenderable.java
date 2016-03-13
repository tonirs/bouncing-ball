package org.toni.bouncingball.game.renderer.terminal;

import org.toni.bouncingball.game.renderer.Renderable;

public abstract class TerminalRenderable implements Renderable<TerminalRenderArea> {

    @Override
    public void render(final TerminalRenderArea terminalRenderArea) {
        render(terminalRenderArea.getRenderArea());
    }

    protected abstract void render(final char[][] renderArea);

}

