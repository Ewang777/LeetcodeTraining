package leetcode.hash;

/**
 * 给你一个整数数组 nums 和一个整数 k。
 * 如果某个 连续 子数组中恰好有 k 个奇数数字，我们就认为这个子数组是「优美子数组」。
 * 请返回这个数组中「优美子数组」的数目。
 * <p>
 * 示例 1：
 * 输入：nums = [1,1,2,1,1], k = 3
 * 输出：2
 * 解释：包含 3 个奇数的子数组是 [1,1,2,1] 和 [1,2,1,1] 。
 * <p>
 * 示例 2：
 * 输入：nums = [2,4,6], k = 1
 * 输出：0
 * 解释：数列中不包含任何奇数，所以不存在优美子数组。
 * <p>
 * 示例 3：
 * 输入：nums = [2,2,2,1,2,2,1,2,2,2], k = 2
 * 输出：16
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-number-of-nice-subarrays
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author shiyuan.tian
 * @date 2020/4/21
 */
public class CountNumberOfNiceSubArrays {
    public static void main(String[] args) {
        int[] nums = {2,4,6};
        int k = 1;
        System.out.println(numberOfSubarrays(nums, k));
    }

    public static int numberOfSubarrays(int[] nums, int k) {
        if (k == 0 || nums.length == 0) {
            return 0;
        }
        int[] oddIndex = new int[nums.length];
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 1) {
                oddIndex[index++] = i;
            }
        }
        int count = 0;
        for (int i = k - 1; i < index; i++) {
            int preLeftIndex = i >= k ? oddIndex[i - k] : -1;
            int postRightIndex = i < index - 1 ? oddIndex[i + 1] : nums.length;
            count += ((oddIndex[i - k + 1] - preLeftIndex) * (postRightIndex - oddIndex[i]));
        }
        return count;
    }
}
