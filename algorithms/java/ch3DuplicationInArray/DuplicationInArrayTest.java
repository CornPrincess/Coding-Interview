package ch3DuplicationInArray;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by IntelliJ IDEA.
 * User: zhoutianbin
 * Date: 2020-07-15
 * Time: 00:23
 */
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
