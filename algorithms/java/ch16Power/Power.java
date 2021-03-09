
package ch16Power;
// Source : https://leetcode-cn.com/problems/shu-zhi-de-zheng-shu-ci-fang-lcof/
// Author : cornprincess
// Date   : 2021-03-09

/***************************************************************************************************** 
 *
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。
 *
 * 示例 1：
 *
 * 输入：x = 2.00000, n = 10
 * 输出：1024.00000
 *
 * 示例 2：
 *
 * 输入：x = 2.10000, n = 3
 * 输出：9.26100
 *
 * 示例 3：
 *
 * 输入：x = 2.00000, n = -2
 * 输出：0.25000
 * 解释：2-2 = 1/22 = 1/4 = 0.25
 *
 * 提示：
 *
 * 	-100.0 
 * 	-231 31-1
 * 	-104 n 4
 *
 * 注意：本题与主站 50 题相同：https://leetcode-cn.com/problems/powx-n/
 ******************************************************************************************************/

public class Power {
    public double myPow(double x, int n) {
        // core 凡是数学计算，都需要考虑x，n的取值范围问题：正数，负数，0
        // 如果base为0，必须返回0，防止出现 1/0 的情况
        if (x == 0) {
            return 0;
        }
        long exponent = n;
        // 如果 n 为负数
        if (n < 0) {
            exponent = -n;
            x = 1 / x;
        }
        return myPowerWithUnSignedExponent(x, exponent);
    }

    private boolean equal(double v1, double v2) {
        return v1 - v2 < 0.0000001D && v1 - v2 > -0.0000001D;
    }

    /* core 这里必须使用long类型，因为有可能取 -Integer.MIN_VALUE，如果是int就会越界
     * 快速幂法，从二分的角度考虑：
     *  当 n 为奇数时： x^n = (x^2)^(n/2) * x
     *  当 n 为偶数时： x^n = (x^2)^(n/2)
     */
    private double myPowerWithUnSignedExponent(double base, long exponent) {
        double res = 1.0;
        while (exponent != 0) {
            // core 这行代码很妙，有两个作用
            // 1. 如果 exponent 为奇数，那么实现第一次 *x 的功能
            // 2. 当最终 exponent = 1 时，将计算的值赋给 res
            // core n % 2 = n & 1，使用位运算来优化
            if ((exponent & 1) == 1) {
                res *= base;
            }
            base *= base;
            // core 使用位运算来优化
            exponent >>= 1;
        }
        return res;
    }
}
