package formula1.announcer;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import formula1.resultscounter.FormatUtil;

class FormatUtilTest {

    @Test
    void appendSymbolTimes_ShouldReturnLineOfInputSymbol_WhenPositiveNumber() {
        String expected = "-------";
        String actual = FormatUtil.appendSymbolTimes('-', 7);
        assertEquals(expected, actual);
    }

    @Test
    void appendSymbolTimes_ShouldReturnEmptyLine_WhenZero() {
        String expected = "";
        String actual = FormatUtil.appendSymbolTimes(' ', 0);
        assertEquals(expected, actual);
    }

    @Test
    void appendSymbolTimes_ShouldReturnEmptyLine_WhenNegativeNumber() {
        String expected = "";
        String actual = FormatUtil.appendSymbolTimes(' ', -5);
        assertEquals(expected, actual);
    }
}