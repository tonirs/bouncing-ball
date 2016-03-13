package org.toni.bouncingball.game.renderer;

import java.util.ArrayList;
import java.util.List;

public abstract class GameRenderer<T> {

    protected T renderArea;

    private List<Renderable> renderables = null;

    protected GameRenderer(final T renderArea) {
        this.renderArea = renderArea;
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
        for (final Renderable renderable : renderables) {
            renderable.render(renderArea);
        }
    }

}

