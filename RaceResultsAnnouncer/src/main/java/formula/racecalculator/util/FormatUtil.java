package formula.racecalculator.util;

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
    
    public static int findNumberLength(int inputNumber) {
        if (inputNumber == 0) {
            return 1;
        }
        int lengthNumber = (int) (Math.log10(Math.abs(inputNumber)) + 1);
        if (inputNumber < 0) {
            lengthNumber++;
        }
        return lengthNumber;
    }
}