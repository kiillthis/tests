package leetcode;

import java.util.*;


/**
 * @author Andrii Kompaniiets
 * @version 1.0
 */
public class RomanAndArabicNumberConverter {

    List<RomanAndArabicEquivalent> table = new ArrayList<>(Arrays.asList(
            new RomanAndArabicEquivalent("I", 1),
            new RomanAndArabicEquivalent("IV", 4),
            new RomanAndArabicEquivalent("V", 5),
            new RomanAndArabicEquivalent("IX", 9),
            new RomanAndArabicEquivalent("X", 10),
            new RomanAndArabicEquivalent("XL", 40),
            new RomanAndArabicEquivalent("L", 50),
            new RomanAndArabicEquivalent("XC", 90),
            new RomanAndArabicEquivalent("C", 100),
            new RomanAndArabicEquivalent("CD", 400),
            new RomanAndArabicEquivalent("D", 500),
            new RomanAndArabicEquivalent("M", 1000)
    )) ;

    /**
     *
     * @param number - number to be converted to roman style
     * @return String of roman equivalent
     */
    public String intToRoman(Integer number) {

        int id = table.size() - 1;
        String answer = "";

        while (number > 0) {
            while (table.get(id).getArabicValue() <= number) {
                answer += table.get(id).getRomanValue();
                number -= table.get(id).getArabicValue();
            }
            id--;
        }

        return answer;
    }

    private class RomanAndArabicEquivalent {
        private final String romanValue;
        private final Integer arabicValue;

        public RomanAndArabicEquivalent(String romanValue, Integer arabicValue) {
            this.romanValue = romanValue;
            this.arabicValue = arabicValue;
        }

        public String getRomanValue() {
            return romanValue;
        }

        public Integer getArabicValue() {
            return arabicValue;
        }
    }
}
