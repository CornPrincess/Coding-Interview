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
    }

    @Test
    public void printNumbers2() {
        String s = print1ToMaxOfNDigits.printNumbers2(2);
        System.out.println(s);
    }
}
