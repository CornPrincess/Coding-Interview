package ch12StringPathInMatrix;

// Source : https://leetcode-cn.com/problems/ju-zhen-zhong-de-lu-jing-lcof/
// Author : cornprincess
// Date   : 2021-03-02

/***************************************************************************************************** 
 *
 * 请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有字符的路径。路径可以从矩阵中的任意一
 * 格开始，每一步可以在矩阵中向左、右、上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再
 * 次进入该格子。例如，在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字母用加粗标出）。
 *
 * [["a","b","c","e"],
 * ["s","f","c","s"],
 * ["a","d","e","e"]]
 *
 * 但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个字符b占据了矩阵中的第一行第二个格子之后，路径不
 * 能再次进入这个格子。
 *
 * 示例 1：
 *
 * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
 * 输出：true
 *
 * 示例 2：
 *
 * 输入：board = [["a","b"],["c","d"]], word = "abcd"
 * 输出：false
 *
 * 提示：
 *
 * 	1 
 * 	1 
 *
 * 注意：本题与主站 79 题相同：https://leetcode-cn.com/problems/word-search/
 ******************************************************************************************************/

public class StringPathInMatrix {
    // 全局或成员变量,下标表示行,值表示queen存储在哪一列
    int[] eightQueensResult = new int[8];
    int num = 0;

    public void cal8Queens(int row) {
        if (row == 8) {
            printQueens(eightQueensResult);
            return;
        }

        for (int column = 0; column < 8; column++) {
            // 方法满足
            if (isOk(row, column)) {
                // 第row行的棋子放在column列
                eightQueensResult[row] = column;
                // 开始考虑下一行怎么放
                cal8Queens(row + 1);
            }
        }
    }

    private boolean isOk(int row, int column) {
        int leftup = column - 1;
        int rightup = column + 1;

        // core 为什么从 row-1 开始？因为cal8Queens(row + 1); 为了判断该位置上方是否有棋子，所有的格子都要检查一遍
        // core 要判断 row 以上每一行有没有对应棋子，如果有就退出
        for (int i = row - 1; i >= 0; i--) {
            // 判断第 i 行的 column 列是否有棋子
            if (eightQueensResult[i] == column) {
                return false;
            }

            // 判断左对角线：第 i 行 leftup 列是否有棋子
            if (leftup > 0) {
                if (eightQueensResult[i] == leftup) {
                    return false;
                }
            }

            // 判断右对角线：第 i 行 rightup 列是否有棋子
            if (rightup < 8) {
                if (eightQueensResult[i] == rightup) {
                    return false;
                }
            }
            leftup--;
            rightup++;
        }
        // 只有循环结束才能判断这个格子能放
        return true;
    }

    private void printQueens(int[] result) {
        for (int row = 0; row < 8; ++row) {
            for (int column = 0; column < 8; ++column) {
                if (result[row] == column) {
                    System.out.print("Q ");
                } else {
                    System.out.print("* ");
                }
            }
            System.out.println();
        }
        System.out.println();
        num++;
    }

    // 应该是公共变量
    int pathLength = 0;

    public boolean exist(char[][] board, String word) {
        // check param
        if (board == null) {
            return false;
        }

        int rows = board.length;
        if (rows < 1) {
            return false;
        }
        int columns = board[0].length;
        if (columns < 1) {
            return false;
        }

        // core code
        boolean[][] visited = new boolean[rows][columns];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < columns; col++) {
                if (hasPathCore(board, rows, columns, row, col, word, visited)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean hasPathCore(char[][] board, int rows, int columns, int row, int col, String word, boolean[][] visited) {
        // 此刻说明已经找到了路径
        if (word.length() == pathLength) {
            return true;
        }

        // 初始化返回结果
        boolean hasPath = false;
        /* core 判断该点可用的逻辑
         *  1. 该坐标在范围内
         *  2. 该点字符和要找字符串中字符相同
         *  3. 该点未被访问过
         */
        if (row >= 0 && row < rows && col >= 0 && col < columns
                && board[row][col] == word.charAt(pathLength)
                && !visited[row][col]) {
            // core 进入这里说明该点被选入路径，需要更新两个值：pathLength 和 visited
            pathLength++;
            visited[row][col] = true;

            // core 开始判断这个点周围点四个点是否可以被选为路径中的下一个点
            hasPath = hasPathCore(board, rows, columns, row, col - 1, word, visited) ||
                    hasPathCore(board, rows, columns, row - 1, col, word, visited) ||
                    hasPathCore(board, rows, columns, row, col + 1, word, visited) ||
                    hasPathCore(board, rows, columns, row + 1, col, word, visited);
            // core 如果周围的点不能被选为下一个点，说明这个点不能被选入路径
            // core 同样也要更新两个值：pathLength， visited
            if (!hasPath) {
                pathLength--;
                visited[row][col] = false;
            }
        }
        return hasPath;
    }

    public boolean exist2(char[][] board, String word) {
        // check param
        if (board == null || board.length < 1) {
            return false;
        }

        char[] words = word.toCharArray();

        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                // 这里也是从0开始，和8皇后问题很像
                if (dfs(board, row, col, board.length, board[0].length, words, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, int row, int col, int rows, int cols, char[] words, int index) {

        if (row < 0 || row >= rows || col < 0 || col >= cols ||
                board[row][col] != words[index]) {
            return false;
        }

        if (index == words.length - 1) {
            return true;
        }

        // core 走到这一步说明已经找到满足要求的点了
        // core 将board中对于的字符置为 '\0'，这样就可以省去 isVisited 的空间，秒啊
        board[row][col] = '\0';

        boolean res = dfs(board, row + 1, col, rows, cols, words, index + 1) ||
                dfs(board, row, col + 1, rows, cols, words, index + 1) ||
                dfs(board, row - 1, col, rows, cols, words, index + 1) ||
                dfs(board, row, col - 1, rows, cols, words, index + 1);

        // core 走到这一步说明已经产生了回溯，必须将矩阵中的值复原
        board[row][col] = words[index];
        return res;
    }

}
