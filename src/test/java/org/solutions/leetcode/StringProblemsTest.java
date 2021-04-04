package org.solutions.leetcode;

import org.apache.commons.lang3.tuple.Pair;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.solutions.leetcode.exceptions.BadInputException;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class StringProblemsTest {

    static StringProblems stringProblems;

    @BeforeAll
    static void setUp() {
        stringProblems = new StringProblems();
    }

    @Test
    void testShortestToChar() {
        Map<Pair<String, Character>, int[]> scenarios = new HashMap<>();
        scenarios.put(Pair.of("loveleetcode", 'e'), new int[]{3, 2, 1, 0, 1, 0, 0, 1, 2, 2, 1, 0});
        scenarios.put(Pair.of("aaab", 'b'), new int[]{3, 2, 1, 0});
        scenarios.put(Pair.of("aaab", 'a'), new int[]{0, 0, 0, 1});
        scenarios.put(Pair.of("a", 'a'), new int[]{0});

        scenarios.forEach((input, expected) ->
                assertArrayEquals(expected, stringProblems.shortestToChar(input.getLeft(), input.getRight())));
    }

    @Test
    void testIsAnagram() {
        Map<Pair<String, String>, Boolean> scenarios = new HashMap<>();
        scenarios.put(Pair.of("anagram", "nagamar"), true);
        scenarios.put(Pair.of("anagram", "aaaagrm"), false);
        scenarios.put(Pair.of("ram", "hello"), false);

        scenarios.forEach((input, expected) ->
                assertEquals(expected, stringProblems.isAnagram(input.getLeft(), input.getRight())));
    }

    @Test
    void testMinimumLengthEncoding() {
        Map<String[], Integer> scenarios = new HashMap<>();
        scenarios.put(new String[]{"time", "me", "bell"}, 10);
        scenarios.put(new String[]{"t"}, 2);

        scenarios.forEach((input, expected) -> assertEquals(expected, stringProblems.minimumLengthEncoding(input)));
    }

    @Test
    void testHasAllCodes() {
        Map<Pair<String, Integer>, Boolean> scenarios = new HashMap<>();
        scenarios.put(Pair.of("00110110", 2), true);
        scenarios.put(Pair.of("00110", 2), true);
        scenarios.put(Pair.of("00110", 1), true);
        scenarios.put(Pair.of("0110", 2), false);
        scenarios.put(Pair.of("0000000001011100", 4), false);

        scenarios.forEach((input, expected) ->
                assertEquals(expected, stringProblems.hasAllCodes(input.getLeft(), input.getRight())));
    }

    @Test
    void testWordSubsets() {
        Map<Pair<String[], String[]>, List<String>> scenarios = new HashMap<>();
        String[] A = {"amazon", "apple", "facebook", "google", "leetcode"};

        scenarios.put(Pair.of(A, new String[]{"e", "o"}), Arrays.asList("facebook", "google", "leetcode"));
        scenarios.put(Pair.of(A, new String[]{"e", "l"}), Arrays.asList("apple", "google", "leetcode"));
        scenarios.put(Pair.of(A, new String[]{"e", "oo"}), Arrays.asList("google", "facebook"));
        scenarios.put(Pair.of(A, new String[]{"eo", "lo"}), Arrays.asList("google", "leetcode"));
        scenarios.put(Pair.of(A, new String[]{"ec", "oc", "ceo"}), Arrays.asList("facebook", "leetcode"));

        scenarios.forEach((input, expected) -> {
                    try {
                        assertTrue(stringProblems.wordSubsets(input.getLeft(), input.getRight()).containsAll(expected));
                    } catch (BadInputException e) {
                        e.printStackTrace();
                    }
                }
        );
    }

    @Test
    void testCountSubstrings() {
        Map<String, Integer> scenarios = new HashMap<>();
        scenarios.put("abc", 3);
        scenarios.put("aaa", 6);

        scenarios.forEach((input, expected) -> assertEquals(expected, stringProblems.countSubstrings(input)));
    }

    @Test
    void testLetterCasePermutation() {
        Map<String, List<String>> scenarios = new HashMap<>();
        scenarios.put("abc", Arrays.asList("abc", "Abc", "aBc", "abC", "aBC", "AbC", "ABC", "ABc"));
        scenarios.put("ab9", Arrays.asList("ab9", "Ab9", "aB9", "AB9"));
        scenarios.put("AB9", Arrays.asList("ab9", "Ab9", "aB9", "AB9"));
        scenarios.put("aB9", Arrays.asList("ab9", "Ab9", "aB9", "AB9"));

        scenarios.forEach((input, expected) -> assertTrue(expected.containsAll(stringProblems.letterCasePermutation(input))));
    }
}