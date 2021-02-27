package ch10Fibonacci;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;

/**
 * Created by IntelliJ IDEA.
 * User: zhoutianbin
 * Date: 2/26/21
 * Time: 12:13 AM
 */
public class FibonacciTest {

    private Fibonacci fibonacci = new Fibonacci();

    @Test
    public void fib2() {
        int i = fibonacci.fib2(45);
        System.out.println(i);
    }

    @Test
    public void fib3() {
        int a = fibonacci.fib(45);
        int b = fibonacci.fib2(45);
        int i = fibonacci.fib3(45);
        int j = fibonacci.fib4(45);
        long k = fibonacci.fib5(45);
        System.out.println(i);
        System.out.println(j);
        System.out.println(a);
        System.out.println(b);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(k);
    }

    @Test
    public void fib4() {
        int[] res1 = new int[46];
        long[] res2 = new long[46];
        for (int i = 0; i < 46; i++) {
            res1[i] = fibonacci.fib4(i);
            res2[i] = fibonacci.fib5(i);
        }
        System.out.println(Arrays.toString(res1));
        System.out.println(Arrays.toString(res2));
        System.out.println(fibonacci.fib4(45));
        System.out.println(fibonacci.fib5(45));
        System.out.println(res1[44]);
        System.out.println(res1[44]);
        System.out.println(Integer.MAX_VALUE);
        System.out.println((433494437 + 701408733) > Integer.MAX_VALUE);
    }
}
