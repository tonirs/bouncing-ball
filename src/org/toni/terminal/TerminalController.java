package org.toni.terminal;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class TerminalController {

    private static String ttyConfiguration = null;

    public void loadTerminalConfiguration() {
        ttyConfiguration = stty("-g");
    }

    public void restoreTerminalConfiguration() {
        if(ttyConfiguration != null) {
            stty(ttyConfiguration.trim());
        }
    }

    public void setTerminalAsCharacterBuffered() {
        // Set the terminal to be character-buffered instead of line-buffered
        stty("-icanon min 1");

        // Disable character echoing
        stty("-echo");
    }

    private String stty(final String arguments) {
        final String command = "stty " + arguments + " < /dev/tty";
        try {
            return execute(new String[] {
                    "sh",
                    "-c",
                    command });
        } catch (final IOException e) {
            e.printStackTrace();
            return "IOException!";
        } catch (final InterruptedException e) {
            e.printStackTrace();
            return "InterruptedException!";
        }
    }

    private String execute(final String[] command) throws IOException, InterruptedException {
        Process process = Runtime.getRuntime().exec(command);

        InputStream inputStream = process.getInputStream();
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        int c;
        while((c = inputStream.read()) != -1) {
            outputStream.write(c);
        }

        inputStream = process.getErrorStream();

        while((c = inputStream.read()) != -1) {
            outputStream.write(c);
        }

        process.waitFor();

        final String result = new String(outputStream.toByteArray());
        return result;
    }

}

