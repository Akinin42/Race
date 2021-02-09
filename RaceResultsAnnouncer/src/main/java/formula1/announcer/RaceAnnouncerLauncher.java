package formula1.announcer;

import java.io.FileNotFoundException;

public class RaceAnnouncerLauncher {

    public static void main(String[] args) {
        RacersCreator creator = new RacersCreator();
        RacersFormatter formatter = new RacersFormatter();
        try {
            System.out.println(formatter.format(creator.getRacers()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}