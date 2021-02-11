package formula1.resultscounter;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReader {

    public List<String> read(String fileName) throws NoFileException {
        if (fileName == null) {
            throw new IllegalArgumentException("File name can't be null!");
        }
        URL fileURL = this.getClass().getClassLoader().getResource(fileName);
        if (fileURL == null) {
            throw new NoFileException("File \"" + fileName + "\" not in resources!");
        }
        try (Stream<String> fileLines = Files.lines(Paths.get(fileURL.toURI()))) {
            return fileLines.collect(Collectors.toList());
        } catch (URISyntaxException | IOException e1) {
            throw new NoFileException("File \"" + fileName + "\" not founded!");
        }
    }
}