package formula1.resultscounter;

public class RacersResultsLauncher {

    public static void main(String[] args) {
        RacersCreator creator = new RacersCreator();
        RacersFormatter formatter = new RacersFormatter();
        System.out.println(formatter.format(creator.getRacers()));
    }
}