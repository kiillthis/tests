package leetcode.permutation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class PermutationServiceTest {

    private final static PermutationService permutationService = new PermutationService();

    @ParameterizedTest
    @MethodSource("arraysProvider")
    public void getNextGreaterValue(byte[] arrayToPermutation, byte[] arrayExpected, boolean permutationExpected) {
        boolean actual = permutationService.getNextGreaterValue(arrayToPermutation);
        assertEquals(permutationExpected, actual);
        assertArrayEquals(arrayExpected, arrayToPermutation);
    }

    @Test
    public void testAllPermutation() {
        byte[] array = new byte[]{1, 2, 3};
        int countOfPermutations = 1;
        int expectedCountOfPermutations = 6;
        boolean isPermuted = true;

        while (isPermuted) {
            byte[] arrayPrevious = array.clone();
            isPermuted = permutationService.getNextGreaterValue(array);
            if (isPermuted) {
                boolean isBigger = isArrayLessThanPrevious(array, arrayPrevious);
                countOfPermutations++;
                Assertions.assertTrue(isBigger);
            }
        }
        Assertions.assertEquals(expectedCountOfPermutations, countOfPermutations);
    }

    static Stream<Arguments> arraysProvider() {
        return Stream.of(
                Arguments.of(new byte[]{1, 2, 3}, new byte[]{1, 3, 2}, Boolean.TRUE),
                Arguments.of(new byte[]{3, 2, 1}, new byte[]{1, 2, 3}, Boolean.FALSE),
                Arguments.of(new byte[]{1, 1, 5}, new byte[]{1, 5, 1}, Boolean.TRUE),
                Arguments.of(new byte[]{2, 2, 2}, new byte[]{2, 2, 2}, Boolean.FALSE),
                Arguments.of(new byte[]{1}, new byte[]{1}, Boolean.FALSE),
                Arguments.of(null, null, Boolean.FALSE),
                Arguments.of(new byte[]{1, 1, 5, 4, 1}, new byte[]{1, 4, 1, 1, 5}, Boolean.TRUE)
        );
    }

    private boolean isArrayLessThanPrevious(byte[] array, byte[] arrayPrevious) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] > arrayPrevious[i]) {
                return true;
            }
        }
        return false;
    }
}