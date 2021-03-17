package formula.racecalculator.domain;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import formula.racecalculator.models.Racer;

public class RacersCreator {

    private static final String UNDERSCORE = "_";
    private static final String DATE_PATTERN = "yyyy-MM-dd_HH:mm:ss.SSS";

    public List<Racer> createRacers(List<String> contentStart, List<String> contentFinish,
                                    List<String> contentAbbreviations) {
        try {
            Map<String, LocalDateTime> abbreviationsStartTimes = parseTime(contentStart);
            Map<String, LocalDateTime> abbreviationsFinishTimes = parseTime(contentFinish);
            return contentAbbreviations.stream().map(s -> s.split(UNDERSCORE))
                    .map(s -> new Racer(s[1], s[2],
                            Duration.between(abbreviationsStartTimes.get(s[0]), abbreviationsFinishTimes.get(s[0]))))
                    .collect(Collectors.toList());
        } catch (DateTimeParseException | ArrayIndexOutOfBoundsException | NullPointerException e) {
            throw new IllegalArgumentException("File content is not valid! ", e);
        }
    }

    private Map<String, LocalDateTime> parseTime(List<String> fileContent) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern(DATE_PATTERN);
        return fileContent.stream()
                .collect(Collectors.toMap(s -> s.substring(0, 3), s -> LocalDateTime.parse(s.substring(3), formatter)));
    }
}