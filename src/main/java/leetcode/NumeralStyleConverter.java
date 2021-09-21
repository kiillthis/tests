package leetcode;

import java.util.*;

/**
 * @author Andrii Kompaniiets
 * @version 1.0
 */
public class NumeralStyleConverter {

    private final static List<Equivalent> romanToArabicTable;

    private static class Equivalent {
        private int arabic;
        private String roman;

        Equivalent(int arabic, String roman) {
            this.roman = roman;
            this.arabic = arabic;
        }
    }


    static {
        Equivalent[] arr = new Equivalent[] {
                new Equivalent(1000, "M"),
                new Equivalent(900, "CM"),
                new Equivalent(500, "D"),
                new Equivalent(400, "CD"),
                new Equivalent(100, "C"),
                new Equivalent(90, "XC"),
                new Equivalent(50, "L"),
                new Equivalent(40, "XL"),
                new Equivalent(10, "X"),
                new Equivalent(9, "IX"),
                new Equivalent(5, "V"),
                new Equivalent(4, "IV"),
                new Equivalent(1, "I")
        };

        Arrays.sort(arr, Comparator.comparingInt(a -> a.arabic));
        romanToArabicTable = Collections.unmodifiableList(Arrays.asList(arr));
    }

    /**
     *
     * @param number - number to be converted to roman style
     * @return String of roman equivalent
     */
    public String arabicToRoman(Integer number) {
        if(number == null || number < 1) {
            return "";
        }
        StringBuilder answer = new StringBuilder();
        int i = romanToArabicTable.size() - 1;
        while (number > 0) {
            while (romanToArabicTable.get(i).arabic > number) {
                i--;
            }
            answer.append(romanToArabicTable.get(i).roman);
            number -= romanToArabicTable.get(i).arabic;
        }

        return answer.toString();
    }

    /**
     *
     * @param number - number to be converted to arabic style
     * @return Integer of arabic equivalent
     */
    public Integer romanToArabic(String number) {
        boolean illegalArgument = false;
        if (number == null || number.isEmpty()) {
            return null;
        }
        StringBuilder romanNumber = new StringBuilder(number);
        int answer = 0;
        while (romanNumber.length() != 0) {
            for (int j = romanToArabicTable.size() - 1; j >= 0; j--) {
                illegalArgument = true;
                while (startsWith(romanNumber, romanToArabicTable.get(j).roman)) {
                     answer += romanToArabicTable.get(j).arabic;
                     romanNumber.delete(0, romanToArabicTable.get(j).roman.length());
                     illegalArgument = false;
                }
            }
            if (illegalArgument && romanNumber.length() != 0) {
                return null;
            }
        }
        return answer;
    }

    private boolean startsWith(CharSequence sequence, CharSequence prefix) {
        for (int i = 0; i < sequence.length(); i++) {
            if (prefix.charAt(i) != sequence.charAt(i)) {
                return false;
            }
            if(prefix.length() == i + 1) {
                return true;
            }
        }
        return false;
    }
}