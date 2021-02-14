package formula1.resultsCalculator;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class RacersCreator {

    private static final String RACERS = "abbreviations.txt";
    private static final String UNDERSCORE = "_";
    private static final String DATE_PATTERN = "yyyy-MM-dd_HH:mm:ss.SSS";
    private static final String TIMES_FILE_PATTERN = "[A-Z]{3}[0-9]{4}\\S[0-9]{2}\\S[0-9]{2}\\S"
            + "[0-9]{2}\\S[0-9]{2}\\S[0-9]{2}\\S[0-9]{3}";

    public List<Racer> createRacers(String fileStart, String fileFinish) {
        if (fileStart == null || fileFinish == null) {
            throw new IllegalArgumentException("File name can't be null!");
        }
        FileReader reader = new FileReader();
        Map<String, LocalDateTime> abbreviationsStartTime = parseTimesFile(fileStart);
        Map<String, LocalDateTime> abbreviationsFinishTime = parseTimesFile(fileFinish);
        return reader.read(RACERS).stream()
                .map(s -> s.split(UNDERSCORE))
                .map(s -> new Racer(s[1], s[2],
                        Duration.between(abbreviationsStartTime.get(s[0]), abbreviationsFinishTime.get(s[0]))))
                .collect(Collectors.toList());
    }

    public Map<String, LocalDateTime> parseTimesFile(String fileName) {
        FileReader reader = new FileReader();
        List<String> inputFile = reader.read(fileName);
        inputFile.forEach(line -> {
            if (!Pattern.matches(TIMES_FILE_PATTERN, line)) {
                throw new IllegalArgumentException("Incorrect data format in input file!");
            }
        });
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_PATTERN);
        return inputFile.stream()
                .collect(Collectors.toMap(s -> s.substring(0, 3), s -> LocalDateTime.parse(s.substring(3), formatter)));
    }
}