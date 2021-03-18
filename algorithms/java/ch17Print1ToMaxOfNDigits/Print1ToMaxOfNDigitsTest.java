package ch17Print1ToMaxOfNDigits;

import org.junit.Test;

import java.io.PipedOutputStream;

import static org.junit.Assert.*;

/**
 * Created by IntelliJ IDEA.
 * User: zhoutianbin
 * Date: 3/11/21
 * Time: 11:03 PM
 */
public class Print1ToMaxOfNDigitsTest {
    private Print1ToMaxOfNDigits print1ToMaxOfNDigits = new Print1ToMaxOfNDigits();

    @Test
    public void printNumbers() {
        Integer.valueOf("");
    }

    @Test
    public void printNumbers3() {
        int[] s = print1ToMaxOfNDigits.printNumbers3(1);
        System.out.println(s);
    }

    @Test
    public void printNumbers5() {
        print1ToMaxOfNDigits.printNumbers5(2);
    }
}
