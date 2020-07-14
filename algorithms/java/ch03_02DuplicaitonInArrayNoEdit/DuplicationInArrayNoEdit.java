package ch03_02DuplicaitonInArrayNoEdit;

/**
 * Created by IntelliJ IDEA.
 * User: zhoutianbin
 * Date: 2020-07-15
 * Time: 00:38
 */
public class DuplicationInArrayNoEdit {
    // support array
    // time complexity O(n)
    // space complexity O(n)
    public int findRepeatNumber(int[] nums) {
        if (nums == null || nums.length < 1) {
            return -1;
        }

        int[] supportNums = new int[nums.length];

        for (int i = 0; i < nums.length; i++) {
            if (supportNums[nums[i]] == nums[i]) {
                return nums[i];
            } else {
                supportNums[nums[i]] = nums[i];
            }
        }
        return -1;
    }

    // middle search
    // time complexity O(nlogn)
    // space complexity O(1)
    public int findRepeatNumber2(int[] nums) {
        int start = 1;
        int end = nums.length -1;

        while (end >= start) {
            int middle = ((end - start) >> 1) + start;
            int count = countRange(nums, start, middle);
            if (end == start) {
                if (count > 1) {
                    return start;
                } else {
                    break;
                }
            }

            if (count > (middle - start + 1)) {
                end = middle;
            } else {
                start = middle + 1;
            }
        }
        return -1;
    }

    private int countRange(int[] nums, int stat, int end) {
        if (nums == null) {
            return 0;
        }
        int count = 0;
        for (int num : nums) {
            if (num >= stat && num <= end) {
                count++;
            }
        }
        return count;
    }
}
