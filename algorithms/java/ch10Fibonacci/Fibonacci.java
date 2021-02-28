package ch10Fibonacci;

// Source : https://leetcode-cn.com/problems/fei-bo-na-qi-shu-lie-lcof/
// Author : cornprincess
// Date   : 2021-02-12

import java.util.HashMap;
import java.util.Map;

/*****************************************************************************************************
 *
 * 写一个函数，输入 n ，求斐波那契（Fibonacci）数列的第 n 项（即 F(N)）。斐波那契数列的定义如下：
 *
 * F(0) = 0,   F(1) = 1
 * F(N) = F(N - 1) + F(N - 2), 其中 N > 1.
 *
 * 斐波那契数列由 0 和 1 开始，之后的斐波那契数就是由之前的两数相加而得出。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 示例 1：
 *
 * 输入：n = 2
 * 输出：1
 *
 * 示例 2：
 *
 * 输入：n = 5
 * 输出：5
 *
 * 提示：
 *
 * 	0 
 ******************************************************************************************************/

public class Fibonacci {
    Map<Integer, Integer> map = new HashMap<>();

    public int fib(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        return fib(n - 1) + fib(n - 2);
    }

    public int fib2(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        int result;
        if (map.containsKey(n)) {
            result = map.get(n);
        } else {
            result = fib2(n - 1) + fib2(n - 2);
            map.put(n, result);
        }
        return result;
    }

    public int fib3(int n) {
        int a = 0;
        int b = 1;
        int c = a + b;
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            for (int i = 1; i < n; i++) {
                c = a + b;
                a = b;
                b = c;
            }
            return c;
        }
    }

    public int fib4(int n) {
        int a = 0;
        int b = 1;
        int sum;
        for (int i = 0; i < n; i++) {
            sum = (a + b) % 1000000007;
            a = b;
            b = sum;
        }
        return a;
    }

    public long fib5(int n) {
        int[] result = {0, 1};
        if (n < 2) {
            return result[n];
        }
        long fibMinusOne = 1;
        long fibMinusTwo = 0;
        long finN = 0;
        for (int i = 2; i <= n; i++) {
            finN = fibMinusOne + +fibMinusTwo;
            fibMinusTwo = fibMinusOne;
            fibMinusOne = finN;
        }
        return finN;
    }

    public int fib6(int n) {
        int[] temp = new int[n + 1];
        temp[0] = 0;
        temp[1] = 1;
        for (int i = 2; i <= n; i++) {
            temp[i] = temp[i - 2] + temp[i - 1];
        }
        return temp[n];
    }

}
