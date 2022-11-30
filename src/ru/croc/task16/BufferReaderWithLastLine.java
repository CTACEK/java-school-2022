package ru.croc.task16;

import java.io.BufferedReader;
import java.io.IOException;

public class BufferReaderWithLastLine {
    private final BufferedReader bufferedReader;
    private String lastLine;

    public BufferReaderWithLastLine(BufferedReader bufferedReader) {
        this.bufferedReader = bufferedReader;
    }

    public String readLine() throws IOException {
        lastLine = bufferedReader.readLine();
        return lastLine;
    }

    public String getLastLine() {
        return lastLine;
    }
}
