package leetcode.permutation;

import java.util.Arrays;

/**
 * Service for permutations to get bigger value of input data
 */
public class PermutationService {

    //todo fix javadoc
    /**
     * Method receives an array which will be permutated
     * to next bigger array and signals by returning 'true' if permutation was done.
     * Otherwise, false will be returned.
     *
     * @param array byte array which will be permutated to next value
     * @return true or false depending if permutated happened
     */
    //todo 1) byte; 2) do not revert, just return
    public boolean getNextGreaterValue(Byte[] array) {
        if (array == null) {
            return false;
        }
        int i = array.length - 2;
        while (i >= 0 && array[i] >= array[i + 1]) {
            i--;
        }
        if (i < 0) {
            reverse(array, 0);
            return false;
        }
        int j = i - 1;
        while (j >= 0 && array[j] <= array[i]) {
            j--;
        }
        swap(array, i, j);
        reverse(array, i + 1);
        return true;
    }

    /**
     * @param array array that will be permuted
     * @param i one element to be swapped
     * @param j another one element that will be swapped
     */
    private <T> void swap(T[] array, int i, int j) {
        T temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * @param array array whose content will be reverted
     * @param beginIndex element from which reversion should start
     */
    private void reverse(Byte[] array, int beginIndex) {
        int end = array.length - 1;
        while (beginIndex < end) {
            swap(array, beginIndex, end);
            beginIndex++;
            end--;
        }
    }
}
