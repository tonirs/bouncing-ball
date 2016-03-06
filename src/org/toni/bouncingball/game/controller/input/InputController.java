package org.toni.bouncingball.game.controller.input;

import org.toni.bouncingball.game.event.input.InputEvent;
import org.toni.bouncingball.game.event.input.InputEventHandler;
import org.toni.bouncingball.game.updater.GameUpdater;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

public abstract class InputController implements GameUpdater {

    private List<InputEventHandler> inputEventHandlers = new ArrayList<>();

    protected Set<InputEvent> inputEvents = EnumSet.noneOf(InputEvent.class);

    @Override
    public void setUp() {
        inputEventHandlers = new ArrayList<>();
        inputEvents = EnumSet.noneOf(InputEvent.class);
    }

    @Override
    public void cleanUp() {
        inputEvents.clear();
        inputEventHandlers.clear();
    }

    @Override
    public void update(final long deltaInNanos) {
        inputEvents.clear();

        generateInputEventsFromInput();

        for (final InputEvent inputEvent : inputEvents) {
            for (final InputEventHandler inputEventHandler : inputEventHandlers) {
                inputEventHandler.handle(inputEvent);
            }
        }
    }

    protected abstract void generateInputEventsFromInput();

    public void addInputEventHandler(final InputEventHandler inputEventHandler) {
        inputEventHandlers.add(inputEventHandler);
    }

    public void removeInputEventHandler(final InputEventHandler inputEventHandler) {
        inputEventHandlers.remove(inputEventHandler);
    }

}

