package ch11MinNumberInRotatedArray;
// Source : https://leetcode-cn.com/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof/
// Author : cornprincess
// Date   : 2021-02-28

/***************************************************************************************************** 
 *
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个递增排序的数组的一个旋转，
 * 输出旋转数组的最小元素。例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一个旋转，该数组的最小值为1。  
 *
 * 示例 1：
 *
 * 输入：[3,4,5,1,2]
 * 输出：1
 *
 * 示例 2：
 *
 * 输入：[2,2,2,0,1]
 * 输出：0
 *
 * 注意：本题与主站 154 
 * 题相同：https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array-ii/
 ******************************************************************************************************/

public class MinNumberInRotatedArray {
    public int minArray(int[] numbers) {
        if (numbers == null || numbers.length < 1) {
            return -1;
        }
        /*
         * [4, 5, 1, 2, 3]
         *  l     m      r
         * [4, 5, 1, 2, 3]
         *  l  m  r
         * [4, 5, 1, 2, 3]
         *     l  r
         *     m
         */
        int left = 0;
        int right = numbers.length - 1;
        int mid = left;
        // 如果旋转了0个数
        while (numbers[left] >= numbers[right]) {
            if (right - left == 1) {
                break;
            }

            mid = left + ((right - left) >> 1);
            /* 以下代码此时需要注意数组中重复数字的情况，比如，数组为{0, 1, 1, 1, 1}
             * 那么旋转后有多种可能
             *
             * 1, | 0, 1, 1, 1
             * l       m     r
             * 1, 1, 1, | 0, 1
             * l     m       r
             *
             * 以上情况，无法判断 mid 是在左边半区还是右边半区，最终求不出结果
             */
            if (numbers[left] == numbers[right] && numbers[mid] == numbers[left]) {
                return MinInOrder(numbers, left, right);
            }

            // 缩小范围
            if (numbers[mid] >= numbers[left]) {
                left = mid;
            } else if (numbers[mid] <= numbers[right]) {
                right = mid;
            }
        }
        return numbers[mid];
    }

    // 二分查找的简单实现
    public int binarySearch(int[] a, int target) {
        int left = 0;
        int right = a.length - 1;
        int mid;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if (a[mid] == target) {
                return mid;
            } else if (a[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public int binarySearchRecursive(int[] a, int target) {
        return binarySearchRecursive0(a, 0, a.length - 1, target);
    }

    public int binarySearchRecursive0(int[] a, int left, int right, int target) {
        if (left > right) {
            return -1;
        }

        int mid = left + ((right - left) >> 1);
        if (a[mid] == target) {
            return mid;
        } else if (a[mid] > target) {
            return binarySearchRecursive0(a, left, mid - 1, target);
        } else {
            return binarySearchRecursive0(a, mid + 1, right, target);
        }
    }

    // 查找第一个值等于给定值的元素（数组中包含重复元素）
    public int binarySearch1(int[] a, int target) {
        int left = 0;
        int right = a.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (a[mid] > target) {
                right = mid - 1;
            } else if (a[mid] < target) {
                left = mid + 1;
            } else {
                // 下面的四行代码秒啊，因为存在重复元素，所以下面的判断条件就尤为关键
                if ((mid == 0) || a[mid - 1] != target) {
                    return mid;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    // 查找最后一个值等于给定值的元素（数组中包含重复元素）
    public int binarySearch2(int[] a, int target) {
        int left = 0;
        int right = a.length - 1;
        while (left <= right) {
            int mid = left + ((right - left) >> 1);
            if (a[mid] > target) {
                right = mid - 1;
            } else if (a[mid] < target) {
                left = mid + 1;
            } else {
                // 下面的四行代码秒啊，因为存在重复元素，所以下面的判断条件就尤为关键
                if ((mid == a.length - 1) || a[mid + 1] != target) {
                    return mid;
                } else {
                    right = mid + 1;
                }
            }
        }
        return -1;
    }

    // 查找第一个大于等于给定值的元素 (数组中包含重复元素)
    public int binarySearch3(int[] a, int target) {
        int left = 0;
        int right = a.length - 1;
        int mid;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if (a[mid] >= target) {
                if (mid == 0 || a[mid - 1] != target) {
                    return mid;
                } else {
                    right = mid - 1;
                }
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    // 查找最后一个小于等于给定值的元素(数组中包含重复元素)
    public int binarySearch4(int[] a, int target) {
        int left = 0;
        int right = a.length - 1;
        int mid;
        while (left <= right) {
            mid = left + ((right - left) >> 1);
            if (a[mid] <= target) {
                if (mid == a.length - 1 || a[mid + 1] != target) {
                    return mid;
                } else {
                    left = mid + 1;
                }
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
}
