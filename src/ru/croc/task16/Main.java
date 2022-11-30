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
        List<File> filesList = Files.walk(Paths.get("/Users/ctacek/IdeaProjects/java-school-2022/src/ru/croc/task16/dir1"))
                .filter(Files::isRegularFile)
                .map(Path::toFile)
                .collect(Collectors.toList());

        filesList.removeIf(tempFile -> !tempFile.getName().contains(".log") && !tempFile.getName().contains(".trace"));

        String dataSplitBy = "\\s";
        String line;
        Integer min;
        int timeLog;

        List<BufferReaderWithLastLine> bufferedReaders = new ArrayList<>();

        for (File file : filesList) {
            bufferedReaders.add(new BufferReaderWithLastLine(new BufferedReader(new FileReader(file))));
        }


        for (BufferReaderWithLastLine bufferedReader : bufferedReaders) {
            bufferedReader.readLine();
        }

        Iterator<BufferReaderWithLastLine> bufferReaderWithLastLineIterator;
        BufferReaderWithLastLine tempBufferReadder;
        BufferReaderWithLastLine minBuffer;

        while (!bufferedReaders.isEmpty()) {
            clearListBuffers(bufferedReaders);
            if (bufferedReaders.isEmpty()) break;

            bufferReaderWithLastLineIterator = bufferedReaders.iterator();

            minBuffer = bufferedReaders.get(0);
            min = Integer.parseInt(minBuffer.getLastLine().split(dataSplitBy)[0]);

            while (bufferReaderWithLastLineIterator.hasNext()) {

                tempBufferReadder = bufferReaderWithLastLineIterator.next();
                line = tempBufferReadder.getLastLine();
                String[] data = line.split(dataSplitBy);
                timeLog = Integer.parseInt(data[0]);

                if (timeLog < min) {
                    min = timeLog;
                    minBuffer = tempBufferReadder;
                }
            }
            System.out.println(minBuffer.getLastLine());
            minBuffer.readLine();

        }
    }

    static public void clearListBuffers(List<BufferReaderWithLastLine> bufferReaderWithLastLines){
        bufferReaderWithLastLines.removeIf(tempBuff -> tempBuff.getLastLine() == null);
    }
}
