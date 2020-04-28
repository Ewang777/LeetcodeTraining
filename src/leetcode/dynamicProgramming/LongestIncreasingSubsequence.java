package leetcode.dynamicProgramming;

/**
 * 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * <p>
 * 示例:
 * <p>
 * 输入: [10,9,2,5,3,7,101,18]
 * 输出: 4
 * 解释: 最长的上升子序列是 [2,3,7,101]，它的长度是 4。
 * 说明:
 * <p>
 * 可能会有多种最长上升子序列的组合，你只需要输出对应的长度即可。
 * 你算法的时间复杂度应该为 O(n2) 。
 * 进阶: 你能将算法的时间复杂度降低到 O(n log n) 吗?
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-increasing-subsequence
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author shiyuan.tian
 * @date 2020/3/14
 */
public class LongestIncreasingSubsequence {
    public static void main(String[] args) {
        int[] nums = new int[]{10, 9, 2, 5, 3, 7, 101, 18};
        System.out.println(lengthOfLIS(nums));
    }

    public static int lengthOfLIS(int[] nums) {
        int[] lengthOfLISArr = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int currentMaxLengthOfLIS = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i]) {
                    currentMaxLengthOfLIS = Math.max(currentMaxLengthOfLIS, lengthOfLISArr[j]);
                }
            }
            lengthOfLISArr[i] = currentMaxLengthOfLIS + 1;
        }

        int maxLengthOfLIS = 0;
        for (int lengthOfLIS : lengthOfLISArr) {
            maxLengthOfLIS = Math.max(maxLengthOfLIS, lengthOfLIS);
        }
        return maxLengthOfLIS;
    }
}
