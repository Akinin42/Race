package formula.racecalculator.ui;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import formula.racecalculator.domain.Racer;

class RaceFormatterTest {

    private RacersFormatter formatter;

    @BeforeEach
    void init() {
        formatter = new RacersFormatter();
    }

    @Test
    void formatRace_ShouldReturnFormattedResult_WhenInputRacersList() {
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
        String actual = formatter.formatRace(createRacers());
        assertEquals(expected, actual);
    }

    @Test
    void formatRace_ShouldReturnFormattedResult_WhenInputContainsCyrillicLetters() {
        String expected = "01.Игорь Петров |ГАЗ  |1:04.415\r\n" 
                + "02.Сергей Иванов|ВОЛГА|1:12.013\r\n"
                + "03.Изя Робинович|КАМАЗ|1:12.434\r\n";
        String actual = formatter.formatRace(createRacersContainsCyrillicLetters());
        assertEquals(expected, actual);
    }

    @Test
    void formatRace_ShouldThrowIllegalArgumentException_WhenInputEmpty() {
        List<Racer> racers = new ArrayList<>();
        assertThrows(IllegalArgumentException.class, () -> formatter.formatRace(racers));
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

    private List<Racer> createRacersContainsCyrillicLetters() {
        List<Racer> racers = new ArrayList<>();
        racers.add(new Racer("Игорь Петров", "ГАЗ", Duration.ofSeconds(64, 415000000)));
        racers.add(new Racer("Сергей Иванов", "ВОЛГА", Duration.ofSeconds(72, 13000000)));
        racers.add(new Racer("Изя Робинович", "КАМАЗ", Duration.ofSeconds(72, 434000000)));
        return racers;
    }
}