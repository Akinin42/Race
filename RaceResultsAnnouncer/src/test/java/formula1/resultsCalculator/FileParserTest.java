package formula1.resultsCalculator;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class FileParserTest {

    private FileParser parser;

    @BeforeEach
    void init() {
        parser = new FileParser();
    }

    @Test
    void parse_ShouldThrowIllegalArgumentException_WhenTimeFileIncorrect() {
        assertThrows(IllegalArgumentException.class, () -> parser.parse("incorrecttimefile.log"));
    }

    @Test
    void parse_ShouldThrowIllegalArgumentException_WhenAbbreviationsFileIncorrect() {
        assertThrows(IllegalArgumentException.class, () -> parser.parse("incorrectabbreviations.txt"));
    }

    @Test
    void parse_ShouldReturnListStringsFromFile_WhenTimeFileCorrect() {
        String expected = "[SVF2018-05-24_12:02:58.917, NHR2018-05-24_12:02:49.914, FAM2018-05-24_12:13:04.512]";
        String actual = parser.parse("testfile.log").toString();
        assertEquals(expected, actual);
    }

    @Test
    void parse_ShouldReturnListStringsFromFile_WhenAbbreviationsFileCorrect() {
        String expected = "[DRR_Daniel Ricciardo_RED BULL RACING TAG HEUER, SVF_Sebastian Vettel_FERRARI]";
        String actual = parser.parse("abbreviationstest.txt").toString();
        assertEquals(expected, actual);
    }
}