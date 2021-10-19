package leetcode.jumpGame;

import java.util.Optional;

/**
 * See javadoc for {@link JumpService#isArrayValid(byte[])}
 */
public class JumpService {

    /**
     * Search minimum steps to reach last element.
     *
     * @param array array with elements where each element value is possible max jump to another element.
     * @return optional integer to reach last element in array. If array not valid - returns empty optional.
     */
    public Optional<Integer> findCountOfShortestWay (byte[] array) {
        if (!isArrayValid(array)) {
            return Optional.empty();
        }
        int end = 0;
        int farthest = 0;
        int jump = 0;

        for (int i = 0; i < array.length - 1; i++) {
            farthest = Math.max(farthest, i + array[i]);

            if (i == end) {
                jump++;
                end = farthest;
            }
        }
        return Optional.of(jump);
    }

    /**
     * Internal method to check if content of array valid
     * @param array array that should be checked
     * @return false if array null, empty or has negative value. Otherwise, true.
     */
    private boolean isArrayValid(byte[] array) {
        if (array == null) {
            return false;
        }
        if (array.length == 0) {
            return false;
        }
        for (byte b : array) {
            if (b < 0) {
                return false;
            }
        }
        return true;
    }
}
