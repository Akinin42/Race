package formula1.racecalculator;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RacersFormatter {

    private static final char WHITESPACE = ' ';
    private static final char HYPHEN = '-';
    private static final int NUMBER_TOP_RACERS = 15;
    private static final int REMAINDER_LINE_LENGTH = 17;

    public String formatRace(List<Racer> racers) {
        int nameMaxLength = calculateMaxLength(racers, "name");
        int teamMaxLength = calculateMaxLength(racers, "team");
        List<Racer> sortedRacersByTime = new ArrayList<Racer>();
        sortedRacersByTime = racers.stream().sorted(Comparator.comparing(Racer::getLapTime))
                .collect(Collectors.toList());
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < sortedRacersByTime.size(); i++) {
            int index = i + 1;
            if (i == NUMBER_TOP_RACERS) {
                result.append(
                        FormatUtil.appendSymbolTimes(HYPHEN, nameMaxLength + teamMaxLength + REMAINDER_LINE_LENGTH))
                        .append("\n");
            }
            result.append(formatRacer(sortedRacersByTime.get(i), index, nameMaxLength, teamMaxLength));
        }
        return result.toString();
    }

    private String formatRacer(Racer inputRacer, int index, int nameMaxLength, int teamMaxLength) {
        return Stream.of(inputRacer).collect(StringBuilder::new,
                (result, racer) -> result.append(String.format("%02d.%s", index, racer.getName()))
                        .append(FormatUtil.appendSymbolTimes(WHITESPACE, nameMaxLength - racer.getName().length()))
                        .append(String.format(" | %s", racer.getTeam()))
                        .append(FormatUtil.appendSymbolTimes(WHITESPACE, teamMaxLength - racer.getTeam().length()))
                        .append(String.format(" | %s%n", formatLapTime(racer.getLapTime()))),
                StringBuilder::append).toString();
    }

    private String formatLapTime(Duration lapTime) {
        return String.format("%d:%02d.%03d", lapTime.toMinutes(), lapTime.getSeconds() % 60,
                lapTime.getNano() / 1000000);
    }

    private int calculateMaxLength(List<Racer> racers, String field) {
        if (field.equals("name")) {
            return Collections.max(racers.stream()
                    .map(Racer::getName)
                    .collect(Collectors.toList()), Comparator.comparing(String::length)).length();
        } else {
            return Collections.max(racers.stream()
                    .map(Racer::getTeam)
                    .collect(Collectors.toList()), Comparator.comparing(String::length)).length();
        }
    }
}