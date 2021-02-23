package formula.racecalculator.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import formula.racecalculator.domain.exception.NoFileException;

class FileReaderTest {

    private FileReader reader;
    private static final String FILE_SUIT_PATTERN = "testfile.log";
    private static final String FILE_NOT_SUIT_PATTERN = "testfilenotpattern.log";
    private static final String EMPTY_FILE = "emptyfile.log";
    private static final String NON_EXISTING_FILE = "nonexisting.log";

    @BeforeEach
    void init() {
        reader = new FileReader();
    }

    @Test
    void read_ShouldReturnListStringsFromFile_WhenInputFileSuitPattern() {
        List<String> expected = new ArrayList<String>();
        expected.add("SVF2018-05-24_12:02:58.917");
        expected.add("NHR2018-05-24_12:02:49.914");
        expected.add("FAM2018-05-24_12:13:04.512");
        List<String> actual = reader.read(FILE_SUIT_PATTERN);
        assertEquals(expected, actual);
    }
    @Test
    void read_ShouldReturnListStringsFromFile_WhenInputFileContainsLineNotSuitPattern() {
        List<String> expected = new ArrayList<String>();
        expected.add("any text isn't suit pattern");
        expected.add("but this reader can read it");        
        List<String> actual = reader.read(FILE_NOT_SUIT_PATTERN);
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
}