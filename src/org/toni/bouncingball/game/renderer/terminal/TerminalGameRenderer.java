package org.toni.bouncingball.game.renderer.terminal;

import org.toni.bouncingball.game.renderer.GameRenderer;
import org.toni.terminal.TerminalController;

import java.util.Arrays;

public class TerminalGameRenderer extends GameRenderer<Character> {

    private TerminalController terminalController = new TerminalController();

    private final int screenWidth;
    private final int screenHeight;

    private final String horizontalLine;
    private final String header;

    public TerminalGameRenderer(final int gameAreaHeight, final int gameAreaWidth) {
        super(Character.class, gameAreaHeight, gameAreaWidth, ' ');

        screenWidth = gameAreaWidth + 2;
        screenHeight = gameAreaHeight + 2;

        header = new String("p/P (pause/resume), q/Q (quit)                                           FPS: ");

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
        super.render(fps);

        StringBuffer stringBuffer = new StringBuffer(header);
        stringBuffer.append(fps);
        System.out.println(stringBuffer.toString());

        System.out.println(horizontalLine);

        for (int y = 0; y < genericGameArea.getHeight(); ++y) {
            stringBuffer.setLength(0);
            stringBuffer.append('|');
            for (int x = 0; x < genericGameArea.getWidth(); ++x) {
                final Character[] line = genericGameArea.getGameArea()[y];
                stringBuffer.append(line[x].charValue());
            }
            stringBuffer.append('|');
            System.out.println(stringBuffer);
        }

        System.out.println(horizontalLine);
    }

}

