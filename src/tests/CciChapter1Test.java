package com.billyanelli.cci.tests;

import com.billyanelli.cci.CciChapter1;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CciChapter1Test {
    private final CciChapter1 chapter1;

    CciChapter1Test() {
        chapter1 = new CciChapter1();
    }

    @Test
    void question1AllUniqueTest()
    {
        assertFalse(chapter1.question1AllUnique("repeated"));
        assertTrue(chapter1.question1AllUnique("12345"));
    }

    @Test
    void question2CheckPermutationTest()
    {
        assertTrue(chapter1.question2CheckPermutation("", ""));
        assertTrue(chapter1.question2CheckPermutation("test", "sets"));
        assertFalse(chapter1.question2CheckPermutation("true", "false"));
    }

    @Test
    void question3UrlifyStringTest()
    {
        assertEquals("Mr%20John%20Smith", chapter1.question3UrlifyString("Mr John Smith"));
    }

    @Test
    void question4CheckPalindromeTest()
    {
        assertTrue(chapter1.question4CheckPalindrome("tactcoa")); // taco cat
        assertTrue(chapter1.question4CheckPalindrome("planamanacanalapanama")); // a man, a plan, a canal, panama
        assertTrue(chapter1.question4CheckPalindrome("carrace")); // race car
        assertFalse(chapter1.question4CheckPalindrome("lsfjiejwoifjc"));
    }

    @Test
    void question5OneAwayTest()
    {
        assertTrue(chapter1.question5OneAway("pale", "pale"));
        assertTrue(chapter1.question5OneAway("pale", "ple"));
        assertTrue(chapter1.question5OneAway("ple", "pale"));
        assertTrue(chapter1.question5OneAway("pales", "pale"));
        assertTrue(chapter1.question5OneAway("ale", "pale"));
        assertTrue(chapter1.question5OneAway("pale", "bale"));
        assertFalse(chapter1.question5OneAway("pale", "bake"));
        assertFalse(chapter1.question5OneAway("wfjweoif", "zzz"));
    }
}
