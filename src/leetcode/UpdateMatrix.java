package leetcode;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;

/**
 * 给定一个由 0 和 1 组成的矩阵，找出每个元素到最近的 0 的距离。
 * 两个相邻元素间的距离为 1 。
 * <p>
 * 示例 1:
 * 输入:
 * <p>
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * 输出:
 * <p>
 * 0 0 0
 * 0 1 0
 * 0 0 0
 * 示例 2:
 * 输入:
 * <p>
 * 0 0 0
 * 0 1 0
 * 1 1 1
 * 输出:
 * <p>
 * 0 0 0
 * 0 1 0
 * 1 2 1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/01-matrix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author shiyuan.tian
 * @date 2020/4/15
 */
public class UpdateMatrix {
    public static void main(String[] args) {
        int[][] matrix = {
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1}
        };
        System.out.println(Arrays.deepToString(updateMatrix(matrix)));

    }

    public static int[][] updateMatrix(int[][] matrix) {
        Queue<int[]> queue = new ArrayDeque<>();
        int[] dx = {0, 0, 1, -1};
        int[] dy = {1, -1, 0, 0};
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    queue.offer(new int[]{i, j});
                } else {
                    matrix[i][j] = -1;
                }
            }
        }

        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            for (int i = 0; i < 4; i++) {
                int x = point[0] + dx[i];
                int y = point[1] + dy[i];
                if (x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length && matrix[x][y] == -1) {
                    matrix[x][y] = 1 + matrix[point[0]][point[1]];
                    queue.offer(new int[]{x, y});
                }
            }
        }
        return matrix;
    }

}
