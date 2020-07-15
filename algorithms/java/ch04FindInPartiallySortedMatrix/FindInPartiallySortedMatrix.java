// Source : https://leetcode-cn.com/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof/
// Author : cornprincess
// Date   : 2020-07-16

/***************************************************************************************************** 
 *
 * 在一个 n * m 
 * 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个函数
 * ，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * 
 * 示例:
 * 
 * 现有矩阵 matrix 如下：
 * 
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * 
 * 给定 target = 5，返回 true。
 * 
 * 给定 target = 20，返回 false。
 * 
 * 限制：
 * 
 * 0 <= n <= 1000
 * 
 * 0 <= m <= 1000
 * 
 * 注意：本题与主站 240 题相同：https://leetcode-cn.com/problems/search-a-2d-matrix-ii/
 ******************************************************************************************************/

package ch04FindInPartiallySortedMatrix;

public class FindInPartiallySortedMatrix {
    /*
     * 首先选取右上角的数字 a
     * 如果 a == target, return
     * 如果 a > target, 直接剔除这一列，往左边的列找
     * 如果 a < target, 直接剔除这一行，往下边找
     *
     * time complexity O(n + m)
     * space complexity O(1)
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if (matrix == null || matrix.length < 1)  {
            return false;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int row = 0;
        int col = cols - 1;
        while (row < rows && col >= 0) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                row++;
            } else {
                col--;
            }
        }
        return false;
    }

    /*
     * 首先选取左下角的数字 a
     * 如果 a == target, return
     * 如果 a < target, 直接剔除这一列，往右边的列找
     * 如果 a > target, 直接剔除这一行，往上边的行找
     *
     * time complexity O(n + m)
     * space complexity O(1)
     */
    public boolean findNumberIn2DArray2(int[][] matrix, int target) {
        if (matrix == null || matrix.length < 1)  {
            return false;
        }

        int rows = matrix.length;
        int cols = matrix[0].length;
        int row = rows - 1;
        int col = 0;
        while (row >= 0 && col < cols) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] < target) {
                col++;
            } else {
                row--;
            }
        }
        return false;
    }
}
