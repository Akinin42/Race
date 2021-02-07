package akinin.igor;

public class RaceResultsLauncher {

    public static void main(String[] args) {
        RaceResultsCalculator calculator = new RaceResultsCalculator();
        RaceResultsFormatter formatter = new RaceResultsFormatter();        
        System.out.println(formatter.format(calculator.getRaceResult()));
       
    }
}