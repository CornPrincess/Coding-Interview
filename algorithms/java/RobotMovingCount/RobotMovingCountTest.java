package RobotMovingCount;

import org.junit.After;
import org.junit.Test;

import java.awt.geom.RoundRectangle2D;

import static org.junit.Assert.*;

/**
 * Created by IntelliJ IDEA.
 * User: zhoutianbin
 * Date: 2020-04-13
 * Time: 08:25
 */
public class RobotMovingCountTest {
    private RobotMovingCount robotMovingCount = new RobotMovingCount();

    @Test
    public void useLibrary() {
        robotMovingCount.useLibrary("");
    }
}
