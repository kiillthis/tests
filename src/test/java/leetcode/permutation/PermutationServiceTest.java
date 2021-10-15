package leetcode.permutation;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.stream.Stream;

class PermutationServiceTest {

    private final static PermutationService permutationService = new PermutationService();

    @ParameterizedTest
    @MethodSource("arraysProvider")
    public void getNextGreaterValue(Byte[] arrayToPermutation, Byte[] arrayExpected, boolean permutationExpected) {
        boolean actual = permutationService.getNextGreaterValue((arrayToPermutation));
        assertEquals(permutationExpected, actual);
        assertArrayEquals(arrayExpected, arrayToPermutation);
    }

    @Test
    public void testAllPermutation() {
        Byte[] array = new Byte[] {1, 2, 3};
        boolean isReverted = true;

        while (isReverted) {
            Byte[] arrayPrevious = array.clone();
            isReverted = permutationService.getNextGreaterValue(array);
            if (isReverted) {
                boolean isBigger = false;
                for (int i = 0; i < array.length; i++) {
                    if (array[i] > arrayPrevious[i]) {
                        isBigger = true;
                        break;
                    }
                }
                Assertions.assertTrue(isBigger);
            }
        }
    }


    static Stream<Arguments> arraysProvider() {
        return Stream.of(
                Arguments.of(new Byte[]{1, 2, 3}, new Byte[]{1, 3, 2}, Boolean.TRUE),
                Arguments.of(new Byte[]{3, 2, 1}, new Byte[]{1, 2, 3}, Boolean.FALSE),
                Arguments.of(new Byte[]{1, 1, 5}, new Byte[]{1, 5, 1}, Boolean.TRUE),
                Arguments.of(new Byte[]{2, 2, 2}, new Byte[] {2,2,2}, Boolean.FALSE),
                Arguments.of(new Byte[]{1}, new Byte[]{1}, Boolean.FALSE),
                Arguments.of(null, null, Boolean.FALSE),
                Arguments.of(new Byte[]{1, 1, 5, 4, 1}, new Byte[]{1, 4, 1, 1, 5}, Boolean.TRUE)
        );
    }
}