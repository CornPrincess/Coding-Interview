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

package ch13RobotMove;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RobotMove {
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

    // 回溯法
    public int movingCount(int m, int n, int k) {
        if (k < 0 || m <= 0 || n <= 0) {
            return 0;
        }

        boolean[][] visited = new boolean[m][n];

        return movingCountCore(k, m, n, 0, 0, visited);
    }

    private int movingCountCore(int threshold, int rows, int cols, int row, int col, boolean[][] visited) {
        int count = 0;
        if (check(threshold, rows, cols, row, col, visited)) {
            visited[row][col] = true;

            count = 1 + movingCountCore(threshold, rows, cols, row - 1, col, visited)
                    + movingCountCore(threshold, rows, cols, row, col - 1, visited)
                    + movingCountCore(threshold, rows, cols, row, col + 1, visited)
                    + movingCountCore(threshold, rows, cols, row + 1, col, visited);
        }
        return count;
    }

    // BFS
    public int movingCount2(int m, int n, int k) {
        if (m <= 0 || n <= 0 || k < 0) {
            return 0;
        }

        int[] dx = {0, 1};
        int[] dy = {1, 0};
        boolean[][] visited = new boolean[m][n];
        Queue<int[]> queue = new LinkedList<>();
        // 首先把起点添加进来
        queue.offer(new int[]{0, 0});
        visited[0][0] = true;
        int count = 1;

        // BFS
        while (!queue.isEmpty()) {
            int[] node = queue.poll();
            // 进行向下或者向右的遍历
            for (int i = 0; i < 2; i++) {
                int tx = node[0] + dx[i];
                int ty = node[1] + dy[i];
                // core 条件检查，剪枝
                if (tx >= m || tx < 0 || ty >= n || ty < 0 ||
                        visited[tx][ty] ||
                        (getDigitSum(tx) + getDigitSum(ty)) > k) {
                    continue;
                }
                queue.offer(new int[]{tx, ty});
                visited[tx][ty] = true;
                count++;
            }
        }
        return count;
    }

    // DFS
    public int movingCount3(int m, int n, int k) {
        boolean[][] vistied = new boolean[m][n];
        return dfs(0, 0, m, n, vistied, k);
    }

    private int dfs(int row, int col, int rows, int cols, boolean[][] visited, int threshold) {
        // core 这里只需要向下或者向有搜索就行
        if (row >= rows || col >= cols ||
                visited[row][col] ||
                (getDigitSum(row) + getDigitSum(col)) > threshold) {
            return 0;
        }
        visited[row][col] = true;
        return 1 + dfs(row + 1, col, rows, cols, visited, threshold) + dfs(row, col + 1, rows, cols, visited, threshold);
    }

    private boolean check(int threshold, int rows, int cols, int row, int col, boolean[][] visited) {
        /* core 这里和找路径一样是要判断三个条件
         * 1. 坐标在矩阵中
         * 2. 满足题目条件
         * 3. 没有被访问过
         */
        if (row >= 0 && row < rows && col >= 0 && col < cols
                && (getDigitSum(row) + getDigitSum(col)) <= threshold
                && !visited[row][col]) {
            return true;
        }
        return false;
    }

    private int getDigitSum(int number) {
        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
}
