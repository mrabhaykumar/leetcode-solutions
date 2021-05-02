package org.solutions.leetcode;

import java.util.*;

public class MathProblems {

    /*
     * Q.1342
     * Given a non-negative integer num, return the number of steps to reduce it to zero.
     * If the current number is even, you have to divide it by 2, otherwise, you have to subtract 1 from it.
     *
     * Tags:: math
     * */
    public int numberOfSteps(int num) {
        if (num == 0)
            return 0;

        int count = 0;
        while (num > 1) {
            count += (num % 2) + 1;
            num = num >> 1;
        }
        return ++count;
    }

    /*
     * Q.575
     * Alice has n candies, where the ith candy is of type candyType[i]. Alice noticed that she started to gain weight,
     * so she visited a doctor.The doctor advised Alice to only eat n / 2 of the candies she has (n is always even).
     * Alice likes her candies very much, and she wants to eat the maximum number of different types of candies while
     * still following the doctor's advice.
     *
     * Given the integer array candyType of length n, return the maximum number of different types of candies she can eat if she only eats n / 2 of them.
     *
     * Tags:: math
     * */
    public int distributeCandies(int[] candyType) {
        Set<Integer> set = new HashSet<>();

        for (int c : candyType) {
            set.add(c);

            if (set.size() == candyType.length / 2)
                return candyType.length / 2;
        }

        return set.size();
    }

    /*
     * Q.645
     * You have a set of integers s, which originally contains all the numbers from 1 to n.
     * Unfortunately, due to some error, one of the numbers in s got duplicated to another number in the set,
     * which results in repetition of one number and loss of another number.
     *
     * You are given an integer array nums representing the data status of this set after the error.
     * Find the number that occurs twice and the number that is missing and return them in the form of an array.
     *
     * Tags:: math
     * */
    public int[] findErrorNums(int[] nums) {
        int diff = 0, sqDiff = 0, sum = 0;
        for (int i = 0; i < nums.length; i++) {
            diff += i + 1 - nums[i];
            sqDiff += (i + 1) * (i + 1) - nums[i] * nums[i];
        }

        sum = sqDiff / diff;
        return new int[]{(sum - diff) / 2, (sum + diff) / 2};
    }

    /*
     * Q.268
     * Given an array nums containing n distinct numbers in the range [0, n],
     * return the only number in the range that is missing from the array.
     *
     * Tags:: math
     * */
    public int missingNumber(int[] nums) {
        int n = nums.length, sum = 0;
        for (int num : nums)
            sum += num;

        return (n * (n + 1) / 2 - sum);
    }

    /*
     *  Q. 869
     *
     * Starting with a positive integer N, we reorder the digits in any order (including the original order)
     * such that the leading digit is not zero.
     * Return true if and only if we can do this in a way such that the resulting number is a power of 2.
     *
     * tags:: math
     * */
    public boolean reorderedPowerOf2(int N) {
        int[] expectedCount = getCount(N);
        for (int i = 0; i < 31; i++)
            if (Arrays.equals(expectedCount, getCount(1 << i)))
                return true;

        return false;
    }

    /*
     * Given a number, return an array, with occurrence of each digit
     * */
    private int[] getCount(int num) {
        int[] count = new int[10];
        while (num > 0) {
            count[num % 10]++;
            num /= 10;
        }

        return count;
    }

    /*
     * Q. 1551
     *
     * You have an array arr of length n where arr[i] = (2 * i) + 1 for all valid values of i (i.e. 0 <= i < n).
     * In one operation, you can select two indices x and y where 0 <= x, y < n and subtract 1 from arr[x] and add 1
     * to arr[y] (i.e. perform arr[x] -=1 and arr[y] += 1). The goal is to make all the elements of the array equal.
     * It is guaranteed that all the elements of the array can be made equal using some operations. Given an integer n,
     * the length of the array. Return the minimum number of operations needed to make all the elements of arr equal.
     *
     * tags:: array, Math
     * */
    public int minOperations(int n) {
        return (n * n) >> 2;
    }

    /*
     * Q. 326
     *
     * Given an integer n, return true if it is a power of three. Otherwise, return false.
     * An integer n is a power of three, if there exists an integer x such that n == 3^x.
     *
     * tags:: math
     * */
    public boolean isPowerOfThree(int n) {
        if (n <= 0)
            return false;

        // check decimal part is zero, by taking mod 1
        return (Math.log10(n) / Math.log10(3)) % 1 == 0;
    }

    /*
     * Q. 970
     *
     * Given three integers x, y, and bound, return a list of all the powerful integers that have a value less than or
     * equal to bound. An integer is powerful if it can be represented as xi + yj for some integers i >= 0 and j >= 0.
     * You may return the answer in any order. In your answer, each value should occur at most once.
     *
     * tags:: math, array
     * */
    public List<Integer> powerfulIntegers(int x, int y, int bound) {
        Set<Integer> ans = new HashSet<>();

        int a = (x == 1) ? bound : (int) (Math.log10(bound) / Math.log10(x));
        int b = (y == 1) ? bound : (int) (Math.log10(bound) / Math.log10(y));

        for (int i = 0; i <= a; i++) {
            for (int j = 0; j <= b; j++) {
                int sum = (int) (Math.pow(x, i) + Math.pow(y, j));

                if (sum <= bound)
                    ans.add(sum);

                if (y == 1) break;
            }

            if (x == 1) break;
        }

        return new ArrayList<Integer>(ans);
    }
}
