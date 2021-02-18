package formula1.racecalculator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FileReaderTest {

    private FileReader reader;
    private static final String FILE_SUIT_PATTERN = "testfile.log";
    private static final String EMPTY_FILE = "emptyfile.log";
    private static final String NON_EXISTING_FILE = "nonexisting.log";
    private static final String FILE_NOT_SUIT_TIME_PATTERN = "notsuittimespattern.log";
    private static final String FILE_NOT_SUIT_ABBREVIATIONS_PATTERN = "notsuitabbreviationspattern.txt";

    @BeforeEach
    void init() {
        reader = new FileReader(new FileValidator());
    }

    @Test
    void read_ShouldReturnListStringsFromFile_WhenInputSuitFilePattern() {
        String expected = "[SVF2018-05-24_12:02:58.917, NHR2018-05-24_12:02:49.914, FAM2018-05-24_12:13:04.512]";
        String actual = reader.read(FILE_SUIT_PATTERN).toString();
        assertEquals(expected, actual);
    }

    @Test
    void read_ShouldReturnEmptyList_WhenInputEmptyFile() {
        List<String> actual = reader.read(EMPTY_FILE);
        assertTrue(actual.isEmpty());
    }

    @Test
    void read_ShouldThrowNoFileException_WhenInputNonExistingFile() {
        assertThrows(NoFileException.class, () -> reader.read(NON_EXISTING_FILE));
    }

    @Test
    void read_ShouldThrowIllegalArgumentException_WhenNull() {
        assertThrows(IllegalArgumentException.class, () -> reader.read(null));
    }

    @Test
    void read_ShouldThrowIllegalArgumentException_WhenInputNotSuitTimesPattern() {
        assertThrows(IllegalArgumentException.class, () -> reader.read(FILE_NOT_SUIT_TIME_PATTERN));
    }

    @Test
    void read_ShouldThrowIllegalArgumentException_WhenInputNotSuitAbbreviationsPattern() {
        assertThrows(IllegalArgumentException.class, () -> reader.read(FILE_NOT_SUIT_ABBREVIATIONS_PATTERN));
    }
}