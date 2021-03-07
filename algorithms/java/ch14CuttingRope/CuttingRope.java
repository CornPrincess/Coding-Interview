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
        // core 注意，以下的代码并不好理解，这里的值并不表示答案，当length在 0-3 之间时，上面的代码会返回正确的答案
        // 这里的值只是用来求当 length > 3 时的值，比如 f(4) = max(f(2) * f(2), f(1) * f(3)) = 4，所以要设置 products[2] = 2
        // 其他的值的得来也是一样的道理
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;

        int max = 0;
        // core 用到了dp 的状态转移方程的解法：f(n) = max(f(i) * f(n-i))
        // core 方程是从上到下的过程，但是求解的时候可以从下到上
        // 这里的 i 是绳子的长度
        for (int i = 4; i <= n; i++) {
            // j 从1开始寻找最大值
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


    // dp2
    // 书中的示例代码并不是特别好理解，在这里使用更好理解的状态转移方程
    public int cuttingRope2(int n) {
        // core 状态转移方程法
        // 1. 找出状态转移方程，或者最优子结构：即某个问题如何通过子问题来递归求解
        /*
         * 首先根据题意，要将绳子剪为m > 1 段，那么绳子一定会至少剪一刀，如果第一刀拆分为 k 和 n - k
         * 此时，对于 n - k 这一段我们可以选择继续剪，也可以选择不剪
         *
         * dp数组的含义：dp数组中储存了对应的结果
         * 边界条件：dp[0] = dp[1] = 0
         * 状态转移方程：
         *  1）对 n - k 不进行拆分：此时乘积 = k * (n  - k)
         *  2）对 n - k 继续进行拆分：此时乘积 = k * dp[n - k]
         *
         *  dp[i] = max(j * (i - j), j * dp[i - j])  (1 <= j <= i-1, i > 2)
         */

        // 2. 实现状态转移方程，一般有两种方法：递归加备忘录，迭代递推
        // 这里使用迭代递推的方法
        if (n <= 2) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 0;
        dp[2] = 1;
        dp[3] = 2;
//        int max = 0;
//        for (int i = 4; i <= n; i++) {
//            for (int j = 1; j < i; j++) {
//                int temp = Math.max(j * (i - j), j * dp[i - j]);
//                if (max < temp) {
//                    max = temp;
//                }
//            }
//            dp[i] = max;
//        }
        // core 上述代码也可以更简洁一点
        for (int i = 4; i <= n; i++) {
            for (int j = 1; j < i; j++) {
                dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
            }
        }
        return dp[n];
    }

    // 数学，这个看看题解就好
    public int cuttingRope3(int n) {
        // core 将绳子以相等的长度等分为多段时，得到的乘积最大
        // core 尽可能将绳子以长度3等分为多段时，乘积最大
        // 切分规则：
        // 最优： 3 。把绳子尽可能切为多个长度为 3 的片段，留下的最后一段绳子的长度可能为 0,1,2 三种情况。
        // 次优： 2 。若最后一段绳子长度为 2 ；则保留，不再拆为 1+1+1 。
        // 最差： 1 。若最后一段绳子长度为 1 ；则应把一份 3 + 1+1 替换为 2 + 22+2，因为 2 * 2 > 3 * 1
        if (n <= 3) {
            return n - 1;
        }
        int a = n / 3;
        int b = n % 3;
        if (b == 0) {
            return (int) Math.pow(3, a);
        }
        if (b == 1) {
            return (int) (Math.pow(3, a - 1) * 4);
        }
        return (int) (Math.pow(3, a) * 2);
    }
}
