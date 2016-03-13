package org.toni.bouncingball.game.renderer;

public interface GameRendererFactory<T> {

    GameRenderer<T> createGameRenderer(final int renderAreaHeight, final int renderAreaWidth);

}

