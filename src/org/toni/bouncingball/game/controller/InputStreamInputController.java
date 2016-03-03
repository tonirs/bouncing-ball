package org.toni.bouncingball.game.controller;

import org.toni.bouncingball.game.InputController;

import java.io.IOException;
import java.io.InputStream;
import java.util.EnumSet;
import java.util.Set;

public class InputStreamInputController implements InputController {

    private enum Command {
        QUIT,
        PAUSE
    }

    private final InputStream inputStream;

    private final Set<Command> commands;

    public InputStreamInputController(final InputStream inputStream) {
        this.inputStream = inputStream;
        commands = EnumSet.noneOf(Command.class);
    }

    @Override
    public void read() {
        commands.clear();

        try {
            while(inputStream.available() > 0) {
                char key = (char)inputStream.read();
                switch (key) {
                    case 'q':
                    case 'Q':
                        commands.add(Command.QUIT);
                        break;
                    case 'p':
                    case 'P':
                        commands.add(Command.PAUSE);
                        break;
                }
            }
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean hasQuitBeenInput() {
        return commands.remove(Command.QUIT);
    }

    @Override
    public boolean hasPauseBeenInput() {
        return commands.remove(Command.PAUSE);
    }

}

