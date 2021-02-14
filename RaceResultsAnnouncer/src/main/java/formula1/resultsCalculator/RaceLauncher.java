package formula1.resultsCalculator;

public class RaceLauncher {

    public static void main(String[] args) {
        RacersCreator creator = new RacersCreator();
        RacersFormatter formatter = new RacersFormatter();
        System.out.println(formatter.format(creator.createRacers("start.log", "end.log")));
    }
}