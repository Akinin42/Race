package formula1.racecalculator;

import java.util.stream.Stream;

public final class FormatUtil {

    private FormatUtil() {
    }

    public static String appendSymbolTimes(char symbol, int length) {
        if (length < 0) {
            return "";
        }
        StringBuilder result = new StringBuilder();
        Stream.generate(() -> symbol)
        .limit(length)
        .forEach(result::append);
        return result.toString();
    }
}