package formula1.resultscounter;

import java.io.IOException;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class RacersCreator {

    private static final String START = "start.log";
    private static final String END = "end.log";
    private static final String RACERS = "abbreviations.txt";
    private static final String UNDERSCORE = "_";
    private static final String DATE_PATTERN = "yyyy-MM-dd_HH:mm:ss.SSS";
    private static Logger logger = Logger.getLogger(RacersCreator.class.getName());

    public List<Racer> getRacers() {
        List<Racer> racers = new ArrayList<>();
        try {
            FileReader reader = new FileReader();
            Map<String, LocalDateTime> startTimes = parseTimesFile(reader.read(START));
            Map<String, LocalDateTime> finishTimes = parseTimesFile(reader.read(END));
            racers = reader.read(RACERS).stream()
                    .map(s -> s.split(UNDERSCORE))
                    .map(s -> new Racer(s[1], s[2], Duration.between(startTimes.get(s[0]), finishTimes.get(s[0]))))
                    .collect(Collectors.toList());
        } catch (MyRuntimeException | IOException e) {
            logger.log(Level.SEVERE, "Exception: ", e);
        }        
        return racers;        
    }

    private Map<String, LocalDateTime> parseTimesFile(List<String> inputFile) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_PATTERN);
        return inputFile.stream()
                .collect(Collectors.toMap(s -> s.substring(0, 3), s -> LocalDateTime.parse(s.substring(3), formatter)));
    }
}