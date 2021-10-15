package leetcode.permutation;

import java.util.ArrayList;
import java.util.List;

/**
 * Service for next lexicographic permutation

 */
public class PermutationService {

    //todo: good javadoc
    /**
     *
     * @param array array where should be permutation done
     * @return array with next lexicographic permutation
     */
    public List<Integer> nextGreater(List<Integer> array) { //todo return false if not possible, better argument type
        if (array == null) {
            return new ArrayList<>();
        }
        int i = array.size() - 2;
        while (i >= 0 && array.get(i) >= array.get(i + 1)) {
            i--;
        }
        if (i >= 0) {
            int j = array.size() - 1;
            while (j >= 0 && array.get(j) <= array.get(i)) {
                j--;
                //todo
            }
            swap(array, i, j);
        }
        reverse(array, i + 1);
        return array; //todo
    }

    /**
     * @param array array of integers that will be permuted
     * @param i one of integer to be swapped
     * @param j another one integer that will be swapped
     */
    //todo generic
    private void swap(List<Integer> array, int i, int j) {
        int temp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, temp);
    }

    /**
     * @param array array whose content will be reverted
     * @param start element from which
     */
    private void reverse(List<Integer> array, int start) {
        int end = array.size() - 1;
        while (start < end) {
            swap(array, start, end);
            start++;
            end--;
        }
    }
}
