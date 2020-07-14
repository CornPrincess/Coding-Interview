// Source : https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/
// Author : cornprincess
// Date   : 2020-04-08

/***************************************************************************************************** 
 *
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 
 * 的格子开始移动，它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数
 * 位之和大于k的格子。例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 
 * [35, 38]，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 * 
 * 示例 1：
 * 
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 * 
 * 示例 1：
 * 
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 * 
 * 提示：
 * 
 * 	1 <= n,m <= 100
 * 	0 <= k <= 20
 ******************************************************************************************************/

package RobotMovingCount;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RobotMovingCount {
    // use library
    public String useLibrary(String s) {
        List<String> list = Arrays.asList(s.split("\\s+"));
//        return "";

        final String regex = "ar";
        final String string = "The car parked in the garage.";

        final Pattern pattern = Pattern.compile(regex);
        final Matcher matcher = pattern.matcher(string);

        while (matcher.find()) {
            System.out.println("Full match: " + matcher.group(0));
            for (int i = 1; i <= matcher.groupCount(); i++) {
                System.out.println("Group " + i + ": " + matcher.group(i));
            }
        }
        System.out.println(string.matches(regex));
        return "";
    }
}
