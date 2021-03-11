package ch16Power;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by IntelliJ IDEA.
 * User: zhoutianbin
 * Date: 3/10/21
 * Time: 11:00 PM
 */
public class PowerTest {
    private Power power = new Power();

    @Test
    public void myPow() {
        double v = power.myPow(2.00000, Integer.MIN_VALUE);
        System.out.println(v);
    }

    @Test
    public void myPow2() {
        double v = power.myPow2(2.00000, Integer.MIN_VALUE);
        System.out.println(v);
        System.out.println(Math.pow(2.00000, Integer.MIN_VALUE));
    }

    @Test
    public void test() {
        int a = Integer.MIN_VALUE;
        System.out.println(a);
        int b = -a;
        System.out.println(b);
        long c = -a;
        System.out.println(c);
        long d = a;
        d = -d;
        System.out.println(d);
    }
}
