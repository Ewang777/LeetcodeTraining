package leetcode.recursion.dfs;

/**
 * 给定一个包含了一些 0 和 1的非空二维数组 grid , 一个 岛屿 是由四个方向 (水平或垂直) 的 1 (代表土地) 构成的组合。你可以假设二维矩阵的四个边缘都被水包围着。
 * <p>
 * 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为0。)
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/max-area-of-island
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author shiyuan.tian
 * @date 2020/3/15
 */
public class MaxAreaOfIsland {


    public static void main(String[] args) {
//        int[][] input = new int[][]{
//                {0, 0, 0, 0, 0, 0, 0, 0}
//        };
        int[][] input = new int[][]{
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        };
        System.out.println(maxAreaOfIsland(input));
    }

    private static boolean[][] visited;

    public static int maxAreaOfIsland(int[][] grid) {
        visited = new boolean[grid.length][grid[0].length];
        int currentMaxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    visited[i][j] = true;
                    int area = 1 + dfs(i - 1, j, grid) + dfs(i, j + 1, grid) + dfs(i + 1, j, grid) + dfs(i, j - 1, grid);
                    if (area > currentMaxArea) {
                        currentMaxArea = area;
                    }
                }
            }
        }
        return currentMaxArea;
    }

    private static int dfs(int x, int y, int[][] grid) {
        if (x < 0 || x >= grid.length) {
            return 0;
        }
        if (y < 0 || y >= grid[0].length) {
            return 0;
        }
        if (visited[x][y]) {
            return 0;
        }
        if (grid[x][y] == 1) {
            visited[x][y] = true;
            return 1 + dfs(x - 1, y, grid) + dfs(x, y + 1, grid) + dfs(x + 1, y, grid) + dfs(x, y - 1, grid);
        } else {
            return 0;
        }
    }
}
