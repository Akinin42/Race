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
        startLines = createStartLines();
        finishLines = createFinishLines();
        abbreviationsLines = createAbbreviationsLines();
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

    private static List<String> createStartLines() {
        List<String> startLines = new ArrayList<>();
        startLines.add("SVF2018-05-24_12:02:58.917");
        startLines.add("NHR2018-05-24_12:02:49.914");
        startLines.add("FAM2018-05-24_12:13:04.512");
        startLines.add("KRF2018-05-24_12:03:01.250");
        startLines.add("SVM2018-05-24_12:18:37.735");
        startLines.add("MES2018-05-24_12:04:45.513");
        startLines.add("LSW2018-05-24_12:06:13.511");
        startLines.add("BHS2018-05-24_12:14:51.985");
        startLines.add("EOF2018-05-24_12:17:58.810");
        startLines.add("RGH2018-05-24_12:05:14.511");
        startLines.add("SSW2018-05-24_12:16:11.648");
        startLines.add("KMH2018-05-24_12:02:51.003");
        startLines.add("PGS2018-05-24_12:07:23.645");
        startLines.add("CSR2018-05-24_12:03:15.145");
        startLines.add("SPF2018-05-24_12:12:01.035");
        startLines.add("DRR2018-05-24_12:14:12.054");
        startLines.add("LHM2018-05-24_12:18:20.125");
        startLines.add("CLS2018-05-24_12:09:41.921");
        startLines.add("VBM2018-05-24_12:00:00.000");
        return startLines;
    }

    private static List<String> createFinishLines() {
        List<String> finishLines = new ArrayList<>();
        finishLines.add("MES2018-05-24_12:05:58.778");
        finishLines.add("RGH2018-05-24_12:06:27.441");
        finishLines.add("SPF2018-05-24_12:13:13.883");
        finishLines.add("LSW2018-05-24_12:07:26.834");
        finishLines.add("DRR2018-05-24_12:15:24.067");
        finishLines.add("NHR2018-05-24_12:04:02.979");
        finishLines.add("CSR2018-05-24_12:04:28.095");
        finishLines.add("KMH2018-05-24_12:04:04.396");
        finishLines.add("BHS2018-05-24_12:16:05.164");
        finishLines.add("SVM2018-05-24_12:19:50.198");
        finishLines.add("KRF2018-05-24_12:04:13.889");
        finishLines.add("VBM2018-05-24_12:01:12.434");
        finishLines.add("SVF2018-05-24_12:04:03.332");
        finishLines.add("EOF2018-05-24_12:19:11.838");
        finishLines.add("PGS2018-05-24_12:08:36.586");
        finishLines.add("SSW2018-05-24_12:17:24.354");
        finishLines.add("FAM2018-05-24_12:14:17.169");
        finishLines.add("CLS2018-05-24_12:10:54.750");
        finishLines.add("LHM2018-05-24_12:19:32.585");
        return finishLines;
    }

    private static List<String> createAbbreviationsLines() {
        List<String> abbreviationsLines = new ArrayList<>();
        abbreviationsLines.add("DRR_Daniel Ricciardo_RED BULL RACING TAG HEUER");
        abbreviationsLines.add("SVF_Sebastian Vettel_FERRARI");
        abbreviationsLines.add("LHM_Lewis Hamilton_MERCEDES");
        abbreviationsLines.add("KRF_Kimi Raikkonen_FERRARI");
        abbreviationsLines.add("VBM_Valtteri Bottas_MERCEDES");
        abbreviationsLines.add("EOF_Esteban Ocon_FORCE INDIA MERCEDES");
        abbreviationsLines.add("FAM_Fernando Alonso_MCLAREN RENAULT");
        abbreviationsLines.add("CSR_Carlos Sainz_RENAULT");
        abbreviationsLines.add("SPF_Sergio Perez_FORCE INDIA MERCEDES");
        abbreviationsLines.add("PGS_Pierre Gasly_SCUDERIA TORO ROSSO HONDA");
        abbreviationsLines.add("NHR_Nico Hulkenberg_RENAULT");
        abbreviationsLines.add("SVM_Stoffel Vandoorne_MCLAREN RENAULT");
        abbreviationsLines.add("SSW_Sergey Sirotkin_WILLIAMS MERCEDES");
        abbreviationsLines.add("CLS_Charles Leclerc_SAUBER FERRARI");
        abbreviationsLines.add("RGH_Romain Grosjean_HAAS FERRARI");
        abbreviationsLines.add("BHS_Brendon Hartley_SCUDERIA TORO ROSSO HONDA");
        abbreviationsLines.add("MES_Marcus Ericsson_SAUBER FERRARI");
        abbreviationsLines.add("LSW_Lance Stroll_WILLIAMS MERCEDES");
        abbreviationsLines.add("KMH_Kevin Magnussen_HAAS FERRARI");
        return abbreviationsLines;
    }
}