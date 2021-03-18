package ch17Print1ToMaxOfNDigits;

// Source : https://leetcode-cn.com/problems/da-yin-cong-1dao-zui-da-de-nwei-shu-lcof/
// Author : cornprincess
// Date   : 2021-03-11

import java.util.Arrays;

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


    // 模拟加法
    public int[] printNumbers3(int n) {
        if (n <= 0) {
            return null;
        }

        int[] res = new int[(int) (Math.pow(10, n) - 1)];
        char[] num = new char[n];
        for (int i = 0; i < n; i++) {
            num[i] = '0';
        }

        int index = 0;
        while (!increment(num)) {
            int number = printNumber(num);
            if (number != -1) {
                res[index++] = number;
            }
        }
        return res;
    }

    // 字符串number表示一个数字，在 number上增加1
    // 如果做加法溢出，则返回true；否则为false
    private boolean increment(char[] num) {
        int n = num.length;
        // 进位
        int nTakeOver = 0;
        boolean isOverflow = false;

        // 从后往前进行+1计算
        for (int i = n - 1; i >= 0; i--) {
            int nSum = num[i] - '0' + nTakeOver;
            if (i == n - 1) {
                nSum++;
            }

            // 如果有进位
            if (nSum >= 10) {
                if (i == 0) {
                    isOverflow = true;
                } else {
                    nSum -= 10;
                    nTakeOver = 1;
                    num[i] = (char) ('0' + nSum);
                }
                // 没有进位
            } else {
                num[i] = (char) ('0' + nSum);
                // 因为是+1操作，因此没有进位就意味着这次计算结束了
                break;
            }
        }
        return isOverflow;
    }

    // 字符串number表示一个数字，数字有若干个0开头
    // 打印出这个数字，并忽略开头的0
    private int printNumber(char[] num) {
        boolean isbeigining0 = true;
        int nLength = num.length;
        StringBuilder sb = new StringBuilder();

        // core 这里相当于是每次都把前面的0进行过滤
        for (int i = 0; i < nLength; i++) {
            if (isbeigining0 && num[i] != '0') {
                isbeigining0 = false;
            }

            if (!isbeigining0) {
                sb.append(num[i]);
            }
        }
        if (!"".equals(sb.toString())) {
            return Integer.valueOf(sb.toString());
        } else {
            return -1;
        }
    }

    public int[] printNumbers4(int n) {
        if (n <= 0) {
            return null;
        }

        char[] num = new char[n];

        for (int i = 0; i < 10; i++) {
            num[0] = (char) (i + '0');
            print1ToMaxOfNDigitsRecursively(num, n, 0);
        }
        return null;
    }

    void print1ToMaxOfNDigitsRecursively(char[] num, int n, int index) {
        if (index == n - 1) {
            printNumber(num);
            return;
        }
        for (int i = 0; i < 10; i++) {
            num[index + 1] = (char) (i + '0');
            print1ToMaxOfNDigitsRecursively(num, n, index + 1);
        }
    }

    char[] myLoop = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
    char[] myNum;
    int resIndex = 0;
    int[] myRes;

    public int[] printNumbers5(int n) {
        myRes = new int[(int) (Math.pow(10, n) - 1)];
        myNum = new char[n];
        myDfs(0);
        System.out.println(Arrays.toString(myRes));
        return myRes;
    }

    private void myDfs(int index) {
        if (index == myNum.length) {
            int a = convertNumber(myNum);
            if (a != -1) {
                myRes[resIndex++] = a;
            }
            return;
        }

        for (char c : myLoop) {
            myNum[index] = c;
            myDfs(index + 1);
        }
    }

    private int convertNumber(char[] num) {
        int start = 0;
        // core  这里一定要注意边界条件
        while (num[start] == '0') {
            start++;
            if (start == num.length) {
                return -1;
            }
        }
        return Integer.valueOf(String.valueOf(num, start, num.length - start));
    }

}
