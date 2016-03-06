package org.toni.bouncingball.game.controller.input;

import org.toni.bouncingball.game.event.input.InputEvent;

import java.io.IOException;
import java.io.InputStream;

public class InputStreamInputController extends InputController {

    private final InputStream inputStream;

    public InputStreamInputController(final InputStream inputStream) {
        super();

        this.inputStream = inputStream;
    }

    @Override
    protected void generateInputEventsFromInput() {
        try {
            while(inputStream.available() > 0) {
                char key = (char)inputStream.read();
                switch (Character.toLowerCase(key)) {
                    case 'x':
                        inputEvents.add(InputEvent.X);
                        break;
                    case 'p':
                        inputEvents.add(InputEvent.P);
                        break;
                    case 'q':
                        inputEvents.add(InputEvent.Q);
                        break;
                    case 'a':
                        inputEvents.add(InputEvent.A);
                        break;
                    case '+':
                        inputEvents.add(InputEvent.PLUS);
                        break;
                    case '-':
                        inputEvents.add(InputEvent.MINUS);
                        break;
                }
            }
        } catch (final IOException e) {
            e.printStackTrace();
        }
    }

}

