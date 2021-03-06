package formula.racecalculator.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import formula.racecalculator.TestUtil;
import formula.racecalculator.models.Racer;

class RacersFormatterTest {

    private static RacersFormatter formatter;

    @BeforeAll
    static void init() {
        formatter = new RacersFormatter();
    }

    @Test
    void createRaceTable_ShouldReturnFormattedResult_WhenInputRacers() {
        String expected = "01.Sebastian Vettel |FERRARI                  |1:04.415\r\n"
                + "02.Daniel Ricciardo |RED BULL RACING TAG HEUER|1:12.013\r\n"
                + "03.Valtteri Bottas  |MERCEDES                 |1:12.434\r\n"
                + "04.Lewis Hamilton   |MERCEDES                 |1:12.460\r\n"
                + "05.Stoffel Vandoorne|MCLAREN RENAULT          |1:12.463\r\n"
                + "06.Kimi Raikkonen   |FERRARI                  |1:12.639\r\n"
                + "07.Fernando Alonso  |MCLAREN RENAULT          |1:12.657\r\n"
                + "08.Sergey Sirotkin  |WILLIAMS MERCEDES        |1:12.706\r\n"
                + "09.Charles Leclerc  |SAUBER FERRARI           |1:12.829\r\n"
                + "10.Sergio Perez     |FORCE INDIA MERCEDES     |1:12.848\r\n"
                + "11.Romain Grosjean  |HAAS FERRARI             |1:12.930\r\n"
                + "12.Pierre Gasly     |SCUDERIA TORO ROSSO HONDA|1:12.941\r\n"
                + "13.Carlos Sainz     |RENAULT                  |1:12.950\r\n"
                + "14.Esteban Ocon     |FORCE INDIA MERCEDES     |1:13.028\r\n"
                + "15.Nico Hulkenberg  |RENAULT                  |1:13.065\r\n"
                + "-------------------------------------------------------\n"
                + "16.Brendon Hartley  |SCUDERIA TORO ROSSO HONDA|1:13.179\r\n"
                + "17.Marcus Ericsson  |SAUBER FERRARI           |1:13.265\r\n"
                + "18.Lance Stroll     |WILLIAMS MERCEDES        |1:13.323\r\n"
                + "19.Kevin Magnussen  |HAAS FERRARI             |1:13.393\r\n";
        List<Racer> racers = TestUtil.createRacers();
        String actual = formatter.createRaceTable(racers);
        assertEquals(expected, actual);
    }

    @Test
    void createRaceTable_ShouldReturnEmptyString_WhenInputEmpty() {
        String expected = "";
        String actual = formatter.createRaceTable(new ArrayList<>());
        assertEquals(expected, actual);
    }

    @Test
    void createRaceTable_ShouldThrowIllegalArgumentException_WhenInputNull() {
        assertThrows(IllegalArgumentException.class, () -> formatter.createRaceTable(null));
    }

    @Test
    void createRaceTable_ShouldThrowNullPointerException_WhenInputInvalidRacers() {
        List<Racer> invalidRacers = new ArrayList<>();
        invalidRacers.add(new Racer(null, null, null));
        assertThrows(NullPointerException.class, () -> formatter.createRaceTable(invalidRacers));
    }
}