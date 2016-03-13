package org.toni.bouncingball.game.renderer.terminal;

import org.toni.bouncingball.game.renderer.GameRenderer;
import org.toni.bouncingball.game.renderer.GameRendererFactory;

public class TerminalGameRendererFactory implements GameRendererFactory<TerminalRenderArea> {

    @Override
    public GameRenderer<TerminalRenderArea> createGameRenderer(final int renderAreaHeight, final int renderAreaWidth) {
        return new TerminalGameRenderer(renderAreaHeight, renderAreaWidth);
    }

}

