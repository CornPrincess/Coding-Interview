package ch12StringPathInMatrix;

import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 * User: zhoutianbin
 * Date: 3/2/21
 * Time: 10:44 PM
 */
public class StringPathInMatrixTest {
    private StringPathInMatrix stringPathInMatrix = new StringPathInMatrix();

    @Test
    public void cal8Queens() {
        stringPathInMatrix.cal8Queens(0);
        System.out.println(stringPathInMatrix.num);
    }

    @Test
    public void test() {
        int[][] a = new int[1][0];
        System.out.println(a.length);
        System.out.println(a[0].length);
    }
}
