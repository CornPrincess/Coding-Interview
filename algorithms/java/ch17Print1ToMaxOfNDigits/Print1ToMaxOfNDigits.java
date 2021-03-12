package ch17Print1ToMaxOfNDigits;

// Source : https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/
// Author : cornprincess
// Date   : 2021-03-11

/*****************************************************************************************************
 *
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 
 * 位数 999。
 *
 * 示例 1:
 *
 * 输入: n = 1
 * 输出: [1,2,3,4,5,6,7,8,9]
 *
 * 说明：
 *
 * 	用返回一个整数列表来代替打印
 * 	n 为正整数
 ******************************************************************************************************/

public class Print1ToMaxOfNDigits {
    // 简单解法
    public int[] printNumbers(int n) {
        int end = (int) (Math.pow(10, n) - 1);
        int[] res = new int[end];
        for (int i = 0; i < end; i++) {
            res[i] = i + 1;
        }
        return res;
    }

    // 大数解法：用字符串来表示数字
    /* core 核心有如下几点：
     * 1. 生成对应的字符串集：可以模拟出加法，但是这道题其实可以用递归来求全排列（即答案为n 位 0-9 的全排列）
     * 2. 递归生成全排列
     */
    int[] res;
    int count = 0;
    int n;
    char[] loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    char[] num;
    int index = 0;
    // core 取出前面的0的参数
    // 第一个非零的起始位置
    int start;
    // 大数中9的个数
    int nineCnt = 0;

    public int[] printNumbers2(int n) {
        this.n = n;
        res = new int[(int) Math.pow(10, n) - 1];
        num = new char[n];
        // core 非零边界初始值为n - 1
        start = n - 1;
        dfs(0);
        return res;
    }

    /* core 以下代码可以生成n位数的全排列，但是还存在两个问题：
     * 1. 有多余的0
     *  字符串左边界的定义：09(两位数), 099（三位数）, 0999（四位数）
     *  009，099，999， 左边界初始为 n - 1，当出现所有数位都为9时，左边界-1，直到为0
     * 2. 没有从1开始
     *  判断是否为0，若为0则跳过
     */
    private void dfs(int x) {
        //  终止条件
        if (x == n) {
            String s = String.valueOf(num).substring(start);
            if (!"0".equals(s)) {
                res[index++] = Integer.valueOf(s);
            }
            if (n - start == nineCnt) {
                start--;
            }
            return;
        }
        // core 这应该是深度优先遍历,以n=2为例
        // thread1 thread2  start   nineCnt
        // 0        - 0        1       0
        //          - 1        1       0
        //          - 2        1       0
        //          - 3        1       0
        //          - 4        1       0
        //          - ..       1       0
        //          - 9        0       1
        //  1       - 0        0       0
        // core 这里每一个循环完成表示一个数位的循环完成
        // core 因此时间复杂度为 10^n
        for (char i : loop) {
            // core
            if (i == '9') {
                nineCnt++;
            }
            num[x] = i;
            // core 开始循环下一个数位
            dfs(x + 1);
        }
        // core 一个数位循环结束，这里必须要-1，因为统计的是所有数位为9的个数，当这个数位循环结束，它就又要从0开始循环
        nineCnt--;
    }
}
