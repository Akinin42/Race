package formula1.racecalculator;

public class RaceLauncher {

    public static void main(String[] args) {
        RacersCreator creator = new RacersCreator(new FileReader(new FileValidator()));
        RacersFormatter formatter = new RacersFormatter();
        System.out.println(formatter.formatRace(creator.createRacers("start.log", "end.log", "abbreviations.txt")));
    }
}