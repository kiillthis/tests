package leetcode;

import java.util.*;

/**
 * @author Andrii Kompaniiets
 * @version 1.0
 */
public class NumeralStyleConverter {

    private final static List<Equivalent> arabicToRomanTable;
    private final static Map<String, Integer> romanToArabicTable;

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
        arabicToRomanTable = Collections.unmodifiableList(Arrays.asList(arr));

        Map<String, Integer> romanToArabicMap = new TreeMap<>(new RomanToArabicTableComparator());

        for (Equivalent equivalent: arabicToRomanTable) {
            romanToArabicMap.put(equivalent.roman, equivalent.arabic);
        }

        romanToArabicTable = Collections.unmodifiableMap(romanToArabicMap);
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
        int i = arabicToRomanTable.size() - 1;
        while (number > 0) {
            while (arabicToRomanTable.get(i).arabic > number) {
                i--;
            }
            answer.append(arabicToRomanTable.get(i).roman);
            number -= arabicToRomanTable.get(i).arabic;
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
            for (Map.Entry<String, Integer> equivalence: romanToArabicTable.entrySet()) {
                illegalArgument = true;
                int lengthOfSubsequence = romanNumber.length() > 1 ? 2 : 1;
                if (startsWith(romanNumber.subSequence(0, lengthOfSubsequence), equivalence.getKey())) {
                     answer += equivalence.getValue();
                     romanNumber.delete(0, equivalence.getKey().length());
                     illegalArgument = false;
                     break;
                }
            }
            if (illegalArgument && romanNumber.length() != 0) {
                return null;
            }
        }
        return answer;
    }

    private boolean startsWith(CharSequence sequence, CharSequence prefix) {
        if (sequence.length() < prefix.length()) {
            return false;
        }
        for (int i = 0; i < prefix.length(); i++) {
            if (prefix.charAt(i) != sequence.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}