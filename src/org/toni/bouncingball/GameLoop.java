package org.toni.bouncingball;

import java.io.IOException;
import java.io.InputStream;

public class GameLoop implements Runnable {

    private static final long NANOS_PER_MILLI = 1000000L;
    private static final long NANOS_PER_SECOND = 1000000000L;

    private boolean keepRunning = true;
    private boolean pause = false;

    private final double targetNanosPerFrame;

    private InputStream inputStream;

    private final GameUpdater gameUpdater;
    private final GameRenderer gameRenderer;

    public GameLoop(final int targetFps,
                    final InputStream inputStream,
                    final GameUpdater gameUpdater,
                    final GameRenderer gameRenderer) {
        this.targetNanosPerFrame = NANOS_PER_SECOND / (double) targetFps;
        this.inputStream = inputStream;
        this.gameUpdater = gameUpdater;
        this.gameRenderer = gameRenderer;
    }

    @Override
    public void run() {
        long lastFrameStartNanos = System.nanoTime();

        int frames = 0;
        long nanosElapsedSinceLastFPSReport = 0L;

        while(keepRunning) {
            updateRunFlagsIfInputAvailable();

            final long frameStartNanos = System.nanoTime();

            if(!pause) {
                // Calculate delta
                final long nanosElapsedSinceLastFrame = frameStartNanos - lastFrameStartNanos;
                lastFrameStartNanos = frameStartNanos;

                // Update frame counters and report FPS every second
                frames++;
                nanosElapsedSinceLastFPSReport += nanosElapsedSinceLastFrame;
                if (nanosElapsedSinceLastFPSReport >= NANOS_PER_SECOND) {
                    System.out.println("FPS: " + frames);
                    frames = 0;
                    nanosElapsedSinceLastFPSReport = 0L;
                }

                gameUpdater.update(nanosElapsedSinceLastFrame);

                gameRenderer.render();
            }

            // Wait until the target frame end
            final long frameEndNanos = System.nanoTime();
            final long nanosElapsedSinceFrameStart = frameEndNanos - frameStartNanos;
            final double nanosUntilTargetFrameEnd = targetNanosPerFrame - nanosElapsedSinceFrameStart;
            final long millisUntilTargetFrameEnd = (long)(nanosUntilTargetFrameEnd / NANOS_PER_MILLI);
            try {
                Thread.sleep(millisUntilTargetFrameEnd);
            } catch (final InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void updateRunFlagsIfInputAvailable() {
        try {
            if(inputStream.available() > 0) {
                final char key = (char)System.in.read();
                switch (key) {
                    case 's':
                    case 'S':
                        System.out.println("Stopping...");
                        keepRunning = false;
                        break;
                    case 'p':
                    case 'P':
                        System.out.println("Pausing/Resuming...");
                        pause = !pause;
                        break;
                }
            }
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

}

