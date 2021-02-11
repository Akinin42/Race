package formula1.resultscounter;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class RacersCreator {

    private static final String RACERS = "abbreviations.txt";
    private static final String UNDERSCORE = "_";
    private static final String DATE_PATTERN = "yyyy-MM-dd_HH:mm:ss.SSS";

    public List<Racer> getRacers(String fileStartTimes, String fileFinishTimes) {
        try {
            FileReader reader = new FileReader();
            Map<String, LocalDateTime> racerStartTimes = parseTimesFile(reader.read(fileStartTimes));
            Map<String, LocalDateTime> racerFinishTimes = parseTimesFile(reader.read(fileFinishTimes));
            return reader.read(RACERS).stream()
                    .map(s -> s.split(UNDERSCORE))
                    .map(s -> new Racer(s[1], s[2], Duration.between(racerStartTimes.get(s[0]), racerFinishTimes.get(s[0]))))
                    .collect(Collectors.toList());
        } catch (NoFileException e) {
            throw new NoFileException("File not founded!");
        }
    }

    private Map<String, LocalDateTime> parseTimesFile(List<String> inputFile) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_PATTERN);
        return inputFile.stream()
                .collect(Collectors.toMap(s -> s.substring(0, 3), s -> LocalDateTime.parse(s.substring(3), formatter)));
    }
}