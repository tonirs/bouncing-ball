package org.toni.bouncingball.game;

import org.toni.bouncingball.game.renderer.GameRendererFactory;
import org.toni.bouncingball.game.renderer.RenderableFactory;
import org.toni.bouncingball.game.renderer.terminal.TerminalGameRendererFactory;
import org.toni.bouncingball.game.renderer.terminal.TerminalRenderableFactory;

public class GameRunner {

    final GameRendererFactory gameRendererFactory;
    final RenderableFactory renderableFactory;

    public GameRunner(final GameRendererFactory gameRendererFactory, final RenderableFactory renderableFactory) {
        this.gameRendererFactory = gameRendererFactory;
        this.renderableFactory = renderableFactory;
    }

    public void run() {
        Thread thread = new Thread(new Game(gameRendererFactory, renderableFactory), "Game");
        thread.start();
    }

    public static void main(String[] args) {
        GameRendererFactory gameRendererFactory = null;
        RenderableFactory renderableFactory = null;

        if(args != null) {
            for (final String arg : args) {
                if(arg.equalsIgnoreCase("-term")) {
                    gameRendererFactory = new TerminalGameRendererFactory();
                    renderableFactory = new TerminalRenderableFactory();
                } else if(arg.equalsIgnoreCase("-awt")) {
                    ;
                }
            }
        }

        if(gameRendererFactory == null) {
            System.out.println("Parameters: -term | -awt");
        } else {
            final GameRunner gameRunner = new GameRunner(gameRendererFactory, renderableFactory);
            gameRunner.run();
        }
    }

}

