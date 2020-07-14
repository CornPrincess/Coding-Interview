package ch03_02DuplicaitonInArrayNoEdit;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by IntelliJ IDEA.
 * User: zhoutianbin
 * Date: 2020-07-15
 * Time: 01:02
 */
public class DuplicationInArrayNoEditTest {
    private DuplicationInArrayNoEdit duplicationInArrayNoEdit = new DuplicationInArrayNoEdit();

    @Test
    public void test_two_number() {
        int[] nums = {1, 1};
        int result1 = duplicationInArrayNoEdit.findRepeatNumber(nums);
        int result2 = duplicationInArrayNoEdit.findRepeatNumber2(nums);
        Assert.assertEquals(1, result1);
        Assert.assertEquals(1, result2);
    }

    @Test
    public void test_duplicate_two_number() {
        int[] nums = {2, 3, 5, 4, 2, 3, 6, 7};
        int result1 = duplicationInArrayNoEdit.findRepeatNumber(nums);
        int result2 = duplicationInArrayNoEdit.findRepeatNumber2(nums);
        Assert.assertEquals(2, result1);
        Assert.assertEquals(3, result2);
    }
}
