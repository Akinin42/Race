package formula1.announcer;

import java.io.FileNotFoundException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RacersCreator {

    private static final String LAP_START = "start.log";
    private static final String LAP_FINISH = "end.log";
    private static final String RACERS = "abbreviations.txt";

    public List<Racer> getRacers() throws FileNotFoundException {
        FileReader reader = new FileReader();
        List<Racer> racers = new ArrayList<>();
        try {
            Map<String, LocalDateTime> startTimes = parseTimesFile(reader.read(LAP_START));
            Map<String, LocalDateTime> finishTimes = parseTimesFile(reader.read(LAP_FINISH));
            racers = reader.read(RACERS).stream()
                    .map(s -> s.split("_"))
                    .map(s -> new Racer(s[1], s[2], Duration.between(startTimes.get(s[0]), finishTimes.get(s[0]))))
                    .collect(Collectors.toList());
        } catch (FileNotFoundException | MyURLException e) {
            throw new FileNotFoundException("File not found!");
        }
        return racers;
    }

    private Map<String, LocalDateTime> parseTimesFile(List<String> inputFile) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH:mm:ss.SSS");
        return inputFile.stream()
                .collect(Collectors.toMap(s -> s.substring(0, 3), s -> LocalDateTime.parse(s.substring(3), formatter)));
    }
}