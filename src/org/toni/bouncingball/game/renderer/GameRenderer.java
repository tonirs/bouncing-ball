package org.toni.bouncingball.game.renderer;

import java.util.ArrayList;
import java.util.List;

public abstract class GameRenderer<T> {

    protected GenericGameArea<T> genericGameArea;

    private final T gameAreaInitialValue;

    private List<Renderable> renderables = null;

    protected GameRenderer(final Class<T> gameAreaClass, final int gameAreaHeight, final int gameAreaWidth,
                           final T gameAreaInitialValue) {
        genericGameArea = new GenericGameArea<T>(gameAreaClass, gameAreaHeight, gameAreaWidth);
        this.gameAreaInitialValue = gameAreaInitialValue;
    }

    public void setUp() {
        renderables = new ArrayList<>();
    }

    public void cleanUp() {
        renderables.clear();
    }

    public void addRenderable(final Renderable renderable) {
        renderables.add(renderable);
    }

    public void removeRenderable(final Renderable renderable) {
        renderables.remove(renderable);
    }

    public void render(final int fps) {
        genericGameArea.clear(gameAreaInitialValue);
        for (final Renderable renderable : renderables) {
            renderable.render(genericGameArea);
        }
    }

}

