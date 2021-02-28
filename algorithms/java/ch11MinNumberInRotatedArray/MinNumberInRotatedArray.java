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

            mid = left + (right - left) >> 1;
            // 缩小范围
            if (numbers[mid] >= numbers[left]) {
                left = mid;
            } else if (numbers[mid] <= numbers[right]) {
                right = mid;
            }
        }
        return numbers[mid];
    }

    public static void main(String[] args) {
        System.out.println(1 + (2 - 1) >> 1);
    }
}
