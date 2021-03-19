package formula.racecalculator.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import formula.racecalculator.io.FileReader;
import formula.racecalculator.models.Racer;
import utils.TestUtil;

class RacersCreatorTest {

    private static RacersCreator creator;
    private static FileReader reader;
    private static final String START_FILE = "start.log";
    private static final String FINISH_FILE = "end.log";
    private static final String ABBREVIATIONS_FILE = "abbreviations.txt";
    private static List<String> contentStart;
    private static List<String> contentFinish;
    private static List<String> contentAbbreviations;

    @BeforeAll
    static void init() {
        creator = new RacersCreator();
        reader = new FileReader();
        contentStart = reader.read(START_FILE);
        contentFinish = reader.read(FINISH_FILE);
        contentAbbreviations = reader.read(ABBREVIATIONS_FILE);
    }

    @Test
    void createRacers_ShouldReturnExpectedRacersList_WhenInputFilesSuitPattern() {
        List<Racer> expected = TestUtil.createRacers();
        List<Racer> actual = creator.createRacers(contentStart, contentFinish, contentAbbreviations);
        assertEquals(expected, actual);
    }

    @Test
    void createRacers_ShouldThrowIllegalArgumentException_WhenInputNotSuitTimesPattern() {
        contentStart = TestUtil.createInvalidTimeLines();
        assertThrows(IllegalArgumentException.class,
                () -> creator.createRacers(contentStart, contentFinish, contentAbbreviations));
    }

    @Test
    void createRacers_ShouldThrowIllegalArgumentException_WhenInputNotSuitAbbreviationsPattern() {
        contentAbbreviations = TestUtil.createInvalidAbbreviationsLines();
        assertThrows(IllegalArgumentException.class,
                () -> creator.createRacers(contentStart, contentFinish, contentAbbreviations));
    }
}