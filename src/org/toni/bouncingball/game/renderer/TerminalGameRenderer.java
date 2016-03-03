package org.toni.bouncingball.game.renderer;

import org.toni.bouncingball.game.GameRenderer;
import org.toni.terminal.TerminalController;

import java.util.Arrays;

public class TerminalGameRenderer implements GameRenderer {

    private TerminalController terminalController = new TerminalController();

    private final int gameAreaWidth;
    private final int gameAreaHeight;

    private final int screenWidth;
    private final int screenHeight;

    private final String horizontalLine;
    private final String header;

    public TerminalGameRenderer(final int gameAreaWidth, final int gameAreaHeight) {
        this.gameAreaWidth = gameAreaWidth;
        this.gameAreaHeight = gameAreaHeight;
        screenWidth = gameAreaWidth + 2;
        screenHeight = gameAreaHeight + 2;

        header = new String("p/P (pause/resume), s/S (stop)                                           FPS: ");

        char[] horizontalLineAsArray = new char[screenWidth];
        Arrays.fill(horizontalLineAsArray, '-');
        horizontalLine = new String(horizontalLineAsArray);

    }

    @Override
    public void setUp() {
        terminalController.loadTerminalConfiguration();
        terminalController.setTerminalAsCharacterBuffered();
    }

    @Override
    public void cleanUp() {
        terminalController.restoreTerminalConfiguration();
    }

    public void render(final int fps) {
        char[][] gameArea = createGameArea();

//        renderables.render(gameArea, GAME_AREA_WIDTH, GAME_AREA_HEIGHT);
        gameArea[(int)(Math.random() * gameAreaHeight)][(int)(Math.random() * gameAreaWidth)] = '*';

        StringBuffer stringBuffer = new StringBuffer(header);
        stringBuffer.append(fps);
        System.out.println(stringBuffer.toString());

        System.out.println(horizontalLine);

        for (int y = 0 ; y < gameAreaHeight ; ++y) {
            stringBuffer.setLength(0);
            stringBuffer.append('|');
            stringBuffer.append(gameArea[y]);
            stringBuffer.append('|');
            System.out.println(stringBuffer);
        }

        System.out.println(horizontalLine);
    }

    private char[][] createGameArea() {
        char[][] gameArea = new char[gameAreaHeight][gameAreaWidth];
        for (int y = 0 ; y < gameAreaHeight ; ++y) {
            Arrays.fill(gameArea[y], ' ');
        }
        return gameArea;
    }

}

