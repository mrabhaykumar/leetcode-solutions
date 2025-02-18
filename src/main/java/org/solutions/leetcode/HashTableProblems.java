package org.solutions.leetcode;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashTableProblems {

    /**
     * Q. 554
     * <p>
     * There is a rectangular brick wall in front of you with n rows of bricks. The ith row has some number of bricks
     * each of the same height (i.e., one unit) but they can be of different widths. The total width of each row is the
     * same. Draw a vertical line from the top to the bottom and cross the least bricks. If your line goes through the
     * edge of a brick, then the brick is not considered as crossed. You cannot draw a line just along one of the two
     * vertical edges of the wall, in which case the line will obviously cross no bricks.
     * <p>
     * Given the 2D array wall that contains the information about the wall,
     * return the minimum number of crossed bricks after drawing such a vertical line.
     * <p>
     * tags:: hashMap, hashTable
     */
    public int leastBricks(List<List<Integer>> wall) {
        int ans = 0;
        Map<Integer, Integer> count = new HashMap<>();

        for (List<Integer> list : wall) {
            int pos = 0;
            for (int i = 0; i < list.size() - 1; i++) {
                pos += list.get(i);
                count.put(pos, count.getOrDefault(pos, 0) + 1);
                ans = Math.max(ans, count.get(pos));
            }
        }

        return wall.size() - ans;
    }

    /**
     * Q. 560
     * <p>
     * Given an array of integers nums and an integer k,
     * return the total number of continuous subarrays whose sum equals to k.
     * <p>
     * tags:: array, hashTable, hashMap
     */
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        int sum = 0, ans = 0;

        for (int n : nums) {
            sum += n;
            ans += map.getOrDefault(sum - k, 0);
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }

        return ans;
    }

    /**
     * Q. 974
     * <p>
     * Given an array A of integers, return number of (contiguous, non-empty) subarrays that have a sum divisible by K.
     * <p>
     * tags:: array, hashTable
     */
    public int subarraysDivByK(int[] nums, int K) {
        // hashmap can be used in place of array as well
        int[] counter = new int[K];
        counter[0] = 1;
        int res = 0, curr = 0;

        for (int n : nums) {
            curr = Math.floorMod(curr + n, K);
            res += counter[curr];
            counter[curr]++;
        }

        return res;
    }

}
