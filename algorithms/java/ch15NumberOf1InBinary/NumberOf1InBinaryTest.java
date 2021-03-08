package ch15NumberOf1InBinary;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by IntelliJ IDEA.
 * User: zhoutianbin
 * Date: 3/7/21
 * Time: 5:22 PM
 */
public class NumberOf1InBinaryTest {
    private NumberOf1InBinary numberOf1InBinary = new NumberOf1InBinary();

    @Test
    public void test() {
        int res = numberOf1InBinary.hammingWeight(11);
        System.out.println(res);
        System.out.println(2 & 11);
        int i = Integer.valueOf("1111111111111111111111111111101", 2);
        System.out.println(i);
        System.out.println("-----------");
        System.out.println("11111111111111111111111111111101".length());
//        System.out.println(Integer.valueOf("11111111111111111111111111111101", 2));
        System.out.println(Integer.valueOf("-1111111111111111111111111111101", 2));
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Integer.valueOf("1111111111111111111111111111111", 2));
    }

    @Test
    public void test2() {
        // 0000 0000 0000 0000 0000 0000 0000 0001
        System.out.println(1 << 31);
        System.out.println(1 << 32);
        System.out.println(Integer.toBinaryString(-7));
        System.out.println(Integer.toBinaryString(Integer.MIN_VALUE));
        System.out.println(-7 & Integer.MIN_VALUE);
    }
}
