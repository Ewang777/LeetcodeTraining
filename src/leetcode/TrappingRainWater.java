package leetcode;

import java.util.Stack;

/**
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * 示例:
 * <p>
 * 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/trapping-rain-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author shiyuan.tian
 * @date 2020/4/4
 */
public class TrappingRainWater {
    public static void main(String[] args) {
        int[] height = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
//        int[] height = {2, 1, 0, 2};
        System.out.println(trap(height));
    }

    public static int trap(int[] height) {
        if (height.length < 3) {
            return 0;
        }
        int total = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[stack.peek()] < height[i]) {
                int current = stack.pop();
                while (!stack.isEmpty() && height[current] == height[stack.peek()]) {
                    stack.pop();
                }
                if (!stack.isEmpty()) {
                    total += (Math.min(height[stack.peek()], height[i]) - height[current]) * (i - stack.peek() - 1);
                }
            }
            stack.push(i);
        }
        return total;
    }

    private static int violent(int[] height) {
        if (height.length < 3) {
            return 0;
        }
        int total = 0;
        for (int k = 0; k < height.length; k++) {
            int maxLeft = -1;
            for (int i = k; i >= 0; i--) {
                maxLeft = Math.max(height[i], maxLeft);
            }
            int maxRight = -1;
            for (int j = k; j < height.length; j++) {
                maxRight = Math.max(height[j], maxRight);
            }
            total += Math.min(maxLeft, maxRight) - height[k];
        }
        return total;
    }

}
