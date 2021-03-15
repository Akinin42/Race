package formula.racecalculator.ui;

import formula.racecalculator.io.FileReader;
import formula.racecalculator.model.RacersCreator;

public class RaceLauncher {

    public static void main(String[] args) {
        FileReader reader = new FileReader();
        RacersCreator creator = new RacersCreator();
        RacersFormatter formatter = new RacersFormatter();
        System.out.println(formatter.formatRace(creator.createRacers(reader.read("start.log"), reader.read("end.log"), reader.read("abbreviations.txt"))));
    }
}