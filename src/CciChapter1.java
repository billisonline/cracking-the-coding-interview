package com.billyanelli.cci;

import java.util.*;

public class CciChapter1
{
    public static void main(String[] args)
    {
        System.out.println("Hello world");
    }

    /**
     * Implement an algorithm to determine if a string has all unique characters.
     *
     * Should be O(N)
     *
     * @param str
     * @return
     */
    public boolean question1AllUnique(String str)
    {
        Map<Character, Boolean> charMap = new HashMap<>();

        for (char currentChar : str.toCharArray()) {
            if (charMap.containsKey(currentChar)) {
                return false;
            }

            charMap.put(currentChar, true);
        }

        return true;
    }

    /**
     * Given two strings, write a method to determine if one is a permutation of the other.
     *
     * Should be O(2N)
     *
     * @param string1
     * @param string2
     * @return
     */
    public boolean question2CheckPermutation(String string1, String string2)
    {
        Map<Character, Boolean> string1CharMap = new HashMap<>();

        for (char currentChar : string1.toCharArray()) {
            string1CharMap.put(currentChar, true);
        }

        for (char currentChar : string2.toCharArray()) {
            if (!string1CharMap.containsKey(currentChar)) {
                return false;
            }
        }

        return true;
    }

    /**
     * Write a method to replace all spaces in a string with "%20".
     *
     * Should be O(N)
     *
     * @param str the input string
     * @return "URLified" string
     */
    public String question3UrlifyString(String str)
    {
        StringBuilder out = new StringBuilder();

        for (char currentChar : str.toCharArray()) {
            if (currentChar == ' ') {
                out.append("%20");
            } else {
                out.append(currentChar);
            }
        }

        return out.toString();
    }

    /**
     * Given a string, write a function to check if it is a permutation of a palindrome.
     *
     * Should be O(2N)
     *
     * @param str
     * @return
     */
    public boolean question4CheckPalindrome(String str)
    {
        // String must not be even; palindrome must have "central" character with equal number on each side
        if ((str.length() % 2) == 0) {
            return false;
        }

        Map<Character, Integer> charCount = new HashMap<>();

        for (char currentChar : str.toCharArray()) {
            int existingCount = 0;

            if (charCount.containsKey(currentChar)) {
                existingCount = charCount.get(currentChar);
            }

            charCount.put(currentChar, existingCount + 1);
        }

        int uniqueCharsCount = charCount.keySet().size();
        int oddCharsCount = 0;
        int evenCharsCount = 0;

        for (char currentChar : charCount.keySet()) {
            Integer currentCharCount = charCount.get(currentChar);

            if ((currentCharCount % 2) == 0) {
                evenCharsCount++;
            } else {
                oddCharsCount++;
            }
        }

        return (
                (evenCharsCount == (uniqueCharsCount - 1))
                && (oddCharsCount == 1)
        );
    }

    public boolean question5OneAway(String string1, String string2) {
        int greaterLength = (
                (string1.length() > string2.length())
                        ? string1.length()
                        : string2.length()
        );

        boolean stringLengthsDiffer = (string1.length() != string2.length());

        int string1LastIndex = string1.length() - 1;
        int string2LastIndex = string2.length() - 1;

        int string1Shift = 0;
        int string2Shift = 0;

        int gapsFound = 0;
        int differencesFound = 0;

        for (int i = 0; i < greaterLength; i++) {
            int string1Index = i + string1Shift;
            int string2Index = i + string2Shift;

            Character string1CurrentChar = (
                    (string1Index <= string1LastIndex)
                            ? string1.charAt(string1Index)
                            : null
            );

            Character string2CurrentChar = (
                    (string2Index <= string2LastIndex)
                            ? string2.charAt(string2Index)
                            : null
            );

            Character string1NextChar = (
                    ((string1Index + 1) <= string1LastIndex)
                            ? string1.charAt(string1Index + 1)
                            : null
            );

            Character string2NextChar = (
                    ((string2Index + 1) <= string2LastIndex)
                            ? string2.charAt(string2Index + 1)
                            : null
            );

            // If the chars are the same, do nothing
            if (string1CurrentChar == string2CurrentChar) {

            }

            // If string1 next char == string2 current char, record a gap in string2 (shift remaining indexes in string2)
            // Example: i = 1; string1 = "pale"; string2 = "ple"
            else if (stringLengthsDiffer && (string1NextChar == string2CurrentChar)) {
                gapsFound++;
                string2Shift--;
            }

            // If string2 next char == string1 current char, record a gap in string1 (shift remaining indexes in string1)
            // Example: i = 1; string1 = "ple"; string2 = "pale"
            else if (stringLengthsDiffer && (string2NextChar == string1CurrentChar)) {
                gapsFound++;
                string1Shift--;
            }

            else {
                differencesFound++;
            }
        }

        return ((gapsFound + differencesFound) <= 1);
    }
}
