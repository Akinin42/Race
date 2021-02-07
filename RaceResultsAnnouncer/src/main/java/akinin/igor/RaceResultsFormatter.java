package akinin.igor;

import java.time.Duration;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class RaceResultsFormatter {

    private static final char WHITESPACE = ' ';
    private static final char HYPHEN = '-';

    public String format(List<Racer> raceResults) {        
        StringBuilder result = new StringBuilder();
        List<Racer> racers = raceResults;
        racers.sort(Comparator.comparing(Racer::getLapTime));
        int nameLineLength = Collections.max(racers.stream().map(Racer::getName).collect(Collectors.toList()),
                Comparator.comparing(String::length)).length();
        int teamLineLength = Collections.max(racers.stream().map(Racer::getTeam).collect(Collectors.toList()),
                Comparator.comparing(String::length)).length();
        raceResults.stream().forEach(racer -> {
            if (racers.indexOf(racer) == 15) {
                result.append(FormatUtil.appendSymbolTimes(HYPHEN, nameLineLength + teamLineLength + 17)).append("\n");
            }
            result.append(String.format("%02d.%s%s | %s%s | %s%n", racers.indexOf(racer) + 1, racer.getName(),
                    FormatUtil.appendSymbolTimes(WHITESPACE, nameLineLength - racer.getName().length()),
                    racer.getTeam(),
                    FormatUtil.appendSymbolTimes(WHITESPACE, teamLineLength - racer.getTeam().length()),
                    formatLapTime(racer.getLapTime())));
        });
        return result.toString();
    }

    private String formatLapTime(Duration lapTime) {
        return String.format("%d:%02d.%03d", lapTime.toMinutes(), lapTime.getSeconds() % 60,
                lapTime.getNano() / 1000000);
    }
}