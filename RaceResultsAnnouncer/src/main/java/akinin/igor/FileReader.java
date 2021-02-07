package akinin.igor;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

public class FileReader {

    public Stream<String> read(String fileName) throws FileNotFoundException {        
        if (fileName == null) {
            throw new IllegalArgumentException("You must input file name!");
        }        
        URL fileURL = this.getClass().getClassLoader().getResource(fileName);
        if (fileURL == null) {
            throw new FileNotFoundException("File \"" + fileName + "\" not found!");
        }
        try {
            Path path = Paths.get(fileURL.toURI());
            return Files.lines(path);
        } catch (IOException | URISyntaxException e) {
            throw new FileNotFoundException("File \"" + fileName + "\" not found!");
        }
    }
}