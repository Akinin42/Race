package akinin.igor;

public final class FormatUtil {
    
    private FormatUtil() {
    }
    
    public static String appendSymbolTimes(char symbol, int length) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append(symbol);
        }
        return sb.toString();
    }     
}