package leetcode.jumpGame;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Optional;
import java.util.stream.Stream;

class JumpServiceTest {

    private static final JumpService jumpService = new JumpService();

    @ParameterizedTest
    @MethodSource("arraysProvider")
    void findCountOfShortestWay(byte[] array, Optional<Integer> expected) {
        Optional<Integer> actual = jumpService.findCountOfShortestWay(array);
        Assertions.assertEquals(expected, actual);
    }

    static Stream<Arguments> arraysProvider() {
        return Stream.of(
                Arguments.of(new byte[]{2, 3, 1, 1, 4}, Optional.of(2)),
                Arguments.of(new byte[]{2, 3, 0, 1, 4}, Optional.of(2)),
                Arguments.of(null, Optional.empty()),
                Arguments.of(new byte[]{1, -1, 1}, Optional.empty()),
                Arguments.of(new byte[0], Optional.empty())
        );
    }
}