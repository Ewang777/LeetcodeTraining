package leetcode.geometry;

/**
 * 在 N * N 的网格上，我们放置一些 1 * 1 * 1  的立方体。
 * 每个值 v = grid[i][j] 表示 v 个正方体叠放在对应单元格 (i, j) 上。
 * 请你返回最终形体的表面积。
 * <p>
 * 示例 1：
 * <p>
 * 输入：[[2]]
 * 输出：10
 * 示例 2：
 * <p>
 * 输入：[[1,2],[3,4]]
 * 输出：34
 * 示例 3：
 * <p>
 * 输入：[[1,0],[0,2]]
 * 输出：16
 * 示例 4：
 * <p>
 * 输入：[[1,1,1],[1,0,1],[1,1,1]]
 * 输出：32
 * 示例 5：
 * <p>
 * 输入：[[2,2,2],[2,1,2],[2,2,2]]
 * 输出：46
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/surface-area-of-3d-shapes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author shiyuan.tian
 * @date 2020/3/25
 */
public class SurfaceAreaOf3DShapes {
    public static void main(String[] args) {
        int[][] grid = new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        System.out.println(surfaceArea(grid));
    }

    public static int surfaceArea(int[][] grid) {
        return travelComputeAndMinusCommonSideSimplify(grid);
    }

    private static int travelComputeAndMinusCommonSideSimplify(int[][] grid) {
        int total = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                int currentArea = 2 + grid[i][j] * 4;
                if (i - 1 >= 0 && grid[i - 1][j] != 0) {
                    int commonSide = Math.min(grid[i][j], grid[i - 1][j]) * 2;
                    currentArea -= commonSide;
                }
                if (j - 1 >= 0 && grid[i][j - 1] != 0) {
                    int commonSide = Math.min(grid[i][j], grid[i][j - 1]) * 2;
                    currentArea -= commonSide;
                }
                total += currentArea;
            }
        }
        return total;
    }

    private static int travelComputeAndMinusCommonSide(int[][] grid) {
        int total = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 0) {
                    continue;
                }
                int currentArea = 2 + grid[i][j] * 4;
                if (i - 1 >= 0 && grid[i - 1][j] != 0) {
                    int commonSide = Math.min(grid[i][j], grid[i - 1][j]);
                    currentArea -= commonSide;
                }
                if (j + 1 < grid[i].length && grid[i][j + 1] != 0) {
                    int commonSide = Math.min(grid[i][j], grid[i][j + 1]);
                    currentArea -= commonSide;
                }
                if (i + 1 < grid.length && grid[i + 1][j] != 0) {
                    int commonSide = Math.min(grid[i][j], grid[i + 1][j]);
                    currentArea -= commonSide;
                }
                if (j - 1 >= 0 && grid[i][j - 1] != 0) {
                    int commonSide = Math.min(grid[i][j], grid[i][j - 1]);
                    currentArea -= commonSide;
                }
                total += currentArea;
            }
        }
        return total;
    }
}
