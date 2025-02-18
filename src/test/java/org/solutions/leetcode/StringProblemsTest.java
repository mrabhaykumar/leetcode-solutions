package org.solutions.leetcode;

import org.apache.commons.lang3.tuple.Pair;
import org.apache.commons.lang3.tuple.Triple;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.solutions.leetcode.exceptions.BadInputException;

import java.util.*;

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

        scenarios.forEach((input, expected) ->
                assertTrue(expected.containsAll(stringProblems.letterCasePermutation(input))));
    }

    @Test
    void testFindMaxForm() {
        Map<Triple<String[], Integer, Integer>, Integer> scenarios = new HashMap<>();
        scenarios.put(Triple.of(new String[]{"10", "0", "1"}, 1, 1), 2);
        scenarios.put(Triple.of(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3), 4);

        scenarios.forEach((input, expected) -> assertEquals(expected,
                stringProblems.findMaxForm(input.getLeft(), input.getMiddle(), input.getRight())));
    }

    @Test
    void testLongestValidParentheses() {
        Map<String, Integer> scenarios = new HashMap<>();
        scenarios.put("(()))", 4);
        scenarios.put("())", 2);
        scenarios.put(")()())", 4);
        scenarios.put("(((((((", 0);
        scenarios.put("", 0);

        scenarios.forEach((input, expected) -> assertEquals(expected, stringProblems.longestValidParentheses(input)));
    }

    @Test
    void testHalvesAreAlike() {
        Map<String, Boolean> scenarios = new HashMap<>();
        scenarios.put("textbank", true);
        scenarios.put("book", true);
        scenarios.put("textbook", false);
        scenarios.put("ABCdef", true);

        scenarios.forEach((input, expected) -> assertEquals(expected, stringProblems.halvesAreAlike(input)));
    }

    @Test
    void testRemoveDuplicates() {
        Map<String, String> scenarios = new HashMap<>();
        scenarios.put("abbaca", "ca");
        scenarios.put("aabccbe", "e");

        scenarios.forEach((input, expected) -> assertEquals(expected, stringProblems.removeDuplicates(input)));
    }

    @Test
    void testRemoveKDuplicates() {
        Map<Pair<String, Integer>, String> scenarios = new HashMap<>();
        scenarios.put(Pair.of("abcd", 2), "abcd");
        scenarios.put(Pair.of("deeedbbcccbdaa", 3), "aa");
        scenarios.put(Pair.of("pbbcggttciiippooaais", 2), "ps");

        scenarios.forEach((input, expected) ->
                assertEquals(expected, stringProblems.removeDuplicates(input.getLeft(), input.getRight())));
    }

    @Test
    void testCountBinarySubstrings() {
        Map<String, Integer> scenarios = new HashMap<>();
        scenarios.put("00110", 3);
        scenarios.put("00110011", 6);
        scenarios.put("10101", 4);
        scenarios.put("00011100", 5);

        scenarios.forEach((input, expected) -> assertEquals(expected, stringProblems.countBinarySubstrings(input)));
    }

    @Test
    void testBulbSwitcherIV() {
        Map<String, Integer> scenarios = new HashMap<>();
        scenarios.put("101", 3);
        scenarios.put("10111", 3);
        scenarios.put("0100", 2);

        scenarios.forEach((input, expected) -> assertEquals(expected, stringProblems.bulbSwitcherIV(input)));
    }

    @Test
    void testRemoveSubfolders() {
        Map<String[], List<String>> scenarios = new HashMap<>();
        scenarios.put(new String[]{"/a", "/a/b", "/c/d", "/c/d/e", "/c/f"}, Arrays.asList("/a", "/c/d", "/c/f"));
        scenarios.put(new String[]{"/a", "/a/b/c", "/a/b/d"}, Collections.singletonList("/a"));

        scenarios.forEach((input, expected) -> assertTrue(expected.containsAll(stringProblems.removeSubfolders(input))));
    }

    @Test
    void testMinDeletions() {
        Map<String, Integer> scenarios = new HashMap<>();
        scenarios.put("aaabbc", 0);
        scenarios.put("aaabbbccc", 3);
        scenarios.put("aaabbbcc", 2);
        scenarios.put("qwertyuiopasdfghjklzxcvbnm", 25);

        scenarios.forEach((input, expected) -> assertEquals(expected, stringProblems.minDeletions(input)));
    }

    @Test
    void testLongestStrChain() {
        Map<String[], Integer> scenarios = new HashMap<>();
        scenarios.put(new String[]{"xbc", "pcxbcf", "xb", "cxbc", "pcxbc"}, 5);
        scenarios.put(new String[]{"a", "b", "ba", "bca", "bda", "bdca"}, 4);

        scenarios.forEach((input, expected) -> assertEquals(expected, stringProblems.longestStrChain(input)));
    }

    @Test
    void testFindDuplicate() {
        Map<String[], List<List<String>>> scenarios = new HashMap<>();
        scenarios.put(
                new String[]{
                        "root/a 1.txt(abcd) 2.txt(efgh)",
                        "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)",
                        "root 4.txt(efgh)"
                },
                Arrays.asList(
                        Arrays.asList("root/a/2.txt", "root/c/d/4.txt", "root/4.txt"),
                        Arrays.asList("root/a/1.txt", "root/c/3.txt"))
        );

        scenarios.put(
                new String[]{
                        "root/a 1.txt(abcd) 2.txt(efgh)",
                        "root/c 3.txt(abcd)",
                        "root/c/d 4.txt(efgh)"
                },
                Arrays.asList(
                        Arrays.asList("root/a/2.txt", "root/c/d/4.txt"),
                        Arrays.asList("root/a/1.txt", "root/c/3.txt"))
        );

        scenarios.put(
                new String[]{
                        "root/a 1.txt(abcd)",
                        "root/c 3.txt(efgh)"
                },
                Arrays.asList(
                        Collections.singletonList("root/a/1.txt"),
                        Collections.singletonList("root/c/3.txt"))
        );

        scenarios.forEach((input, expected) -> assertEquals(
                stringProblems.findDuplicate(input).stream()
                        .filter(i -> !expected.contains(i))
                        .count(),
                0));
    }

    @Test
    void testFindAndReplacePattern() {
        Map<Pair<String[], String>, List<String>> scenarios = new HashMap<>();
        scenarios.put(Pair.of(new String[]{"abc", "deq", "mee", "aqq", "dkd", "ccc"}, "abb"), Arrays.asList("mee", "aqq"));
        scenarios.put(Pair.of(new String[]{"a", "b", "c"}, "a"), Arrays.asList("a", "b", "c"));

        scenarios.forEach((input, expected) -> {
            assertTrue(expected.containsAll(stringProblems.findAndReplacePattern(input.getLeft(), input.getRight())));
        });
    }

    @Test
    void testEvalRPN() {
        Map<String[], Integer> scenarios = new HashMap<>();
        scenarios.put(new String[]{"2", "1", "+", "3", "*"}, 9);
        scenarios.put(new String[]{"4", "13", "5", "/", "+"}, 6);
        scenarios.put(new String[]{"4", "13", "5", "-", "+"}, 12);

        scenarios.forEach((input, expected) -> assertEquals(expected, stringProblems.evalRPN(input)));
    }

    @Test
    void testMinPartitions() {
        Map<String, Integer> scenarios = new HashMap<>();
        scenarios.put("32", 3);
        scenarios.put("12345678", 8);
        scenarios.put("27346209830709182346", 9);

        scenarios.forEach((input, expected) -> assertEquals(expected, stringProblems.minPartitions(input)));
    }

    @Test
    void testLengthOfLongestSubstring() {
        Map<String, Integer> scenarios = new HashMap<>();
        scenarios.put("abcabcbb", 3);
        scenarios.put("bbbbb", 1);
        scenarios.put(" ", 1);

        scenarios.forEach((input, expected) -> assertEquals(expected, stringProblems.lengthOfLongestSubstring(input)));
    }

    @Test
    void testOpenLock() {
        Map<Pair<String[], String>, Integer> scenarios = new HashMap<>();
        scenarios.put(Pair.of(new String[]{"0201", "0101", "0102", "1212", "2002"}, "0202"), 6);
        scenarios.put(Pair.of(new String[]{"0201", "0101", "0102", "1212", "2002"}, "0000"), 0);
        scenarios.put(Pair.of(new String[]{"8888"}, "0009"), 1);
        scenarios.put(Pair.of(new String[]{"8887", "8889", "8878", "8898", "8788", "8988", "7888", "9888"}, "8888"), -1);
        scenarios.put(Pair.of(new String[]{"0000"}, "8888"), -1);

        scenarios.forEach((input, expected) -> assertEquals(expected,
                stringProblems.openLock(input.getLeft(), input.getRight())));
    }
}
