package akinin.igor;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.FileNotFoundException;
import java.util.stream.Collectors;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FileReaderTest {

    private FileReader reader;

    @BeforeEach
    void createNewFileReader() {
        reader = new FileReader();
    }

    @Test
    void read_ShouldReturnStringStreamFromFile_WhenInputExistingFile() {
        String expected = "[SVF2018-05-24_12:02:58.917, NHR2018-05-24_12:02:49.914, FAM2018-05-24_12:13:04.512]";
        String actual = null;
        try {
            actual = reader.read("testfile.log").collect(Collectors.toList()).toString();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        assertEquals(expected, actual);
    }

    @Test
    void read_ShouldThrowFileNotFoundException_WhenInputUnexistingFile() {
        assertThrows(FileNotFoundException.class, () -> reader.read("unexistingname.log"));
    }

    @Test
    void read_ShouldThrowIllegalArgumentException_WhenInputNull() {
        assertThrows(IllegalArgumentException.class, () -> reader.read(null));
    }
}