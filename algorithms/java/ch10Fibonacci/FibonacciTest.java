package ch10Fibonacci;

import org.junit.Test;

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
}
