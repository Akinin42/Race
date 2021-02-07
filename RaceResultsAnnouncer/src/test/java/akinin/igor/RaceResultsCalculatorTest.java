package akinin.igor;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RaceResultsCalculatorTest {

    private RaceResultsCalculator calculator;

    @BeforeEach
    void createNewCalculator() {
        calculator = new RaceResultsCalculator();
    }

    @Test
    void getRaceResult_ShouldReturnExpectedRacersList() {
        String expected = "[Daniel Ricciardo,RED BULL RACING TAG HEUER,PT1M12.013S][Sebastian Vettel,FERRARI,PT1M4.415S]"
                + "[Lewis Hamilton,MERCEDES,PT1M12.46S][Kimi Raikkonen,FERRARI,PT1M12.639S][Valtteri Bottas,MERCEDES,PT1M12.434S]"
                + "[Esteban Ocon,FORCE INDIA MERCEDES,PT1M13.028S][Fernando Alonso,MCLAREN RENAULT,PT1M12.657S]"
                + "[Carlos Sainz,RENAULT,PT1M12.95S][Sergio Perez,FORCE INDIA MERCEDES,PT1M12.848S]"
                + "[Pierre Gasly,SCUDERIA TORO ROSSO HONDA,PT1M12.941S][Nico Hulkenberg,RENAULT,PT1M13.065S]"
                + "[Stoffel Vandoorne,MCLAREN RENAULT,PT1M12.463S][Sergey Sirotkin,WILLIAMS MERCEDES,PT1M12.706S]"
                + "[Charles Leclerc,SAUBER FERRARI,PT1M12.829S][Romain Grosjean,HAAS FERRARI,PT1M12.93S]"
                + "[Brendon Hartley,SCUDERIA TORO ROSSO HONDA,PT1M13.179S][Marcus Ericsson,SAUBER FERRARI,PT1M13.265S]"
                + "[Lance Stroll,WILLIAMS MERCEDES,PT1M13.323S][Kevin Magnussen,HAAS FERRARI,PT1M13.393S]";
        StringBuilder sb = new StringBuilder();
        calculator.getRaceResult().stream().forEach(
                racer -> sb.append(String.format("[%s,%s,%s]", racer.getName(), racer.getTeam(), racer.getLapTime())));
        String actual = sb.toString();
        assertEquals(expected, actual);
    }    
}