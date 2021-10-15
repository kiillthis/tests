package leetcode.permutation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

class PermutationServiceTest {

    private final static PermutationService permutationService = new PermutationService();

    @ParameterizedTest
    @MethodSource("arraysProvider")
    public void testNextPermutation(List<Integer> arrayToPermutation, List<Integer> arrayExpected) {
        List<Integer> actual = permutationService.findNextPermutation(arrayToPermutation);
        assertEquals(arrayExpected, actual);
    }

    static Stream<Arguments> arraysProvider() {

        return Stream.of(
                Arguments.of(new ArrayList<>(Arrays.asList(1, 2, 3)), new ArrayList<>(Arrays.asList(1, 3, 2))),
                Arguments.of(new ArrayList<>(Arrays.asList(3, 2, 1)), new ArrayList<>(Arrays.asList(1, 2, 3))),
                Arguments.of(new ArrayList<>(Arrays.asList(1, 1, 5)), new ArrayList<>(Arrays.asList(1, 5, 1))),
                Arguments.of(new ArrayList<>(Arrays.asList(1)), new ArrayList<>(Arrays.asList(1))),
                Arguments.of(null, new ArrayList<>()),
                Arguments.of(new ArrayList<>(Arrays.asList(1, 1, 5, 4, 1)), new ArrayList<>(Arrays.asList(1, 4, 1, 1, 5)))
        );
    }
}