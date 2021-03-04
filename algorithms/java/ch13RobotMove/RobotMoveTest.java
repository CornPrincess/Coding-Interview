package ch13RobotMove;

import org.junit.Test;

/**
 * Created by IntelliJ IDEA.
 * User: zhoutianbin
 * Date: 2020-04-13
 * Time: 08:25
 */
public class RobotMoveTest {
    private RobotMove robotMovingCount = new RobotMove();

    @Test
    public void useLibrary() {
        robotMovingCount.useLibrary("");
        System.out.println(Integer.MAX_VALUE);
    }
}
