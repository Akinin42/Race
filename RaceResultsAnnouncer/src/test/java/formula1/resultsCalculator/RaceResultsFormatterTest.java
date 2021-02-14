package formula1.resultsCalculator;

import static org.junit.Assert.assertEquals;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RaceResultsFormatterTest {

    private RacersCreator creator;
    private RacersFormatter formatter;

    @BeforeEach
    void createNewFormatter() {
        formatter = new RacersFormatter();
        creator = new RacersCreator();
    }

    @Test
    void format_ShouldReturnFormattedResult_WhenInputRacersList() {
        String expected = "01.Sebastian Vettel  | FERRARI                   | 1:04.415\r\n"
                + "02.Daniel Ricciardo  | RED BULL RACING TAG HEUER | 1:12.013\r\n"
                + "03.Valtteri Bottas   | MERCEDES                  | 1:12.434\r\n"
                + "04.Lewis Hamilton    | MERCEDES                  | 1:12.460\r\n"
                + "05.Stoffel Vandoorne | MCLAREN RENAULT           | 1:12.463\r\n"
                + "06.Kimi Raikkonen    | FERRARI                   | 1:12.639\r\n"
                + "07.Fernando Alonso   | MCLAREN RENAULT           | 1:12.657\r\n"
                + "08.Sergey Sirotkin   | WILLIAMS MERCEDES         | 1:12.706\r\n"
                + "09.Charles Leclerc   | SAUBER FERRARI            | 1:12.829\r\n"
                + "10.Sergio Perez      | FORCE INDIA MERCEDES      | 1:12.848\r\n"
                + "11.Romain Grosjean   | HAAS FERRARI              | 1:12.930\r\n"
                + "12.Pierre Gasly      | SCUDERIA TORO ROSSO HONDA | 1:12.941\r\n"
                + "13.Carlos Sainz      | RENAULT                   | 1:12.950\r\n"
                + "14.Esteban Ocon      | FORCE INDIA MERCEDES      | 1:13.028\r\n"
                + "15.Nico Hulkenberg   | RENAULT                   | 1:13.065\r\n"
                + "-----------------------------------------------------------\n"
                + "16.Brendon Hartley   | SCUDERIA TORO ROSSO HONDA | 1:13.179\r\n"
                + "17.Marcus Ericsson   | SAUBER FERRARI            | 1:13.265\r\n"
                + "18.Lance Stroll      | WILLIAMS MERCEDES         | 1:13.323\r\n"
                + "19.Kevin Magnussen   | HAAS FERRARI              | 1:13.393\r\n";
        List<Racer> racers = creator.createRacers("start.log", "end.log");
        String actual = formatter.format(racers);
        assertEquals(expected, actual);
    }

    @Test
    void format_ShouldReturnFormattedResult_WhenInputSomeRacers() {
        String expected = "01.Sebastian Vettel | FERRARI | 1:04.415\r\n"
                + "02.Sebastian Vettel | FERRARI | 1:04.415\r\n"
                + "03.Sebastian Vettel | FERRARI | 1:04.415\r\n";
        List<Racer> racers = new ArrayList<>();
        racers.add(new Racer("Sebastian Vettel", "FERRARI", Duration.ofSeconds(64, 415000000)));
        racers.add(new Racer("Sebastian Vettel", "FERRARI", Duration.ofSeconds(64, 415000000)));
        racers.add(new Racer("Sebastian Vettel", "FERRARI", Duration.ofSeconds(64, 415000000)));
        String actual = formatter.format(racers);
        assertEquals(expected, actual);
    }
}