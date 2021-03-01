package ch11MinNumberInRotatedArray;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by IntelliJ IDEA.
 * User: zhoutianbin
 * Date: 3/1/21
 * Time: 10:41 PM
 */
public class MinNumberInRotatedArrayTest {
    private MinNumberInRotatedArray minNumberInRotatedArray = new MinNumberInRotatedArray();

    @Test
    public void binarySearch() {
        int[] a = {1, 2,3 ,4 ,5 ,6, 7, 8};
        int i = minNumberInRotatedArray.binarySearch(a, 8);
        System.out.println(i);
    }

    @Test
    public void test_re() {
        int[] a = {1, 2,3 ,4 ,5 ,6, 7, 8};
        int i = minNumberInRotatedArray.binarySearchRecursive(a, 8);
        System.out.println(i);
    }

    @Test
    public void s() {
        int a = 4 + ((7 - 4) >> 1);
        System.out.println(a);
    }
}
