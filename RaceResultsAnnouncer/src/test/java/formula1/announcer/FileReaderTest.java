package formula1.announcer;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.FileNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FileReaderTest {

    private FileReader reader;

    @BeforeEach
    void createNewFileReader() {
        reader = new FileReader();
    }

    @Test
    void read_ShouldReturnListStringsFromFile_WhenInputExistingFile() {
        String expected = "[SVF2018-05-24_12:02:58.917, NHR2018-05-24_12:02:49.914, FAM2018-05-24_12:13:04.512]";
        String actual = null;
        try {
            actual = reader.read("testfile.log").toString();
        } catch (FileNotFoundException | MyURLException e) {
            e.printStackTrace();
        }
        assertEquals(expected, actual);
    }

    @Test
    void read_ShouldThrowMyURLException_WhenInputUnexistingFile() {
        assertThrows(MyURLException.class, () -> reader.read("unexistingname.log"));
    }

    @Test
    void read_ShouldThrowIllegalArgumentException_WhenInputNull() {
        assertThrows(IllegalArgumentException.class, () -> reader.read(null));
    }
}