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
            res[i] = i+1;
        }
        return res;
    }

    // 大数解法：用字符串来表示数字
    /* core 核心有如下几点：
     * 1. 生成对应的字符串集：可以模拟出加法，但是这道题其实可以用递归来求全排列（即答案为n 位 0-9 的全排列）
     * 2. 递归生成全排列
     */
    StringBuilder res;
    int count = 0;
    int n;
    char[] loop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    char[] num;
    public String printNumbers2(int n) {
        this.n = n;
        res  = new StringBuilder();
        num = new char[n];
        dfs(0);
        res.deleteCharAt(res.length() - 1);
        return res.toString();
    }

    private void dfs(int x) {
        //  终止条件
        if (x == n) {
            res.append(String.valueOf(num) + ",");
            return;
        }
        for (char i : loop) {
            num[x] = i;
            dfs(x+1);
        }
    }
}
