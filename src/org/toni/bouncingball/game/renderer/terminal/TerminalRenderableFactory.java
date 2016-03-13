package org.toni.bouncingball.game.renderer.terminal;

import org.toni.bouncingball.game.model.Ball;
import org.toni.bouncingball.game.model.Lives;
import org.toni.bouncingball.game.model.Paddle;
import org.toni.bouncingball.game.model.Score;
import org.toni.bouncingball.game.renderer.Renderable;
import org.toni.bouncingball.game.renderer.RenderableFactory;

public class TerminalRenderableFactory implements RenderableFactory<TerminalRenderArea> {

    @Override
    public Renderable<TerminalRenderArea> createLivesRenderable(Lives lives) {
        return new TerminalLivesRenderable(lives);
    }

    @Override
    public Renderable<TerminalRenderArea> createScoreRenderable(Score score) {
        return new TerminalScoreRenderable(score);
    }

    @Override
    public Renderable<TerminalRenderArea> createBallRenderable(Ball ball) {
        return new TerminalBallRenderable(ball);
    }

    @Override
    public Renderable<TerminalRenderArea> createPaddleRenderable(Paddle paddle) {
        return new TerminalPaddleRenderable(paddle);
    }

}

