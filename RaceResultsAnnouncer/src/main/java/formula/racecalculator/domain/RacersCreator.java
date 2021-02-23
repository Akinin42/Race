package formula.racecalculator.domain;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import formula.racecalculator.dao.FileReader;

public class RacersCreator {

    private static final String UNDERSCORE = "_";
    private static final String DATE_PATTERN = "yyyy-MM-dd_HH:mm:ss.SSS";
    private FileReader reader;

    public RacersCreator(FileReader reader) {
        this.reader = reader;
    }

    public List<Racer> getRacers(String fileStart, String fileFinish, String fileAbbreviations) {
        return createRacers(parseTimes(reader.read(fileStart)), parseTimes(reader.read(fileFinish)),
                reader.read(fileAbbreviations));
    }

    private List<Racer> createRacers(Map<String, LocalDateTime> parsedStart, Map<String, LocalDateTime> parsedFinish,
            List<String> contentAbbreviations) {
        try {
            return contentAbbreviations.stream()
                    .map(s -> s.split(UNDERSCORE))
                    .map(s -> new Racer(s[1], s[2], Duration.between(parsedStart.get(s[0]), parsedFinish.get(s[0]))))
                    .collect(Collectors.toList());
        } catch (RuntimeException e) {
            throw new IllegalArgumentException("Abbreviations file content is not valid! " + e.getMessage());
        }
    }

    private Map<String, LocalDateTime> parseTimes(List<String> contentFile) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_PATTERN);
        try {
            return contentFile.stream()
                    .collect(Collectors.toMap(s -> s.substring(0, 3),
                            s -> LocalDateTime.parse(s.substring(3), formatter)));
        } catch (RuntimeException e) {
            throw new IllegalArgumentException("Times file content is not valid! " + e.getMessage());
        }
    }
}