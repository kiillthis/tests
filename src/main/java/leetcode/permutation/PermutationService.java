package leetcode.permutation;

/**
 * Service for permutations to get bigger value of input data
 */
public class PermutationService {

    /**
     * Method receives an array which will be permuted
     * to next bigger array and signals by returning 'true' if permutation was done.
     *
     * @param array byte array which will be permuted to next value
     * @return true if permutation took place. Otherwise, false.
     */
    public boolean getNextGreaterValue(byte[] array) {
        if (array == null) {
            return false;
        }
        int i = array.length - 2;
        while (i >= 0 && array[i] >= array[i + 1]) {
            i--;
        }
        if (i < 0) {
            return false;
        }
        int j = array.length - 1;
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
    private void swap(byte[] array, int i, int j) {
        byte temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    /**
     * @param array array whose content will be reverted
     * @param beginIndex element from which reversion should start
     */
    private void reverse(byte[] array, int beginIndex) {
        int end = array.length - 1;
        while (beginIndex < end) {
            swap(array, beginIndex, end);
            beginIndex++;
            end--;
        }
    }
}
