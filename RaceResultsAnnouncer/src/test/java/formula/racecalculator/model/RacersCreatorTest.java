package formula.racecalculator.model;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import formula.racecalculator.io.FileReader;

class RacersCreatorTest {

    private RacersCreator creator;
    private FileReader reader;
    List<String> contentStart;
    List<String> contentFinish;
    List<String> contentAbbreviations;
    private static final String FILE_NOT_SUIT_TIME_PATTERN = "notsuittimespattern.log";
    private static final String FILE_NOT_SUIT_ABBREVIATIONS_PATTERN = "notsuitabbreviationspattern.txt";

    @BeforeEach
    void init() {
        creator = new RacersCreator();
        reader = new FileReader();
        contentStart = reader.read("start.log");
        contentFinish = reader.read("end.log");
        contentAbbreviations = reader.read("abbreviations.txt");
    }

    @Test
    void createRacers_ShouldReturnExpectedRacersList_WhenInputFilesSuitPattern() {
        List<Racer> expected = createRacers();
        List<Racer> actual = creator.createRacers(contentStart, contentFinish, contentAbbreviations);
        assertTrue(racersEquals(expected, actual));
    }

    @Test
    void createRacers_ShouldThrowIllegalArgumentException_WhenInputNotSuitTimesPattern() {
        contentStart = reader.read(FILE_NOT_SUIT_TIME_PATTERN);
        assertThrows(IllegalArgumentException.class,
                () -> creator.createRacers(contentStart, contentFinish, contentAbbreviations));
    }

    @Test
    void createRacers_ShouldThrowIllegalArgumentException_WhenInputNotSuitAbbreviationsPattern() {
        contentAbbreviations = reader.read(FILE_NOT_SUIT_ABBREVIATIONS_PATTERN);
        assertThrows(IllegalArgumentException.class,
                () -> creator.createRacers(contentStart, contentFinish, contentAbbreviations));
    }

    private List<Racer> createRacers() {
        List<Racer> racers = new ArrayList<>();
        racers.add(new Racer("Daniel Ricciardo", "RED BULL RACING TAG HEUER", Duration.ofSeconds(72, 13000000)));
        racers.add(new Racer("Sebastian Vettel", "FERRARI", Duration.ofSeconds(64, 415000000)));
        racers.add(new Racer("Lewis Hamilton", "MERCEDES", Duration.ofSeconds(72, 460000000)));
        racers.add(new Racer("Kimi Raikkonen", "FERRARI", Duration.ofSeconds(72, 639000000)));
        racers.add(new Racer("Valtteri Bottas", "MERCEDES", Duration.ofSeconds(72, 434000000)));
        racers.add(new Racer("Esteban Ocon", "FORCE INDIA MERCEDES", Duration.ofSeconds(73, 28000000)));
        racers.add(new Racer("Fernando Alonso", "MCLAREN RENAULT", Duration.ofSeconds(72, 657000000)));
        racers.add(new Racer("Carlos Sainz", "RENAULT", Duration.ofSeconds(72, 950000000)));
        racers.add(new Racer("Sergio Perez", "FORCE INDIA MERCEDES", Duration.ofSeconds(72, 848000000)));
        racers.add(new Racer("Pierre Gasly", "SCUDERIA TORO ROSSO HONDA", Duration.ofSeconds(72, 941000000)));
        racers.add(new Racer("Nico Hulkenberg", "RENAULT", Duration.ofSeconds(73, 65000000)));
        racers.add(new Racer("Stoffel Vandoorne", "MCLAREN RENAULT", Duration.ofSeconds(72, 463000000)));
        racers.add(new Racer("Sergey Sirotkin", "WILLIAMS MERCEDES", Duration.ofSeconds(72, 706000000)));
        racers.add(new Racer("Charles Leclerc", "SAUBER FERRARI", Duration.ofSeconds(72, 829000000)));
        racers.add(new Racer("Romain Grosjean", "HAAS FERRARI", Duration.ofSeconds(72, 930000000)));
        racers.add(new Racer("Brendon Hartley", "SCUDERIA TORO ROSSO HONDA", Duration.ofSeconds(73, 179000000)));
        racers.add(new Racer("Marcus Ericsson", "SAUBER FERRARI", Duration.ofSeconds(73, 265000000)));
        racers.add(new Racer("Lance Stroll", "WILLIAMS MERCEDES", Duration.ofSeconds(73, 323000000)));
        racers.add(new Racer("Kevin Magnussen", "HAAS FERRARI", Duration.ofSeconds(73, 393000000)));
        return racers;
    }

    private boolean racersEquals(List<Racer> expected, List<Racer> actual) {
        boolean result = false;
        int equalsRacer = 0;
        for (int i = 0; i < expected.size(); i++) {
            if (expected.get(i).getName().equals(actual.get(i).getName())
                    && expected.get(i).getTeam().equals(actual.get(i).getTeam())
                    && expected.get(i).getLapTime().equals(actual.get(i).getLapTime())) {
                equalsRacer++;
            }
        }
        if (equalsRacer == expected.size()) {
            result = true;
        }
        return result;
    }
}