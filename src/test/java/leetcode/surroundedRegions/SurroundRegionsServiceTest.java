package leetcode.surroundedRegions;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SurroundRegionsServiceTest {

    private final static SurroundRegionsConverter converter = new SurroundRegionsConverter();

    @ParameterizedTest
    @MethodSource("boardsProvider")
    void findBoardWithoutSurroundedRegions(char[][] input, char[][] expected) {
        char[][] actual = converter.findBoardWithoutSurroundedRegions(input);

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    void testIncorrectBoard() {
        // board is null
        char[][] actual = converter.findBoardWithoutSurroundedRegions(null);
        char[][] expected = new char[0][0];

        Assertions.assertArrayEquals(expected, actual);

        // board has only one row
        char[][] board = new char[0][1];
        actual = converter.findBoardWithoutSurroundedRegions(board);
        Assertions.assertEquals(board, actual);
    }

    static Stream<Arguments> boardsProvider() {
        return Stream.of(
                Arguments.of(
                        new char[][]{
                                {'X', 'X', 'X', 'X'},
                                {'X', 'O', 'O', 'X'},
                                {'X', 'X', 'O', 'X'},
                                {'X', 'O', 'X', 'X'}},
                        new char[][]{
                                {'X', 'X', 'X', 'X'},
                                {'X', 'X', 'X', 'X'},
                                {'X', 'X', 'X', 'X'},
                                {'X', 'O', 'X', 'X'}
                                }
                ),
                Arguments.of(
                        new char[][]{
                                {'X', 'X', 'X', 'X'},
                                {'X', 'O', 'O', 'X'},
                                {'X', 'X', 'O', 'X'},
                                {'X', 'O', 'X', 'X'}},
                        new char[][]{
                                {'X', 'X', 'X', 'X'},
                                {'X', 'X', 'X', 'X'},
                                {'X', 'X', 'X', 'X'},
                                {'X', 'O', 'X', 'X'}
                        }
                ),
                Arguments.of(
                        new char[][]{
                                {'X', 'X', 'X', 'X', 'X'},
                                {'X', 'O', 'O', 'O', 'X'},
                                {'X', 'O', 'O', 'O', 'X'},
                                {'X', 'O', 'O', 'O', 'X'},
                                {'X', 'X', 'X', 'X', 'X'}},
                        new char[][]{
                                {'X', 'X', 'X', 'X', 'X'},
                                {'X', 'X', 'X', 'X', 'X'},
                                {'X', 'X', 'X', 'X', 'X'},
                                {'X', 'X', 'X', 'X', 'X'},
                                {'X', 'X', 'X', 'X', 'X'}
                        }),
                Arguments.of(
                        new char[][]{
                                {'X', 'X', 'X', 'X'},
                                {'X', 'X', 'X', 'O'},
                                {'X', 'X', 'X', 'O'},
                                {'X', 'O', 'O', 'O'}},
                        new char[][]{
                                {'X', 'X', 'X', 'X'},
                                {'X', 'X', 'X', 'O'},
                                {'X', 'X', 'X', 'O'},
                                {'X', 'O', 'O', 'O'},
                        }
                )
        );
    }
}