package leetcode.recursion.bfs;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 你现在手里有一份大小为 N x N 的『地图』（网格） grid，上面的每个『区域』（单元格）都用 0 和 1 标记好了。其中 0 代表海洋，1 代表陆地，你知道距离陆地区域最远的海洋区域是是哪一个吗？请返回该海洋区域到离它最近的陆地区域的距离。
 * <p>
 * 我们这里说的距离是『曼哈顿距离』（ Manhattan Distance）：(x0, y0) 和 (x1, y1) 这两个区域之间的距离是 |x0 - x1| + |y0 - y1| 。
 * <p>
 * 如果我们的地图上只有陆地或者海洋，请返回 -1。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/as-far-from-land-as-possible
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author shiyuan.tian
 * @date 2020/3/29
 */
public class AsFarFromLandAsPossible {
    public static void main(String[] args) {
        int[][] grid = {
                {1, 0, 1},
                {0, 0, 0},
                {1, 0, 1}
        };
        System.out.println(maxDistance(grid));
    }

    public static int maxDistance(int[][] grid) {
        int[] dx = {1, -1, 0, 0};
        int[] dy = {0, 0, 1, -1};
        Queue<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        if (queue.size() == 0 || queue.size() == grid.length * grid[0].length) {
            return -1;
        }
        int distance = 0;
        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = point[0] + dx[i];
                int y = point[1] + dy[i];
                if (x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] > 0) {
                    continue;
                }
                grid[x][y] = grid[point[0]][point[1]] + 1;
                distance = grid[x][y];
                queue.offer(new int[]{x, y});
            }
        }
        return distance - 1;
    }
}
