package formula.racecalculator.ui;

import formula.racecalculator.dao.FileReader;
import formula.racecalculator.domain.RacersCreator;

public class RaceLauncher {

    public static void main(String[] args) {        
        RacersCreator creator = new RacersCreator(new FileReader());
        RacersFormatter formatter = new RacersFormatter();
        System.out.println(formatter.formatRace(creator.getRacers("start.log", "end.log", "abbreviations.txt")));
    }
}