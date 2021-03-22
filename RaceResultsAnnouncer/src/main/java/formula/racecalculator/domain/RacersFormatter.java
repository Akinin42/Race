package formula.racecalculator.domain;

import java.time.Duration;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import formula.racecalculator.models.Racer;
import formula.racecalculator.utils.FormatUtil;

public class RacersFormatter {

    private static final char WHITESPACE = ' ';
    private static final char HYPHEN = '-';
    private static final int NUMBER_TOP_RACERS = 15;
    private static final int SEPARATOR_LENGTH = 1;

    public String createRaceTable(List<Racer> racers) {
        if (racers == null) {
            throw new IllegalArgumentException("Racers list can't be null!");
        }
        if (racers.isEmpty()) {
            return "";
        }
        int nameMaxLength = calculateMaxLength(racers, Racer::getName);
        int teamMaxLength = calculateMaxLength(racers, Racer::getTeam);
        List<Racer> sortedRacersByTime = racers.stream().sorted(Comparator.comparing(Racer::getLapTime))
                .collect(Collectors.toList());
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < sortedRacersByTime.size(); i++) {
            if (i == NUMBER_TOP_RACERS) {
                result.append(createSeparatedLine(sortedRacersByTime, nameMaxLength, teamMaxLength))
                        .append("\n");
            }
            result.append(createRacerLine(sortedRacersByTime.get(i), i + 1, nameMaxLength, teamMaxLength));
        }
        return result.toString();
    }

    private String createRacerLine(Racer inputRacer, int index, int nameMaxLength, int teamMaxLength) {
        return Stream.of(inputRacer).collect(StringBuilder::new,
                (result, racer) -> result.append(String.format("%02d.%s", index, racer.getName()))
                        .append(FormatUtil.appendSymbolTimes(WHITESPACE, nameMaxLength - racer.getName().length()))
                        .append(String.format("|%s", racer.getTeam()))
                        .append(FormatUtil.appendSymbolTimes(WHITESPACE, teamMaxLength - racer.getTeam().length()))
                        .append(String.format("|%s%n", formatLapTime(racer.getLapTime()))),
                StringBuilder::append).toString();
    }

    private String createSeparatedLine(List<Racer> racers, int nameMaxLength, int teamMaxLength) {
        int division = FormatUtil.findNumberLength(racers.size()) + SEPARATOR_LENGTH + nameMaxLength + SEPARATOR_LENGTH
                + teamMaxLength + SEPARATOR_LENGTH + formatLapTime(racers.get(NUMBER_TOP_RACERS).getLapTime()).length();
        return FormatUtil.appendSymbolTimes(HYPHEN, division);
    }

    private String formatLapTime(Duration lapTime) {
        return String.format("%d:%02d.%03d", lapTime.toMinutes(), lapTime.getSeconds() % 60,
                lapTime.getNano() / 1000000);
    }

    private int calculateMaxLength(List<Racer> racers, Function<Racer, String> getField) {
        return Collections
                .max(racers.stream().map(getField).collect(Collectors.toList()), Comparator.comparing(String::length))
                .length();
    }
}