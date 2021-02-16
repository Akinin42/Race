package formula1.resultsCalculator;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RacersCreator {

    private static final String ABBREVIATIONS = "abbreviations.txt";
    private static final String UNDERSCORE = "_";
    private static final String DATE_PATTERN = "yyyy-MM-dd_HH:mm:ss.SSS";    

    public List<Racer> createRacers(String fileStart, String fileFinish) {
        FileParser parser = new FileParser();        
        Map<String, LocalDateTime> abbreviationsStartTime = getLapTimes(parser.parse(fileStart));
        Map<String, LocalDateTime> abbreviationsFinishTime = getLapTimes(parser.parse(fileFinish));
        return parser.parse(ABBREVIATIONS).stream()
                .map(s -> s.split(UNDERSCORE))
                .map(s -> new Racer(s[1], s[2],
                        Duration.between(abbreviationsStartTime.get(s[0]), abbreviationsFinishTime.get(s[0]))))
                .collect(Collectors.toList());
    }

    private Map<String, LocalDateTime> getLapTimes(List<String> contentFile) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_PATTERN);
        return contentFile.stream()
                .collect(Collectors.toMap(s -> s.substring(0, 3), s -> LocalDateTime.parse(s.substring(3), formatter)));
    }
}