package formula1.racecalculator;

import java.util.List;
import java.util.regex.Pattern;

public class FileValidator {

    private static final String ABBREVIATIONS_FILE_PATTERN = "[A-Z]*_[A-Za-z ]*_[A-Z ]*";
    private static final String TIMES_FILE_PATTERN = "[A-Z]*\\d{4}-\\d{2}-\\d{2}_\\d{2}:\\d{2}:\\d{2}.\\d{3}";

    public List<String> validate(List<String> contentFile) {
        contentFile.forEach(line -> {
            if (!Pattern.matches(TIMES_FILE_PATTERN, line) && !Pattern.matches(ABBREVIATIONS_FILE_PATTERN, line)) {
                throw new IllegalArgumentException("Incorrect data format in input file!");
            }
        });
        return contentFile;
    }
}