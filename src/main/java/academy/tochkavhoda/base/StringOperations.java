package academy.tochkavhoda.base;

import java.util.Locale;

public class StringOperations {

    public static int getSummaryLength(String[] strings) {
        int summaryLength = 0;

        for (String string : strings) {
            summaryLength += string.length();
        }

        return summaryLength;
    }

    public static String getFirstAndLastLetterString(String string) {
        return string.substring(0, 1)
                + string.substring(string.length() - 1);
    }

    public static boolean isSameCharAtPosition(String string1, String string2, int index) {
        return string1.charAt(index) == string2.charAt(index);
    }

    public static boolean isSameFirstCharPosition(String string1, String string2, char character) {
        return string1.indexOf(character) == string2.indexOf(character);
    }

    public static boolean isSameLastCharPosition(String string1, String string2, char character) {
        return string1.lastIndexOf(character) == string2.lastIndexOf(character);
    }

    public static boolean isSameFirstStringPosition(String string1, String string2, String str) {
        return string1.indexOf(str) == string2.indexOf(str);
    }

    public static boolean isSameLastStringPosition(String string1, String string2, String str) {
        return string1.lastIndexOf(str) == string2.lastIndexOf(str);
    }

    public static boolean isEqual(String string1, String string2) {
        return string1.equals(string2);
    }

    public static boolean isEqualIgnoreCase(String string1, String string2) {
        return string1.equalsIgnoreCase(string2);
    }

    public static boolean isLess(String string1, String string2) {
        return string1.compareTo(string2) < 0;
    }

    public static boolean isLessIgnoreCase(String string1, String string2) {
        return string1.compareToIgnoreCase(string2) < 0;
    }

    public static String concat(String string1, String string2) {
        return string1.concat(string2);
    }

    public static boolean isSamePrefix(String string1, String string2, String prefix) {
        return string1.startsWith(prefix) && string2.startsWith(prefix);
    }

    public static boolean isSameSuffix(String string1, String string2, String suffix) {
        return string1.endsWith(suffix) && string2.endsWith(suffix);
    }

    public static String getCommonPrefix(String string1, String string2) {
        int length = Math.min(string1.length(), string2.length());
        int index = 0;

        while (index < length && string1.charAt(index) == string2.charAt(index)) {
            index++;
        }

        return string1.substring(0, index);
    }

    public static String reverse(String string) {
        return new StringBuilder(string).reverse().toString();
    }

    public static boolean isPalindrome(String string) {
        return string.equals(reverse(string));
    }

    public static boolean isPalindromeIgnoreCase(String string) {
        return string.equalsIgnoreCase(reverse(string));
    }

    public static String getLongestPalindromeIgnoreCase(String[] strings) {
        String longestPalindrome = "";

        for (String string : strings) {
            if (isPalindromeIgnoreCase(string)
                    && string.length() > longestPalindrome.length()) {
                longestPalindrome = string;
            }
        }

        return longestPalindrome;
    }

    public static boolean hasSameSubstring(String string1, String string2, int index, int length) {
        if (index + length > string1.length()
                || index + length > string2.length()) {
            return false;
        }

        String substring1 = string1.substring(index, index + length);
        String substring2 = string2.substring(index, index + length);

        return substring1.equals(substring2);
    }

    public static boolean isEqualAfterReplaceCharacters(
            String string1,
            char replaceInStr1,
            char replaceByInStr1,
            String string2,
            char replaceInStr2,
            char replaceByInStr2
    ) {
        String result1 = string1.replace(replaceInStr1, replaceByInStr1);
        String result2 = string2.replace(replaceInStr2, replaceByInStr2);

        return result1.equals(result2);
    }

    public static boolean isEqualAfterReplaceStrings(
            String string1,
            String replaceInStr1,
            String replaceByInStr1,
            String string2,
            String replaceInStr2,
            String replaceByInStr2
    ) {
        String result1 = string1.replace(replaceInStr1, replaceByInStr1);
        String result2 = string2.replace(replaceInStr2, replaceByInStr2);

        return result1.equals(result2);
    }

    public static boolean isPalindromeAfterRemovingSpacesIgnoreCase(String string) {
        String withoutSpaces = string.replace(" ", "");
        return isPalindromeIgnoreCase(withoutSpaces);
    }

    public static boolean isEqualAfterTrimming(String string1, String string2) {
        return string1.trim().equals(string2.trim());
    }

    public static String makeCsvStringFromInts(int[] array) {
        return makeCsvStringBuilderFromInts(array).toString();
    }

    public static String makeCsvStringFromDoubles(double[] array) {
        return makeCsvStringBuilderFromDoubles(array).toString();
    }

    public static StringBuilder makeCsvStringBuilderFromInts(int[] array) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < array.length; i++) {
            if (i > 0) {
                result.append(',');
            }
            result.append(array[i]);
        }

        return result;
    }

    public static StringBuilder makeCsvStringBuilderFromDoubles(double[] array) {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < array.length; i++) {
            if (i > 0) {
                result.append(',');
            }
            result.append(String.format(Locale.US, "%.2f", array[i]));
        }

        return result;
    }

    public static StringBuilder removeCharacters(String string, int[] positions) {
        StringBuilder result = new StringBuilder(string);

        for (int i = positions.length - 1; i >= 0; i--) {
            result.deleteCharAt(positions[i]);
        }

        return result;
    }

    public static StringBuilder insertCharacters(
            String string,
            int[] positions,
            char[] characters
    ) {
        StringBuilder result = new StringBuilder();
        int positionIndex = 0;

        for (int i = 0; i <= string.length(); i++) {
            while (positionIndex < positions.length
                    && positions[positionIndex] == i) {
                result.append(characters[positionIndex]);
                positionIndex++;
            }

            if (i < string.length()) {
                result.append(string.charAt(i));
            }
        }

        return result;
    }
}
