package org.toni.bouncingball.game.renderer.terminal;

import org.toni.bouncingball.game.renderer.GameRenderer;
import org.toni.terminal.TerminalController;

import java.util.Arrays;

public class TerminalGameRenderer extends GameRenderer<TerminalRenderArea> {

    private TerminalController terminalController = new TerminalController();

    private final int screenWidth;
    private final int screenHeight;

    private final String horizontalLine;
    private final String headerFormat;

    public TerminalGameRenderer(final int renderAreaHeight, final int renderAreaWidth) {
        super(new TerminalRenderArea(renderAreaHeight, renderAreaWidth, ' '));

        screenWidth = renderAreaWidth + 2;
        screenHeight = renderAreaHeight + 2;

        headerFormat = new String("FPS: %2d, up; q/Q, down: a/A, pause/resume: p/P, exit: x/X\n");

        char[] horizontalLineAsArray = new char[screenWidth];
        Arrays.fill(horizontalLineAsArray, '-');
        horizontalLine = new String(horizontalLineAsArray);
    }

    @Override
    public void setUp() {
        super.setUp();

        terminalController.loadTerminalConfiguration();
        terminalController.setTerminalAsCharacterBuffered();
    }

    @Override
    public void cleanUp() {
        super.cleanUp();

        terminalController.restoreTerminalConfiguration();
    }

    @Override
    public void render(final int fps) {
        renderArea.clear();

        super.render(fps);

        System.out.printf(headerFormat, fps);

        System.out.println(horizontalLine);

        for (int y = 0; y < renderArea.getHeight(); ++y) {
            StringBuffer stringBuffer = new StringBuffer("|");
            for (int x = 0; x < renderArea.getWidth(); ++x) {
                final char[] line = renderArea.getRenderArea()[y];
                stringBuffer.append(line[x]);
            }
            stringBuffer.append('|');
            System.out.println(stringBuffer);
        }

        System.out.println(horizontalLine);
    }

}

