package org.solutions.leetcode;

import org.apache.commons.lang3.tuple.Pair;
import org.apache.commons.lang3.tuple.Triple;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ArrayProblemsTest {

    static ArrayProblems arrayProblems;

    @BeforeAll
    static void setup() {
        arrayProblems = new ArrayProblems();
    }

    @Test
    void findLHS() {
        Map<int[], Integer> scenarios = new HashMap<>();
        scenarios.put(new int[]{-3, -1, -1, -1, -3, -2}, 4);
        scenarios.put(new int[]{1, 2, 2, 3, 4, 5, 1, 1, 1, 1}, 7);
        scenarios.put(new int[]{2, 2, 2, 2, 2, 2, 2, 3, 1, 0, 0, 0, 3, 1, -1, 0, 1, 1, 0, 0, 1, 1, 2, 2,
                2, 0, 1, 2, 2, 3, 2}, 20);
        scenarios.put(new int[]{1, 3, 2, 2, 5, 2, 3, 7}, 5);
        scenarios.put(new int[]{1, 2, 3, 4}, 2);
        scenarios.put(new int[]{1, 1, 1, 1}, 0);

        List<String> ways = Arrays.asList("brute-force", "sorting", "hashmap");

        scenarios.forEach((input, length) -> {
            ways.forEach(way -> assertEquals(length, arrayProblems.findLHS(input, way)));
            assertEquals(-1, arrayProblems.findLHS(input, "garbage"));
        });
    }

    @Test
    void testCanFormArray() {
        Map<Pair<int[], int[][]>, Boolean> scenarios = new HashMap<>();
        scenarios.put(Pair.of(new int[]{85}, new int[][]{{85}}), true);
        scenarios.put(Pair.of(new int[]{15, 88}, new int[][]{{88}, {15}}), true);
        scenarios.put(Pair.of(new int[]{49, 18, 16}, new int[][]{{16, 18, 49}}), false);
        scenarios.put(Pair.of(new int[]{49, 18, 16}, new int[][]{{49, 18, 17}}), false);
        scenarios.put(Pair.of(new int[]{91, 4, 64, 78}, new int[][]{{78}, {4, 64}, {91}}), true);
        scenarios.put(Pair.of(new int[]{1, 3, 5, 7}, new int[][]{{2, 4, 6, 8}}), false);

        scenarios.forEach((input, expected) ->
                assertEquals(expected, arrayProblems.canFormArray(input.getLeft(), input.getRight())));
    }

    @Test
    void testMaxWaterContainerArea() {
        Map<int[], Integer> scenarios = new HashMap<>();
        scenarios.put(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}, 49);
        scenarios.put(new int[]{1, 1}, 1);
        scenarios.put(new int[]{4, 3, 2, 1, 4}, 16);
        scenarios.put(new int[]{1, 2, 1}, 2);

        scenarios.forEach((input, expected) -> assertEquals(expected, arrayProblems.maxWaterContainerArea(input)));
    }

    @Test
    void testNumberOfArithmeticSlices() {
        Map<int[], Integer> scenarios = new HashMap<>();
        scenarios.put(new int[]{1, 2, 3, 4}, 3);
        scenarios.put(new int[]{1, 2, 3, 8, 9, 10}, 2);

        scenarios.forEach((input, expected) -> assertEquals(expected, arrayProblems.numberOfArithmeticSlices(input)));
    }

    @Test
    void testMaxProfit2() {
        Map<int[], Integer> scenarios = new HashMap<>();
        scenarios.put(new int[]{7, 1, 5, 3, 6, 4}, 7);
        scenarios.put(new int[]{1, 2, 3, 4, 5}, 4);
        scenarios.put(new int[]{5, 4, 3, 2, 1}, 0);
        scenarios.put(new int[]{5}, 0);
        scenarios.put(null, 0);

        scenarios.forEach((input, expected) -> assertEquals(expected, arrayProblems.maxProfit2(input)));
    }

    @Test
    void testMaxProfit5() {
        Map<Pair<Integer, int[]>, Integer> scenarios = new HashMap<>();
        scenarios.put(Pair.of(2, new int[]{1, 3, 2, 8, 4, 9}), 8);
        scenarios.put(Pair.of(3, new int[]{1, 3, 7, 5, 10, 3}), 6);

        scenarios.forEach((input, expected) ->
                assertEquals(expected, arrayProblems.maxProfit5(input.getLeft(), input.getRight())));
    }

    @Test
    void testThreeSumMulti() {
        Map<Pair<int[], Integer>, Integer> scenarios = new HashMap<>();
        scenarios.put(Pair.of(new int[]{1, 1, 2, 2, 3, 3, 4, 4, 5, 5}, 8), 20);
        scenarios.put(Pair.of(new int[]{1, 1, 2, 2, 2, 2}, 5), 12);
        scenarios.put(Pair.of(new int[]{1, 0, 1, 0, 2, 1, 2}, 1), 3);

        scenarios.forEach((input, expected) ->
                assertEquals(expected, arrayProblems.threeSumMulti(input.getLeft(), input.getRight())));
    }

    @Test
    void Count() {
        Map<Pair<int[], int[]>, int[]> scenarios = new HashMap<>();
        scenarios.put(Pair.of(new int[]{2, 7, 11, 15}, new int[]{1, 10, 4, 11}), new int[]{2, 11, 7, 15});
        scenarios.put(Pair.of(new int[]{12, 24, 8, 32}, new int[]{13, 25, 32, 11}), new int[]{24, 32, 8, 12});
        scenarios.put(Pair.of(new int[]{3, 3, 4, 4}, new int[]{2, 2, 3, 3}), new int[]{3, 3, 4, 4});

        scenarios.forEach((input, expected) -> {
            assertArrayEquals(expected, arrayProblems.advantageCount(input.getLeft(), input.getRight()));
        });
    }

    @Test
    void testIsIdealPermutation() {
        Map<int[], Boolean> scenarios = new HashMap<>();
        scenarios.put(new int[]{1, 0, 2}, true);
        scenarios.put(new int[]{1, 2, 0}, false);

        scenarios.forEach((input, expected) -> assertEquals(expected, arrayProblems.isIdealPermutation(input)));
    }

    @Test
    void testLargestRectangleArea() {
        Map<int[], Integer> scenarios = new HashMap<>();
        scenarios.put(new int[]{2, 1, 5, 6, 2, 3}, 10);

        scenarios.forEach((input, expected) -> assertEquals(expected, arrayProblems.largestRectangleArea(input)));
    }

    @Test
    void testFurthestBuilding() {
        Map<Triple<int[], Integer, Integer>, Integer> scenarios = new HashMap<>();
        scenarios.put(Triple.of(new int[]{4, 2, 7, 6, 9, 14, 12}, 5, 1), 4);
        scenarios.put(Triple.of(new int[]{4, 12, 2, 7, 3, 18, 20, 3, 19}, 10, 2), 7);
        scenarios.put(Triple.of(new int[]{14, 3, 19, 3}, 17, 0), 3);

        scenarios.forEach((input, expected) ->
                assertEquals(expected,
                        arrayProblems.furthestBuilding(input.getLeft(), input.getMiddle(), input.getRight())));
    }

    @Test
    void testSearchRange() {
        Map<Pair<int[], Integer>, int[]> scenarios = new HashMap<>();
        scenarios.put(Pair.of(new int[]{5, 7, 7, 8, 8, 10}, 8), new int[]{3, 4});
        scenarios.put(Pair.of(new int[]{5, 7, 7, 8, 8, 10}, 6), new int[]{-1, -1});
        scenarios.put(Pair.of(new int[]{}, 0), new int[]{-1, -1});

        scenarios.forEach((input, expected) ->
                assertArrayEquals(expected, arrayProblems.searchRange(input.getLeft(), input.getRight())));
    }

    @Test
    void testRunningSum() {
        Map<int[], int[]> scenarios = new HashMap<>();
        scenarios.put(new int[]{1, 1, 1, 1, 1}, new int[]{1, 2, 3, 4, 5});
        scenarios.put(new int[]{1, 2, 3, 4, 5}, new int[]{1, 3, 6, 10, 15});

        scenarios.forEach((input, expected) -> assertArrayEquals(expected, arrayProblems.runningSum(input)));
    }

    @Test
    void testCheckPossibility() {
        Map<int[], Boolean> scenarios = new HashMap<>();
        scenarios.put(new int[]{3, 4, 2, 3}, false);
        scenarios.put(new int[]{4, 2, 3}, true);
        scenarios.put(new int[]{-1, 4, 2, 3}, true);

        scenarios.forEach((input, expected) -> assertEquals(expected, arrayProblems.checkPossibility(input)));
    }

    @Test
    void testJumpGame() {
        Map<int[], Boolean> scenarios = new HashMap<>();
        scenarios.put(new int[]{2, 3, 1, 1, 4}, true);
        scenarios.put(new int[]{2, 1, 1, 0, 4}, false);
        scenarios.put(new int[]{}, true);
        scenarios.put(null, true);

        scenarios.forEach((input, expected) -> assertEquals(expected, arrayProblems.jumpGame(input)));
    }

    @Test
    void testJumpGameII() {
        Map<int[], Integer> scenarios = new HashMap<>();
        scenarios.put(new int[]{2, 3, 1, 1, 4}, 2);
        scenarios.put(new int[]{2, 3, 0, 1, 4}, 2);
        scenarios.put(new int[]{}, 0);
        scenarios.put(null, 0);

        scenarios.forEach((input, expected) -> assertEquals(expected, arrayProblems.jumpGameII(input)));
    }

    @Test
    void testIsPossibleToConstructTargetArray() {
        Map<int[], Boolean> scenarios = new HashMap<>();
        scenarios.put(new int[]{1, 1, 1, 2}, false);
        scenarios.put(new int[]{3, 5, 9}, true);

        scenarios.forEach((input, expected) -> assertEquals(expected, arrayProblems.isPossibleToConstructTargetArray(input)));
    }

    @Test
    void testMaxScore() {
        Map<Pair<int[], Integer>, Integer> scenarios = new HashMap<>();
        scenarios.put(Pair.of(new int[]{1, 2, 3, 4, 5, 6, 1}, 3), 12);
        scenarios.put(Pair.of(new int[]{9, 7, 7, 9, 7, 7, 9}, 7), 55);
        scenarios.put(Pair.of(new int[]{1, 79, 80, 1, 1, 1, 200, 1}, 3), 202);

        scenarios.forEach((input, expected) ->
                assertEquals(expected, arrayProblems.maxScore(input.getLeft(), input.getRight())));
    }

    @Test
    void testMinMoves() {
        Map<int[], Integer> scenarios = new HashMap<>();
        scenarios.put(new int[]{1, 2, 3}, 3);
        scenarios.put(new int[]{1, 1, 1, 9}, 8);
        scenarios.put(new int[]{1, 1, 1}, 0);

        scenarios.forEach((input, expected) -> assertEquals(expected, arrayProblems.minMoves(input)));
    }

    @Test
    void testMinMoves2() {
        Map<int[], Integer> scenarios = new HashMap<>();
        scenarios.put(new int[]{1, 2, 3}, 2);
        scenarios.put(new int[]{1, 10, 2, 9}, 16);

        scenarios.forEach((input, expected) -> assertEquals(expected, arrayProblems.minMoves2(input)));
    }

    @Test
    void testSubsetXORSum() {
        Map<int[], Integer> scenarios = new HashMap<>();
        scenarios.put(new int[]{1, 3}, 6);
        scenarios.put(new int[]{1, 5, 6}, 28);

        scenarios.forEach((input, expected) -> assertEquals(expected, arrayProblems.subsetXORSum(input)));
    }

    @Test
    void testMaximumUniqueSubarray() {
        Map<int[], Integer> scenarios = new HashMap<>();
        scenarios.put(new int[]{5, 2, 1, 2, 5, 2, 1, 2, 5}, 8);
        scenarios.put(new int[]{4, 2, 4, 5, 6}, 17);
        scenarios.put(new int[]{1, 1, 1}, 1);
        scenarios.put(new int[]{1, 1, 1, 2, 2, 2}, 3);
        scenarios.put(new int[]{1, 2, 3}, 6);
        scenarios.put(new int[]{1, 2, 2}, 3);

        scenarios.forEach((input, expected) -> assertEquals(expected, arrayProblems.maximumUniqueSubarray(input)));
    }

    @Test
    void testMaxProduct() {
        Map<String[], Integer> scenarios = new HashMap<>();
        scenarios.put(new String[]{"abcw", "baz", "foo", "bar", "xtfn", "abcdef"}, 16);
        scenarios.put(new String[]{"a", "ab", "abc", "d", "cd", "bcd", "abcd"}, 4);
        scenarios.put(new String[]{"a", "aa", "aaa", "aaaa"}, 0);

        scenarios.forEach((input, expected) -> assertEquals(expected, arrayProblems.maxProduct(input)));
    }

    @Test
    void testMaxArea() {
        Map<Pair<Pair<Integer, Integer>, Pair<int[], int[]>>, Integer> scenarios = new HashMap<>();
        scenarios.put(Pair.of(Pair.of(5, 4), Pair.of(new int[]{3, 1}, new int[]{1})), 6);
        scenarios.put(Pair.of(Pair.of(5, 4), Pair.of(new int[]{3}, new int[]{3})), 9);
        scenarios.put(Pair.of(Pair.of(5, 4), Pair.of(new int[]{1, 2, 4}, new int[]{1, 3})), 4);

        scenarios.forEach((input, expected) -> assertEquals(expected,
                arrayProblems.maxArea(input.getLeft().getLeft(), input.getLeft().getRight(),
                        input.getRight().getLeft(), input.getRight().getRight())));
    }

    @Test
    void testMaxDistToClosest() {
        Map<int[], Integer> scenarios = new HashMap<>();
        scenarios.put(new int[]{1, 0, 0, 0, 1, 0, 1}, 2);
        scenarios.put(new int[]{1, 0, 0, 0}, 3);
        scenarios.put(new int[]{0, 1}, 1);

        scenarios.forEach((input, expected) -> assertEquals(expected, arrayProblems.maxDistToClosest(input)));
    }

    @Test
    void testMaxSumRangeQuery() {
        Map<Pair<int[], int[][]>, Integer> scenarios = new HashMap<>();
        scenarios.put(Pair.of(new int[]{1, 2, 3, 4, 5}, new int[][]{{1, 3}, {0, 1}}), 19);
        scenarios.put(Pair.of(new int[]{1, 2, 3, 4, 5, 6}, new int[][]{{0, 1}}), 11);
        scenarios.put(Pair.of(new int[]{1, 2, 3, 4, 5, 10}, new int[][]{{0, 2}, {1, 3}, {1, 1}}), 47);
        scenarios.put(Pair.of(new int[]{1, 4, 5}, new int[][]{{0, 2}, {0, 1}, {1, 2}}), 25);

        scenarios.forEach((input, expected) -> assertEquals(expected,
                arrayProblems.maxSumRangeQuery(input.getLeft(), input.getRight())));
    }

    @Test
    void testMaxPerformance() {
        Map<Pair<Pair<Integer, Integer>, Pair<int[], int[]>>, Integer> scenarios = new HashMap<>();
        scenarios.put(Pair.of(Pair.of(6, 2), Pair.of(new int[]{2, 10, 3, 1, 5, 8}, new int[]{5, 4, 3, 9, 7, 2})), 60);
        scenarios.put(Pair.of(Pair.of(6, 3), Pair.of(new int[]{2, 10, 3, 1, 5, 8}, new int[]{5, 4, 3, 9, 7, 2})), 68);
        scenarios.put(Pair.of(Pair.of(6, 4), Pair.of(new int[]{2, 10, 3, 1, 5, 8}, new int[]{5, 4, 3, 9, 7, 2})), 72);

        scenarios.forEach((input, expected) -> assertEquals(expected, arrayProblems.maxPerformance(
                input.getLeft().getLeft(), input.getLeft().getRight(),
                input.getRight().getLeft(), input.getRight().getRight()
        )));
    }

    @Test
    void testCarPooling() {
        Map<Pair<int[][], Integer>, Boolean> scenarios = new HashMap<>();
        scenarios.put(Pair.of(new int[][]{{2, 1, 5}, {3, 3, 7}}, 4), false);
        scenarios.put(Pair.of(new int[][]{{2, 1, 5}, {3, 3, 7}}, 5), true);
        scenarios.put(Pair.of(new int[][]{{2, 1, 5}, {3, 5, 7}}, 3), true);
        scenarios.put(Pair.of(new int[][]{{3, 2, 7}, {3, 7, 9}, {8, 3, 9}}, 11), true);

        scenarios.forEach((input, expected) -> assertEquals(expected,
                arrayProblems.carPooling(input.getLeft(), input.getRight())));
    }

    @Test
    void testLongestConsecutive() {
        Map<int[], Integer> scenarios = new HashMap<>();
        scenarios.put(new int[]{100, 4, 200, 1, 3, 2}, 4);
        scenarios.put(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1}, 9);

        scenarios.forEach((input, expected) -> assertEquals(expected, arrayProblems.longestConsecutive(input)));
    }
}
