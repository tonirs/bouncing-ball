package org.toni.bouncingball.game;

import org.toni.bouncingball.game.event.input.InputEvent;
import org.toni.bouncingball.game.event.input.InputEventHandler;
import org.toni.bouncingball.game.controller.input.InputController;
import org.toni.bouncingball.game.renderer.GameRenderer;
import org.toni.bouncingball.game.updater.GameUpdater;

public class GameLoop implements Runnable, InputEventHandler {

    private boolean keepRunning = true;
    private boolean pause = false;

    private final double targetNanosPerFrame;

    private final InputController inputController;
    private final GameUpdater gameUpdater;
    private final GameRenderer gameRenderer;

    public GameLoop(final int targetFps,
                    final InputController inputController,
                    final GameUpdater gameUpdater,
                    final GameRenderer gameRenderer) {
        this.targetNanosPerFrame = Game.NANOS_PER_SECOND / (double) targetFps;
        this.inputController = inputController;
        this.gameUpdater = gameUpdater;
        this.gameRenderer = gameRenderer;
    }

    @Override
    public void run() {
        inputController.addInputEventHandler(this);

        long lastFrameStartNanos = System.nanoTime();

        int fps = 0;
        int frames = 0;
        long nanosElapsedSinceLastFPSReport = 0L;

        while(keepRunning) {
            final long frameStartNanos = System.nanoTime();

            final boolean wasPaused = pause;

            inputController.update(0L);

            if(!pause) {
                if(wasPaused) {
                    lastFrameStartNanos = frameStartNanos;
                    frames = 0;
                    nanosElapsedSinceLastFPSReport = 0L;
                }

                // Calculate delta
                final long nanosElapsedSinceLastFrame = frameStartNanos - lastFrameStartNanos;
                lastFrameStartNanos = frameStartNanos;

                // Update frame counters and report FPS every second
                frames++;
                nanosElapsedSinceLastFPSReport += nanosElapsedSinceLastFrame;
                if (nanosElapsedSinceLastFPSReport >= Game.NANOS_PER_SECOND) {
                    fps = frames;
                    frames = 0;
                    nanosElapsedSinceLastFPSReport = 0L;
                }

                gameUpdater.update(nanosElapsedSinceLastFrame);

                gameRenderer.render(fps);
            }

            // Wait until the target frame end
            final long frameEndNanos = System.nanoTime();
            final long nanosElapsedSinceFrameStart = frameEndNanos - frameStartNanos;
            final double nanosUntilTargetFrameEnd = targetNanosPerFrame - nanosElapsedSinceFrameStart;
            if(nanosUntilTargetFrameEnd > 0) {
                final long millisUntilTargetFrameEnd = (long) (nanosUntilTargetFrameEnd / Game.NANOS_PER_MILLI);
                try {
                    Thread.sleep(millisUntilTargetFrameEnd);
                } catch (final InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        inputController.removeInputEventHandler(this);
    }

    @Override
    public void handle(final InputEvent inputEvent) {
        switch (inputEvent) {
            case QUIT:
                keepRunning = false;
                break;
            case PAUSE:
                pause = !pause;
                break;
        }
    }

}

