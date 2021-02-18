package formula1.racecalculator;

import static org.junit.Assert.assertEquals;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RacersCreatorTest {

    private RacersCreator creator;

    @BeforeEach
    void init() {
        creator = new RacersCreator(new FileReader(new FileValidator()));
    }

    @Test
    void createRacers_ShouldReturnExpectedRacersList() {
        List<Racer> expected = createRacers();
        List<Racer> actual = creator.createRacers("start.log", "end.log", "abbreviations.txt");
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i).getName(), actual.get(i).getName());
            assertEquals(expected.get(i).getTeam(), actual.get(i).getTeam());
            assertEquals(expected.get(i).getLapTime(), actual.get(i).getLapTime());
        }
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
}