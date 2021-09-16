import leetcode.RomanAndArabicNumberConverter;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

public class RomanAndArabicNumberConverterTest {

    final RomanAndArabicNumberConverter converter = new RomanAndArabicNumberConverter();

    @ParameterizedTest
    @MethodSource("numberProvider")
    public void testConverter(Integer number, String expected) {
        String actual = converter.intToRoman(number);

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

}
