package org.toni.bouncingball.game.renderer;

import org.toni.bouncingball.game.model.Ball;
import org.toni.bouncingball.game.model.Lives;
import org.toni.bouncingball.game.model.Paddle;
import org.toni.bouncingball.game.model.Score;

public interface RenderableFactory<T> {

    Renderable<T> createLivesRenderable(final Lives lives);

    Renderable<T> createScoreRenderable(final Score score);

    Renderable<T> createBallRenderable(final Ball ball);

    Renderable<T> createPaddleRenderable(final Paddle paddle);

}

