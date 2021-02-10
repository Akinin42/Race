package formula1.announcer;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.io.IOException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import formula1.resultscounter.FileReader;
import formula1.resultscounter.MyRuntimeException;

class FileReaderTest {

    private FileReader reader;

    @BeforeEach
    void createNewFileReader() {
        reader = new FileReader();
    }

    @Test
    void read_ShouldReturnListStringsFromFile_WhenInputExistingFile() throws MyRuntimeException, IOException {
        String expected = "[SVF2018-05-24_12:02:58.917, NHR2018-05-24_12:02:49.914, FAM2018-05-24_12:13:04.512]";
        String actual = reader.read("testfile.log").toString();        
        assertEquals(expected, actual);
    }
    @Test
    void read_ShouldReturnListStringsFromFile_WhenInputSomeArticle() throws MyRuntimeException, IOException {
        String expected = "[SVF2018-05-24_12:02:58.917, SVF2018-05-24_12:02:58.917, SVF2018-05-24_12:02:58.917]";
        String actual = reader.read("somearticle.log").toString();        
        assertEquals(expected, actual);
    }
    @Test
    void read_ShouldReturnEmptyList_WhenInputEmptyFile() throws MyRuntimeException, IOException {
        String expected = "[]";
        String actual = reader.read("emptyfile.log").toString();        
        assertEquals(expected, actual);
    }

    @Test
    void read_ShouldThrowMyRuntimeException_WhenInputNonexistingFile() {
        assertThrows(MyRuntimeException.class, () -> reader.read("nonexistingname.log"));
    }

    @Test
    void read_ShouldThrowIllegalArgumentException_WhenNull() {
        assertThrows(IllegalArgumentException.class, () -> reader.read(null));
    }
}