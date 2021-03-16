package formula.racecalculator.domain;

import java.util.List;

import formula.racecalculator.io.FileReader;
import formula.racecalculator.model.Racer;

public class RaceLauncher {

    public static void main(String[] args) {
        FileReader reader = new FileReader();
        RacersCreator creator = new RacersCreator();
        RacersFormatter formatter = new RacersFormatter();
        List<String> contentStart = reader.read("start.log");
        List<String> contentFinish = reader.read("end.log");
        List<String> contentAbbreviations = reader.read("abbreviations.txt");
        List<Racer> racers = creator.createRacers(contentStart, contentFinish, contentAbbreviations);
        System.out.println(formatter.formatRace(racers));
    }
}