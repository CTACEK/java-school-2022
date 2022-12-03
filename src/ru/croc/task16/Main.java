package ru.croc.task16;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws IOException {
        String dataSplitBy = "\\s";
        String path = "/Users/ctacek/IdeaProjects/java-school-2022/src/ru/croc/task16/dir1";

        List<BufferReaderWithLastLine> bufferedReaders = new ArrayList<>();

        for (File file : takeAllLogAndTraceFiles(path)) {
            bufferedReaders.add(new BufferReaderWithLastLine(new BufferedReader(new FileReader(file))));
        }


        for (BufferReaderWithLastLine bufferedReader : bufferedReaders) {
            bufferedReader.readLine();
        }


        while (!bufferedReaders.isEmpty()) {
            clearListBuffers(bufferedReaders);
            if (bufferedReaders.isEmpty()) break;

            Iterator<BufferReaderWithLastLine> bufferReaderWithLastLineIterator = bufferedReaders.iterator();

            BufferReaderWithLastLine minBuffer = bufferedReaders.get(0);
            long min = Long.parseLong(minBuffer.getLastLine().split(dataSplitBy)[0]);

            while (bufferReaderWithLastLineIterator.hasNext()) {

                BufferReaderWithLastLine tempBufferReader = bufferReaderWithLastLineIterator.next();
                String line = tempBufferReader.getLastLine();
                String[] data = line.split(dataSplitBy);
                long timeLog = Integer.parseInt(data[0]);

                if (timeLog < min) {
                    min = timeLog;
                    minBuffer = tempBufferReader;
                }
            }
            System.out.println(minBuffer.getLastLine());
            minBuffer.readLine();

        }
    }

    static public void clearListBuffers(List<BufferReaderWithLastLine> bufferReaderWithLastLines) throws IOException {

        Iterator<BufferReaderWithLastLine> bufferReaderWithLastLineIterator = bufferReaderWithLastLines.iterator();

        while (bufferReaderWithLastLineIterator.hasNext()){
            BufferReaderWithLastLine tempBuff = bufferReaderWithLastLineIterator.next();
            if (tempBuff.getLastLine() == null) {
                tempBuff.getBufferedReader().close();
                bufferReaderWithLastLineIterator.remove();
            }
        }
    }

    static public List<File> takeAllLogAndTraceFiles(String path) throws IOException {
        List<File> filesList = Files.walk(Paths
                        .get(path))
                .filter(Files::isRegularFile)
                .map(Path::toFile)
                .collect(Collectors.toList());

        filesList.removeIf(tempFile -> !tempFile.getName().toLowerCase().endsWith(".log") && !tempFile.getName().toLowerCase().endsWith(".trace"));
        return filesList;
    }
}
