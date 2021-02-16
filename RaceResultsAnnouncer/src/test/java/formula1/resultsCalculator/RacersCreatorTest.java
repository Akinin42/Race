package formula1.resultsCalculator;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RacersCreatorTest {

    private RacersCreator creator;

    @BeforeEach
    void init() {
        creator = new RacersCreator();
    }

    @Test
    void createRacers_ShouldReturnExpectedRacersList() {
        List<Racer> expected = new ArrayList<>();
        expected.add(new Racer("Daniel Ricciardo", "RED BULL RACING TAG HEUER", Duration.ofSeconds(72, 13000000)));
        expected.add(new Racer("Sebastian Vettel", "FERRARI", Duration.ofSeconds(64, 415000000)));
        expected.add(new Racer("Lewis Hamilton", "MERCEDES", Duration.ofSeconds(72, 460000000)));
        expected.add(new Racer("Kimi Raikkonen", "FERRARI", Duration.ofSeconds(72, 639000000)));
        expected.add(new Racer("Valtteri Bottas", "MERCEDES", Duration.ofSeconds(72, 434000000)));
        expected.add(new Racer("Esteban Ocon", "FORCE INDIA MERCEDES", Duration.ofSeconds(73, 28000000)));
        expected.add(new Racer("Fernando Alonso", "MCLAREN RENAULT", Duration.ofSeconds(72, 657000000)));
        expected.add(new Racer("Carlos Sainz", "RENAULT", Duration.ofSeconds(72, 950000000)));
        expected.add(new Racer("Sergio Perez", "FORCE INDIA MERCEDES", Duration.ofSeconds(72, 848000000)));
        expected.add(new Racer("Pierre Gasly", "SCUDERIA TORO ROSSO HONDA", Duration.ofSeconds(72, 941000000)));
        expected.add(new Racer("Nico Hulkenberg", "RENAULT", Duration.ofSeconds(73, 65000000)));
        expected.add(new Racer("Stoffel Vandoorne", "MCLAREN RENAULT", Duration.ofSeconds(72, 463000000)));
        expected.add(new Racer("Sergey Sirotkin", "WILLIAMS MERCEDES", Duration.ofSeconds(72, 706000000)));
        expected.add(new Racer("Charles Leclerc", "SAUBER FERRARI", Duration.ofSeconds(72, 829000000)));
        expected.add(new Racer("Romain Grosjean", "HAAS FERRARI", Duration.ofSeconds(72, 930000000)));
        expected.add(new Racer("Brendon Hartley", "SCUDERIA TORO ROSSO HONDA", Duration.ofSeconds(73, 179000000)));
        expected.add(new Racer("Marcus Ericsson", "SAUBER FERRARI", Duration.ofSeconds(73, 265000000)));
        expected.add(new Racer("Lance Stroll", "WILLIAMS MERCEDES", Duration.ofSeconds(73, 323000000)));
        expected.add(new Racer("Kevin Magnussen", "HAAS FERRARI", Duration.ofSeconds(73, 393000000)));
        List<Racer> actual = creator.createRacers("start.log", "end.log");
        assertIterableEquals(expected, actual);
    }
}