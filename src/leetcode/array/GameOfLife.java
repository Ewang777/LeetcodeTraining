package leetcode.array;

import java.util.Arrays;

/**
 * 根据 百度百科 ，生命游戏，简称为生命，是英国数学家约翰·何顿·康威在 1970 年发明的细胞自动机。
 * <p>
 * 给定一个包含 m × n 个格子的面板，每一个格子都可以看成是一个细胞。每个细胞都具有一个初始状态：1 即为活细胞（live），或 0 即为死细胞（dead）。每个细胞与其八个相邻位置（水平，垂直，对角线）的细胞都遵循以下四条生存定律：
 * <p>
 * 如果活细胞周围八个位置的活细胞数少于两个，则该位置活细胞死亡；
 * 如果活细胞周围八个位置有两个或三个活细胞，则该位置活细胞仍然存活；
 * 如果活细胞周围八个位置有超过三个活细胞，则该位置活细胞死亡；
 * 如果死细胞周围正好有三个活细胞，则该位置死细胞复活；
 * 根据当前状态，写一个函数来计算面板上所有细胞的下一个（一次更新后的）状态。下一个状态是通过将上述规则同时应用于当前状态下的每个细胞所形成的，其中细胞的出生和死亡是同时发生的。
 * <p>
 * 示例：
 * <p>
 * 输入：
 * [
 *   [0,1,0],
 *   [0,0,1],
 *   [1,1,1],
 *   [0,0,0]
 * ]
 * 输出：
 * [
 *   [0,0,0],
 *   [1,0,1],
 *   [0,1,1],
 *   [0,1,0]
 * ]
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/game-of-life
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author shiyuan.tian
 * @date 2020/4/2
 */
public class GameOfLife {
    public static void main(String[] args) {
        int[][] board = {
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}
        };
        gameOfLife(board);
        Arrays.asList(board).forEach(arr -> System.out.println(Arrays.toString(arr)));
    }

    private static void inPlace(int[][] board) {
        int[] dx = {1, -1, 0, 0, 1, -1, -1, 1};
        int[] dy = {0, 0, 1, -1, 1, -1, 1, -1};
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int alive = 0;
                for (int d = 0; d < dx.length; d++) {
                    int x = i + dx[d];
                    int y = j + dy[d];
                    if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
                        continue;
                    }
                    alive += board[x][y] & 1;
                }
                if (board[i][j] == 1 && alive >= 2 && alive <= 3) {
                    board[i][j] = 0b11;
                } else if (board[i][j] == 0 && alive == 3) {
                    board[i][j] = 0b10;
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] >>= 1;
            }
        }
    }

    private static void useExtraPlace(int[][] board) {
        int[][] result = new int[board.length][board[0].length];
        int[] dx = {1, -1, 0, 0, 1, -1, -1, 1};
        int[] dy = {0, 0, 1, -1, 1, -1, 1, -1};
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                int alive = 0;
                for (int d = 0; d < dx.length; d++) {
                    int x = i + dx[d];
                    int y = j + dy[d];
                    if (x < 0 || x >= board.length || y < 0 || y >= board[0].length) {
                        continue;
                    }
                    alive += board[x][y];
                }
                if (board[i][j] == 1 && (alive < 2 || alive > 3)) {
                    result[i][j] = 0;
                } else if (board[i][j] == 0 && alive == 3) {
                    result[i][j] = 1;
                } else {
                    result[i][j] = board[i][j];
                }
            }
        }
        for (int i = 0; i < board.length; i++) {
            System.arraycopy(result[i], 0, board[i], 0, board[0].length);
        }
    }


    public static void gameOfLife(int[][] board) {
        inPlace(board);
    }
}
