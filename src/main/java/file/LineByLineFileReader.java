package file;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Objects;
import java.util.stream.Collectors;

public class LineByLineFileReader {

    private final String fileName;

    public LineByLineFileReader(String fileName) {
        this.fileName = fileName;
    }


    public String readFile() {
        String content = "";

        try {
            URI uri = Objects.requireNonNull(getClass().getClassLoader().getResource(fileName)).toURI();
            Path path = Paths.get(uri);
            content = Files.lines(path).collect(Collectors.joining("\n"));
        } catch (IOException | URISyntaxException e) {
            e.printStackTrace();
        }

        return content;
    }
}
