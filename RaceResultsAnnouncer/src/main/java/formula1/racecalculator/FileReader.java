package formula1.racecalculator;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReader {
    
    private FileValidator validator;

    public FileReader(FileValidator validator) {        
        this.validator = validator;
    }

    public List<String> read(String fileName) {
        if (fileName == null) {
            throw new IllegalArgumentException("File name can't be null!");
        }
        URL fileURL = getClass().getClassLoader().getResource(fileName);
        if (fileURL == null) {
            throw new NoFileException("File \"" + fileName + "\" not in resources!");
        }
        try (Stream<String> fileLines = Files.lines(Paths.get(fileURL.toURI()))) {
            return validator.validate(fileLines.collect(Collectors.toList()));
        } catch (URISyntaxException | IOException e) {
            throw new NoFileException("File \"" + fileName + "\" not found!", e);
        }
    }
}