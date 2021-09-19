package leetcode;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @author Andrii Kompaniiets
 * @version 1.0
 */
public class NumeralStyleConverter {

    private final static Map<Integer, String> tableOfRomanAndArabicEquivalence = new TreeMap<>(Collections.reverseOrder());

    private final static String VALIDATE_SYMBOLS;
    private final static Pattern pattern;

    static {

        tableOfRomanAndArabicEquivalence.put(1000, "M");
        tableOfRomanAndArabicEquivalence.put(900, "CM");
        tableOfRomanAndArabicEquivalence.put(500, "D");
        tableOfRomanAndArabicEquivalence.put(400, "CD");
        tableOfRomanAndArabicEquivalence.put(100, "C");
        tableOfRomanAndArabicEquivalence.put(90, "XC");
        tableOfRomanAndArabicEquivalence.put(50, "L");
        tableOfRomanAndArabicEquivalence.put(40, "XL");
        tableOfRomanAndArabicEquivalence.put(10, "X");
        tableOfRomanAndArabicEquivalence.put(9, "IX");
        tableOfRomanAndArabicEquivalence.put(5, "V");
        tableOfRomanAndArabicEquivalence.put(4, "IV");
        tableOfRomanAndArabicEquivalence.put(1, "I");

        StringBuilder regexCreatedString = new StringBuilder();
        StringBuilder romanValues = new StringBuilder();

        for (String value: tableOfRomanAndArabicEquivalence.values()) {
            romanValues.append(value);
        }

        regexCreatedString.append("[^");
        regexCreatedString.append(romanValues);
        regexCreatedString.append("]");

        VALIDATE_SYMBOLS = regexCreatedString.toString();

        pattern = Pattern.compile(VALIDATE_SYMBOLS);
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

        while (number > 0) {
            for (Map.Entry<Integer, String> equivalent : tableOfRomanAndArabicEquivalence.entrySet()) {
                if(equivalent.getKey() <= number) {
                    answer.append(equivalent.getValue());
                    number -= equivalent.getKey();
                    break;
                }
            }
        }

        return answer.toString();
    }

    /**
     *
     * @param number - number to be converted to arabic style
     * @return Integer of arabic equivalent
     */
    public Integer romanToArabic(String number) {

        if(!checkValidityRomanNumber(number)) {
            return 0;
        }

        StringBuilder romanNumber = new StringBuilder(number);

        Integer answer = 0;

        while (romanNumber.length() != 0) {
            for (Map.Entry<Integer, String> equivalent : tableOfRomanAndArabicEquivalence.entrySet()) {
                if (romanNumber.substring(0).startsWith(equivalent.getValue())) {
                    answer += equivalent.getKey();
                    if (equivalent.getValue().length() == 2) {
                        romanNumber.delete(0, 2);
                    } else if (equivalent.getValue().length() == 1) {
                        romanNumber.deleteCharAt(0);
                    } else {
                        String exception = String.format("Wrong roman value in a table, value = %s", equivalent.getValue());
                        throw new IllegalArgumentException(exception);
                    }
                    break;
                }
            }
        }

        return answer;
    }

    private Boolean checkValidityRomanNumber(String number) {
        if (number == null || number.isEmpty()) {
            return false;
        }

        Matcher matcher = pattern.matcher(number);

        return !matcher.find();
    }
}
