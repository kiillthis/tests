package leetcode;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


/**
 * @author Andrii Kompaniiets
 * @version 1.0
 */
public class NumeralStyleConverter {

    private final static TreeMap<Integer, String> tableToRomanConversion = new TreeMap<>(Collections.reverseOrder());

    static {

        tableToRomanConversion.put(1000, "M");
        tableToRomanConversion.put(900, "CM");
        tableToRomanConversion.put(500, "D");
        tableToRomanConversion.put(400, "CD");
        tableToRomanConversion.put(100, "C");
        tableToRomanConversion.put(90, "XC");
        tableToRomanConversion.put(50, "L");
        tableToRomanConversion.put(40, "XL");
        tableToRomanConversion.put(10, "X");
        tableToRomanConversion.put(9, "IX");
        tableToRomanConversion.put(5, "V");
        tableToRomanConversion.put(4, "IV");
        tableToRomanConversion.put(1, "I");

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
            for (Map.Entry<Integer, String> equivalent : tableToRomanConversion.entrySet()) {
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
        StringBuilder romanNumber = new StringBuilder(number);

        Integer answer = 0;

        if(!checkValidityRomanNumber(number)) {
            return 0;
        }

        while (!romanNumber.toString().equals("")) {
            for (Map.Entry<Integer, String> equivalent : tableToRomanConversion.entrySet()) {
                if (romanNumber.substring(0).startsWith(equivalent.getValue())) {
                    answer += equivalent.getKey();
                    if (equivalent.getValue().length() == 2) {
                        romanNumber.delete(0, 1);
                    } else {
                        romanNumber.deleteCharAt(0);
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

        String VALIDATE_SYMBOLS = "[^CM|D|CD|C|XC|L|XL|X|IX|V|IV|I]";
        Pattern pattern = Pattern.compile(VALIDATE_SYMBOLS);
        Matcher matcher = pattern.matcher(number);

        return !matcher.find();
    }
}
