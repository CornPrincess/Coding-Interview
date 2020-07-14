package ch3_01DuplicationInArray;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 * User: zhoutianbin
 * Date: 2020-07-15
 * Time: 00:23
 */

// 面试题3（二）：不修改数组找出重复的数字
// 题目：在一个长度为n+1的数组里的所有数字都在1到n的范围内，所以数组中至
// 少有一个数字是重复的。请找出数组中任意一个重复的数字，但不能修改输入的
// 数组。例如，如果输入长度为8的数组{2, 3, 5, 4, 3, 2, 6, 7}，那么对应的
// 输出是重复的数字2或者3。

public class DuplicationInArrayTest {
    private DuplicationInArray duplicationInArray = new DuplicationInArray();

    @Test
    // 重复的数字是数组中最小的数字
    public void test_repeat_number_is_least_number() {
        int[] nums = { 2, 1, 3, 1, 4 };
        int result1 = duplicationInArray.findRepeatNumber(nums);
        int result2 = duplicationInArray.findRepeatNumber2(nums);
        int result3 = duplicationInArray.findRepeatNumber3(nums);
        Assert.assertEquals(1, result1);
        Assert.assertEquals(1, result2);
        Assert.assertEquals(1, result3);
    }

    @Test
    // 重复的数字是数组中最大的数字
    public void test_repeat_number_is_largest_number() {
        int[] nums = { 2, 4, 3, 1, 4 };
        int result1 = duplicationInArray.findRepeatNumber(nums);
        int result2 = duplicationInArray.findRepeatNumber2(nums);
        int result3 = duplicationInArray.findRepeatNumber3(nums);
        Assert.assertEquals(4, result1);
        Assert.assertEquals(4, result2);
        Assert.assertEquals(4, result3);
    }

    @Test
    // 数组中存在多个重复的数字
    public void test_has_multi_repeat_number() {
        int[] nums = { 2, 4, 2, 1, 4 };
        int result1 = duplicationInArray.findRepeatNumber(nums);
        int result2 = duplicationInArray.findRepeatNumber2(nums);
        int result3 = duplicationInArray.findRepeatNumber3(nums);
        Assert.assertEquals(2, result1);
        Assert.assertEquals(2, result2);
        Assert.assertEquals(2, result3);
    }

    @Test
    // 数组没有重复的数字
    public void test_has_no_repeat_number() {
        int[] nums = { 0, 3, 2, 1, 4 };
        int result1 = duplicationInArray.findRepeatNumber(nums);
        int result2 = duplicationInArray.findRepeatNumber2(nums);
        int result3 = duplicationInArray.findRepeatNumber3(nums);
        Assert.assertEquals(-1, result1);
        Assert.assertEquals(-1, result2);
        Assert.assertEquals(-1, result3);
    }

    @Test
    // 无效输入
    public void test_invalid_input() {
        int[] nums = {};
        int result1 = duplicationInArray.findRepeatNumber(nums);
        int result2 = duplicationInArray.findRepeatNumber2(nums);
        int result3 = duplicationInArray.findRepeatNumber3(nums);
        Assert.assertEquals(-1, result1);
        Assert.assertEquals(-1, result2);
        Assert.assertEquals(-1, result3);
    }
}
