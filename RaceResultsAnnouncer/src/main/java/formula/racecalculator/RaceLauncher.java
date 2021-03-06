package formula.racecalculator;

import java.util.List;
import formula.racecalculator.domain.RacersCreator;
import formula.racecalculator.domain.RacersFormatter;
import formula.racecalculator.io.FileReader;
import formula.racecalculator.models.Racer;

public class RaceLauncher {

    private static final String START_FILE = "start.log";
    private static final String FINISH_FILE = "end.log";
    private static final String ABBREVIATIONS_FILE = "abbreviations.txt";

    public static void main(String[] args) {
        FileReader reader = new FileReader();
        RacersCreator creator = new RacersCreator();
        RacersFormatter formatter = new RacersFormatter();
        List<String> startLines = reader.read(START_FILE);
        List<String> finishLines = reader.read(FINISH_FILE);
        List<String> abbreviationsLines = reader.read(ABBREVIATIONS_FILE);
        List<Racer> racers = creator.createRacers(startLines, finishLines, abbreviationsLines);
        System.out.println(formatter.createRaceTable(racers));
    }
}