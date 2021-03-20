package formula.racecalculator;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import formula.racecalculator.models.Racer;

public class TestUtil {

    public static List<Racer> createRacers() {
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

    public static List<String> createStartLines() {
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

    public static List<String> createFinishLines() {
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

    public static List<String> createAbbreviationsLines() {
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