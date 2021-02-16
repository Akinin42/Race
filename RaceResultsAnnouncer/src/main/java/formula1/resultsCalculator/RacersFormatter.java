package formula1.resultsCalculator;

import java.time.Duration;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RacersFormatter {

    private static final char WHITESPACE = ' ';
    private static final char HYPHEN = '-';
    private int index;

    public String formatRace(List<Racer> racers) {
        int nameLineLength = Collections.max(racers.stream()
                .map(Racer::getName)
                .collect(Collectors.toList()), Comparator.comparing(String::length)).length();
        int teamLineLength = Collections.max(racers.stream()
                .map(Racer::getTeam)
                .collect(Collectors.toList()), Comparator.comparing(String::length)).length();

        return racers.stream()
                .sorted(Comparator.comparing(Racer::getLapTime))
                .collect(StringBuilder::new, (result, racer) -> {
                    if (index == 15) {
                        result.append(FormatUtil.appendSymbolTimes(HYPHEN, nameLineLength + teamLineLength + 17))
                                .append("\n");
                    }
                    index++;
                    result.append(formatRacer(racer, nameLineLength, teamLineLength));
                }, StringBuilder::append)
                .toString();
    }

    private String formatRacer(Racer inputRacer, int nameLineLength, int teamLineLength) {
        return Stream.of(inputRacer)
                .collect(StringBuilder::new, (result, racer) -> {
                    result.append(String.format("%02d.%s", index, racer.getName()));
                    result.append(FormatUtil.appendSymbolTimes(WHITESPACE, nameLineLength - racer.getName().length()));
                    result.append(String.format(" | %s", racer.getTeam()));
                    result.append(FormatUtil.appendSymbolTimes(WHITESPACE, teamLineLength - racer.getTeam().length()));
                    result.append(String.format(" | %s%n", formatLapTime(racer.getLapTime())));
        }, StringBuilder::append)
                .toString();
    }

    private String formatLapTime(Duration lapTime) {
        return String.format("%d:%02d.%03d", lapTime.toMinutes(), lapTime.getSeconds() % 60,
                lapTime.getNano() / 1000000);
    }
}