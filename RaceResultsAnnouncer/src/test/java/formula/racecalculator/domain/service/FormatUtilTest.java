package formula.racecalculator.domain.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

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

    @Test
    void findNumberLength_ShouldReturnAmountOfDigits_WhenPositiveMultiDigitNumber() {
        int expected = 2;
        int actual = FormatUtil.findNumberLength(15);
        assertEquals(expected, actual);
    }

    @Test
    void findNumberLength_ShouldReturnAmountOfDigits_WhenSingleDigitNumber() {
        int expected = 1;
        int actual = FormatUtil.findNumberLength(5);
        assertEquals(expected, actual);
    }
}