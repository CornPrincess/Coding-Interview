package ch04FindInPartiallySortedMatrix;

import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by IntelliJ IDEA.
 * User: zhoutianbin
 * Date: 2020-07-16
 * Time: 00:50
 */
public class FindInPartiallySortedMatrixTest {
    private FindInPartiallySortedMatrix findInPartiallySortedMatrix = new FindInPartiallySortedMatrix();

    @Test
    public void test_target_in_martix() {
        int[][] matrix = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        boolean result1 = findInPartiallySortedMatrix.findNumberIn2DArray(matrix, 7);
        boolean result2 = findInPartiallySortedMatrix.findNumberIn2DArray2(matrix, 7);
        Assert.assertTrue(result1);
        Assert.assertTrue(result2);
    }

    @Test
    public void test_target_not_in_martix() {
        int[][] matrix = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        boolean result1 = findInPartiallySortedMatrix.findNumberIn2DArray(matrix, 5);
        boolean result2 = findInPartiallySortedMatrix.findNumberIn2DArray2(matrix, 5);
        Assert.assertFalse(result1);
        Assert.assertFalse(result2);
    }

    @Test
    public void test_target_is_the_minmun_number() {
        int[][] matrix = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        boolean result1 = findInPartiallySortedMatrix.findNumberIn2DArray(matrix, 1);
        boolean result2 = findInPartiallySortedMatrix.findNumberIn2DArray2(matrix, 1);
        Assert.assertTrue(result1);
        Assert.assertTrue(result2);
    }

    @Test
    public void test_target_is_the_maxmun_number() {
        int[][] matrix = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        boolean result1 = findInPartiallySortedMatrix.findNumberIn2DArray(matrix, 15);
        boolean result2 = findInPartiallySortedMatrix.findNumberIn2DArray2(matrix, 15);
        Assert.assertTrue(result1);
        Assert.assertTrue(result2);
    }

    @Test
    public void test_target_is_smaller_than__minmun_number() {
        int[][] matrix = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        boolean result1 = findInPartiallySortedMatrix.findNumberIn2DArray(matrix, 0);
        boolean result2 = findInPartiallySortedMatrix.findNumberIn2DArray2(matrix, 0);
        Assert.assertFalse(result1);
        Assert.assertFalse(result2);
    }

    @Test
    public void test_target_is_bigger_than__maxmun_number() {
        int[][] matrix = {{1, 2, 8, 9}, {2, 4, 9, 12}, {4, 7, 10, 13}, {6, 8, 11, 15}};
        boolean result1 = findInPartiallySortedMatrix.findNumberIn2DArray(matrix, 16);
        boolean result2 = findInPartiallySortedMatrix.findNumberIn2DArray2(matrix, 16);
        Assert.assertFalse(result1);
        Assert.assertFalse(result2);
    }

    @Test
    public void test_null() {
        int[][] matrix = null;
        boolean result1 = findInPartiallySortedMatrix.findNumberIn2DArray(matrix, 16);
        boolean result2 = findInPartiallySortedMatrix.findNumberIn2DArray2(matrix, 16);
        Assert.assertFalse(result1);
        Assert.assertFalse(result2);
    }
}
