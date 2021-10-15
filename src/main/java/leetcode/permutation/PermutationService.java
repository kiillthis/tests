package leetcode.permutation;

/**
 * Service for permutations to get bigger value of input data
 */
public class PermutationService {

    /**
     * Method receives an array which will be permutated
     * to next bigger array and signals by returning 'true' if permutation was done.
     * Otherwise, false will be returned.
     * @param array byte array which will be permutated to next value
     * @return true or false depending if permutated happened
     */
    public boolean getNextGreaterValue(Byte[] array) {
        boolean isPermutated = false;
        if (array == null) {
            return false;
        }
        int i = array.length - 2;
        while (i >= 0 && array[i] >= array[i + 1]) {
            i--;
        }
        if (i >= 0) {
            int j = array.length - 1;
            while (j >= 0 && array[j] <= array[i]) {
                j--;
                //todo ???
            }
            swap(array, i, j);
            if (!isPermutated) {
                isPermutated = true;
            }
        }
        reverse(array, i + 1);
        return isPermutated;
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
