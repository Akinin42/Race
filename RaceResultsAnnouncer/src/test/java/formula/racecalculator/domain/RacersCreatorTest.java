package formula.racecalculator.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import formula.racecalculator.TestUtil;
import formula.racecalculator.models.Racer;

class RacersCreatorTest {

    private static RacersCreator creator;
    private static List<String> startLines;
    private static List<String> finishLines;
    private static List<String> abbreviationsLines;

    @BeforeAll
    static void init() {
        creator = new RacersCreator();
        startLines = TestUtil.createStartLines();
        finishLines = TestUtil.createFinishLines();
        abbreviationsLines = TestUtil.createAbbreviationsLines();
    }

    @Test
    void createRacers_ShouldReturnExpectedRacersList_WhenInputSuitPattern() {
        List<Racer> expected = TestUtil.createRacers();
        List<Racer> actual = creator.createRacers(startLines, finishLines, abbreviationsLines);
        assertEquals(expected, actual);
    }

    @Test
    void createRacers_ShouldThrowIllegalArgumentException_WhenInputNotSuitTimesPattern() {
        List<String> invalidStartLines = new ArrayList<>();
        invalidStartLines.add("12:17:58.810");
        assertThrows(IllegalArgumentException.class,
                () -> creator.createRacers(invalidStartLines, finishLines, abbreviationsLines));
    }

    @Test
    void createRacers_ShouldThrowIllegalArgumentException_WhenInputNotSuitAbbreviationsPattern() {
        List<String> invalidAbbreviationsLines = new ArrayList<>();
        invalidAbbreviationsLines.add("Daniel Ricciardo");
        assertThrows(IllegalArgumentException.class,
                () -> creator.createRacers(startLines, finishLines, invalidAbbreviationsLines));
    }
}