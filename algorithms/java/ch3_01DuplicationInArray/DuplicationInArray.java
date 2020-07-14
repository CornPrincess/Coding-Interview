// Source : https://leetcode-cn.com/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof/
// Author : cornprincess
// Date   : 2020-07-09

/***************************************************************************************************** 
 *
 * 找出数组中重复的数字。
 * 
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 
 * 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中
 * 任意一个重复的数字。
 * 
 * 示例 1：
 * 
 * 输入：
 * [2, 3, 1, 0, 2, 5, 3]
 * 输出：2 或 3 
 * 
 * 限制：
 * 
 * 2 <= n <= 100000
 ******************************************************************************************************/
package ch3_01DuplicationInArray;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class DuplicationInArray {
    // sort array 排序之后遍历数组，比较相邻的两树，即可得到结果
    // space complexity O(1)
    // time complexity O(nlogn)
    public int findRepeatNumber(int[] nums) {
        if (nums == null || nums.length < 1) {
            return -1;
        }

        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                return nums[i];
            }
        }
        return -1;
    }

    // HashSet 利用HashSet的不可重复性
    // space complexity O(n)
    // time complexity O(n)
    public int findRepeatNumber2(int[] nums) {
        if (nums == null || nums.length < 1) {
            return -1;
        }

        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (!set.add(num)) {
                return num;
            }
        }
        return -1;
    }

    // smart 利用数组特性，即下标 = nums[下标]，通过比较以及交换可知结果
    // space complexity O(1)
    // time complexity O(n)
    public int findRepeatNumber3(int[] nums) {
        if (nums == null || nums.length < 1) {
            return -1;
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0 || nums[i] > nums.length - 1) {
                return -1;
            }

            while (nums[i] != i) {
                if (nums[i] == nums[nums[i]]) {
                    return nums[i];
                }

                int temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return -1;
    }
}
