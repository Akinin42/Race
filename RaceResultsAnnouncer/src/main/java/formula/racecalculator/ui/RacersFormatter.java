package formula.racecalculator.ui;

import java.time.Duration;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import formula.racecalculator.domain.Racer;
import formula.racecalculator.domain.service.FormatUtil;

public class RacersFormatter {

    private static final char WHITESPACE = ' ';
    private static final char HYPHEN = '-';
    private static final int NUMBER_TOP_RACERS = 15;
    private static final int SEPARATOR_LENGTH = 1;

    public String formatRace(List<Racer> racers) {
        if(racers.isEmpty()) {
            throw new IllegalArgumentException("Input list can't be empty!");
        }
        int nameMaxLength = calculateMaxLength(racers.stream()
                .map(Racer::getName)
                .collect(Collectors.toList()));
        int teamMaxLength = calculateMaxLength(racers.stream()
                .map(Racer::getTeam)
                .collect(Collectors.toList()));
        List<Racer> sortedRacersByTime = racers.stream()
                .sorted(Comparator.comparing(Racer::getLapTime))
                .collect(Collectors.toList());
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < sortedRacersByTime.size(); i++) {
            if (i == NUMBER_TOP_RACERS) {
                int dividingLineLength = FormatUtil.findNumberLength(racers.size()) + SEPARATOR_LENGTH + nameMaxLength
                        + SEPARATOR_LENGTH + teamMaxLength + SEPARATOR_LENGTH
                        + formatLapTime(sortedRacersByTime.get(i).getLapTime()).length();
                result.append(FormatUtil.appendSymbolTimes(HYPHEN, dividingLineLength)).append("\n");
            }
            result.append(formatRacer(sortedRacersByTime.get(i), i + 1, nameMaxLength, teamMaxLength));
        }
        return result.toString();
    }

    private String formatRacer(Racer inputRacer, int index, int nameMaxLength, int teamMaxLength) {
        return Stream.of(inputRacer)
                .collect(StringBuilder::new,
                        (result, racer) -> result.append(String.format("%02d.%s", index, racer.getName()))
                        .append(FormatUtil.appendSymbolTimes(WHITESPACE, nameMaxLength - racer.getName().length()))
                        .append(String.format("|%s", racer.getTeam()))
                        .append(FormatUtil.appendSymbolTimes(WHITESPACE, teamMaxLength - racer.getTeam().length()))
                        .append(String.format("|%s%n", formatLapTime(racer.getLapTime()))),
                StringBuilder::append).toString();
    }

    private String formatLapTime(Duration lapTime) {
        return String.format("%d:%02d.%03d", lapTime.toMinutes(), lapTime.getSeconds() % 60,
                lapTime.getNano() / 1000000);
    }

    private int calculateMaxLength(List<String> racersField) {
        return Collections.max(racersField, Comparator.comparing(String::length)).length();
    }
}