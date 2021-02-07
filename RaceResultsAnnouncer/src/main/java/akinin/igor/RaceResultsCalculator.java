package akinin.igor;

import java.io.FileNotFoundException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RaceResultsCalculator {

    public List<Racer> getRaceResult() {
        FileReader reader = new FileReader();
        Map<String, LocalDateTime> startTimes = parseTimesFile("start.log");
        Map<String, LocalDateTime> finishTimes = parseTimesFile("end.log");
        List<Racer> raceResult = new ArrayList<>();
        try {
            raceResult = reader.read("abbreviations.txt").map(s -> s.split("_"))
                    .map(s -> new Racer(s[1], s[2], Duration.between(startTimes.get(s[0]), finishTimes.get(s[0]))))
                    .collect(Collectors.toList());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return raceResult;
    }

    private Map<String, LocalDateTime> parseTimesFile(String fileName) {
        FileReader reader = new FileReader();
        Map<String, LocalDateTime> parsedResult = new HashMap<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss.SSS");
        try {
            parsedResult = reader.read(fileName).collect(
                    Collectors.toMap(s -> s.substring(0, 3), s -> LocalDateTime.parse(s.substring(3), formatter)));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return parsedResult;
    }
}