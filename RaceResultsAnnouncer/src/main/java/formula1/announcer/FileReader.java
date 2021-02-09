package formula1.announcer;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReader {

    public List<String> read(String fileName) throws FileNotFoundException, MyURLException {
        if (fileName == null) {
            throw new IllegalArgumentException("File name can't be null!");
        }
        URL fileURL = this.getClass().getClassLoader().getResource(fileName);
        if (fileURL == null) {
            throw new MyURLException("File \"" + fileName + "\" not in resources!");
        }
        Path path = null;
        try {
            path = Paths.get(fileURL.toURI());
        } catch (URISyntaxException e1) {
            e1.printStackTrace();
        }
        try (Stream<String> stream = Files.lines(path)) {
            return stream.collect(Collectors.toList());
        } catch (IOException e) {
            throw new FileNotFoundException("File \"" + fileName + "\" not found!");
        }
    }
}