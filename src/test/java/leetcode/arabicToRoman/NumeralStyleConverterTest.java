package leetcode.arabicToRoman;

import leetcode.arabicToRoman.NumeralStyleConverter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class NumeralStyleConverterTest {

    private final NumeralStyleConverter converter = new NumeralStyleConverter();

    @ParameterizedTest
    @MethodSource("numberProvider")
    public void testArabicToRomanConversion(Integer number, String expected) {
        String actual = converter.arabicToRoman(number);

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("numberWrongProvider")
    public void testArabicToRomanWrongArgumentConversion(Integer number, String expected) {
        String actual = converter.arabicToRoman(number);

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("numberProvider")
    public void testRomanToArabicConversion(Integer expected, String roman) {
        Integer actual = converter.romanToArabic(roman);

        Assertions.assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("numberWrongRomanProvider")
    public void testRomanToArabicWrongArgumentConversion(Integer expected, String number) {
        Integer actual = converter.romanToArabic(number);

        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> numberProvider() {
        return Stream.of(
                Arguments.of(100, "C"),
                Arguments.of(700, "DCC"),
                Arguments.of(2021, "MMXXI"),
                Arguments.of(5431, "MMMMMCDXXXI"),
                Arguments.of(1274, "MCCLXXIV")
        );
    }

    static Stream<Arguments> numberWrongProvider() {
        return Stream.of(
                Arguments.of(null, ""),
                Arguments.of(0, ""),
                Arguments.of(-1, ""),
                Arguments.of(-100, "")
        );
    }

    static Stream<Arguments> numberWrongRomanProvider() {
        return Stream.of(
                Arguments.of(null, null),
                Arguments.of(null, ""),
                Arguments.of(null, "  "),
                Arguments.of(null, "M45F"),
                Arguments.of(null, "FK")
        );
    }

}
