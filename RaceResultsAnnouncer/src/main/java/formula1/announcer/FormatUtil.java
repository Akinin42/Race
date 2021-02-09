package formula1.announcer;

public final class FormatUtil {
    
    private FormatUtil() {
    }
    
    public static String appendSymbolTimes(char symbol, int length) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < length; i++) {
            result.append(symbol);
        }
        return result.toString();
    }     
}