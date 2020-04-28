package leetcode.array;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个位置。
 * <p>
 * 示例 1:
 * <p>
 * 输入: [2,3,1,1,4]
 * 输出: true
 * 解释: 我们可以先跳 1 步，从位置 0 到达 位置 1, 然后再从位置 1 跳 3 步到达最后一个位置。
 * 示例 2:
 * <p>
 * 输入: [3,2,1,0,4]
 * 输出: false
 * 解释: 无论怎样，你总会到达索引为 3 的位置。但该位置的最大跳跃长度是 0 ， 所以你永远不可能到达最后一个位置。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/jump-game
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author shiyuan.tian
 * @date 2020/4/17
 */
public class JumpGame {
    public static void main(String[] args) {
        int[] nums = {1, 1, 1, 0};
        System.out.println(canJump(nums));
    }

    public static boolean canJump(int[] nums) {
        if (nums.length == 1) {
            return true;
        }
        int n = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] >= n) {
                n = 1;
            } else {
                n++;
            }
        }
        return n == 1;
    }

    private static boolean bfs(int[] nums) {
        if (nums.length == 0) {
            return false;
        }
        boolean[] visited = new boolean[nums.length];
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(0);
        visited[0] = true;
        while (!queue.isEmpty()) {
            int index = queue.poll();
            for (int i = 0; i <= nums[index]; i++) {
                int nextIndex = index + i;
                if (nextIndex < nums.length && !visited[nextIndex]) {
                    queue.offer(nextIndex);
                    visited[nextIndex] = true;
                    if (nextIndex == nums.length - 1) {
                        break;
                    }
                }
            }
        }
        return visited[nums.length - 1];
    }
}
