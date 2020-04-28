package leetcode;

/**
 * @author shiyuan.tian
 * @date 2020/4/20
 */
public class NumberOfIslands {

    public static void main(String[] args) {
//        char[][] grid = {
//                {'1', '1', '1', '1', '0'},
//                {'1', '1', '0', '1', '0'},
//                {'1', '1', '0', '0', '0'},
//                {'0', '0', '0', '0', '0'}
//        };
        char[][] grid = {
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        System.out.println(numIslands(grid));
    }

    public static int numIslands(char[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] != 't') {
                    if (grid[i][j] == '1') {
                        result++;
                    }
                    visit(i, j, grid);
                }
            }
        }
        return result;
    }

    private static void visit(int i, int j, char[][] grid) {
        if (grid[i][j] != '1') {
            return;
        }
        grid[i][j] = 't';

        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};

        for (int d = 0; d < 4; d++) {
            int x = i + dx[d];
            int y = j + dy[d];
            if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length) {
                visit(x, y, grid);
            }
        }

    }
}
