package formula1.resultsCalculator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FileReaderTest {

    private FileReader reader;

    @BeforeEach
    void init() {
        reader = new FileReader();
    }

    @Test
    void read_ShouldReturnListStringsFromFile_WhenInputExistingFile() {
        String expected = "[SVF2018-05-24_12:02:58.917, NHR2018-05-24_12:02:49.914, FAM2018-05-24_12:13:04.512]";
        String actual = reader.read("testfile.log").toString();
        assertEquals(expected, actual);
    }

    @Test
    void read_ShouldReturnEmptyList_WhenInputEmptyFile() {
        List<String> actual = reader.read("emptyfile.log");
        assertTrue(actual.isEmpty());
    }

    @Test
    void read_ShouldThrowNoFileException_WhenInputNonExistingFile() {
        assertThrows(NoFileException.class, () -> reader.read("nonexistingname.log"));
    }

    @Test
    void read_ShouldThrowIllegalArgumentException_WhenNull() {
        assertThrows(IllegalArgumentException.class, () -> reader.read(null));
    }
}