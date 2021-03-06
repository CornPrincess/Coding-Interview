package ch14CuttingRope;
// Source : https://leetcode-cn.com/problems/jian-sheng-zi-lcof/
// Author : cornprincess
// Date   : 2021-03-05

/***************************************************************************************************** 
 *
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 
 * 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 
 * 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘
 * 积是18。
 *
 * 示例 1：
 *
 * 输入: 2
 * 输出: 1
 * 解释: 2 = 1 + 1, 1 &times; 1 = 1
 *
 * 示例 2:
 *
 * 输入: 10
 * 输出: 36
 * 解释: 10 = 3 + 3 + 4, 3 &times; 3 &times; 4 = 36
 *
 * 提示：
 *
 * 	2 <= n <= 58
 *
 * 注意：本题与主站 343 题相同：https://leetcode-cn.com/problems/integer-break/
 ******************************************************************************************************/


public class CuttingRope {

    // dp
    public int cuttingRope(int n) {
        if (n < 2) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }

        int[] products = new int[n + 1];
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;

        int max = 0;
        for (int i = 4; i <= n; i++) {
            for (int j = 1; j <= i / 2; j++) {
                int product = products[j] * products[i - j];
                if (max < product) {
                    max = product;
                }
                products[i] = max;
            }
        }

        max = products[n];
        return max;
    }
}
