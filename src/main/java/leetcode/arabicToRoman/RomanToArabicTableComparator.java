package leetcode.arabicToRoman;

import java.util.Comparator;

public class RomanToArabicTableComparator implements Comparator<String> {
    @Override
    public int compare(String o1, String o2) {
        int compared = o2.length() - o1.length();
        if (compared == 0) {
            return 1;
        } else {
            return compared;
        }
    }
}
