package rao.lalit.yilu.challenge;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class ChallengeSet {
    
    /** 
     * Uses HashMap to store the number of occurences of a character. <br>
     *  Also using a map would help in counting UNICODE characters as well and doesnt restrict with 256 ASCII chars.
     *  
     * @return A repeated character if any. Else throws runtime exception to let the user know there is no repeating character.
     * @param str
     *            An input string to find non repeated character from
     * @author lalitrao
     */
    public static char nonRepeatedCharacterCheck(String str) {
        Objects.requireNonNull(str);
        // Map of Character and its count in the string
        Map<Character, Integer> charCountMap = new HashMap<>();
        for (char c : str.toCharArray()) {
            if (!charCountMap.containsKey(c)) {
                charCountMap.put(c, 1);
            } else {
                charCountMap.put(c, charCountMap.get(c) + 1);
            }
        }

        /*
         * Iterating through the string again as HashMap does not maintain order
         * and we have to find first non repeating character
         */
        for (char c : str.toCharArray()) {
            if (charCountMap.get(c) == 1) {
                return c;
            }
        }
        throw new RuntimeException(String.format("No repeated character found in %s", str));
    }

    /** 
     * An overloaded version of {@link #nonRepeatedCharacterCheck}
     * It takes an extra boolean flag to check for case sensitivity
     *  
     * @return A repeated character if any. Else throws runtime exception to let the user know there is no repeating character.
     * @param str
     *            An input string to find non repeated character from
     * @param isCaseSensitive
     *            A boolean to check for case.
     * @author lalitrao
     */
    public static char nonRepeatedCharacterCheck(String str, boolean isCaseSensitive) {
        Objects.requireNonNull(str);
        if (!isCaseSensitive) {
            str = str.toLowerCase();
        }
        return nonRepeatedCharacterCheck(str);
    }

    /**
     * Checks if a string is a rotation of other string. <br>
     * It concatenates String a to itself to check for rotation<br>
     * 
     * for eg: String a = "abcd"; String b = "dabc";<br>
     * String concat = abcd + abcd; // "abcdabcd"<br>
     * if String b is rotation of a, concat would contain String b. // "abcdabcd" contains "dabc"
     * 
     * @param a String to check for
     * @param b String to check if its rotation of a
     * @author lalitrao
     * */
    public static boolean checkRotation(String a, String b) {
        if (isStringEmpty(a) || isStringEmpty(b)) {
            return false;
        }
        if (a.length() != b.length()) {
            return false;
        }
        String concatenatedString = a + a;
        return concatenatedString.contains(b);
    }

    private static boolean isStringEmpty(String str) {
        return str == null || str.isEmpty() || str.trim().length() == 0;
    }
}
