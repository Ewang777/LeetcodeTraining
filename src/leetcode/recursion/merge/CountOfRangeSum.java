package leetcode.recursion.merge;

/**
 * 给定一个整数数组 nums，返回区间和在 [lower, upper] 之间的个数，包含 lower 和 upper。
 * 区间和 S(i, j) 表示在 nums 中，位置从 i 到 j 的元素之和，包含 i 和 j (i ≤ j)。
 * <p>
 * 说明:
 * 最直观的算法复杂度是 O(n2) ，请在此基础上优化你的算法。
 * <p>
 * 示例:
 * 输入: nums = [-2,5,-1], lower = -2, upper = 2,
 * 输出: 3
 * 解释: 3个区间分别是: [0,0], [2,2], [0,2]，它们表示的和分别为: -2, -1, 2。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/count-of-range-sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author shiyuan.tian
 * @date 2020/4/24
 */
public class CountOfRangeSum {

    public static void main(String[] args) {
        int[] nums = {-2147483647, 0, -2147483647, 2147483647};
        int lower = -564;
        int upper = 3864;
        System.out.println(countRangeSum(nums, lower, upper));
    }
    //        (0,0)(0,1)(0,2)
    // sums[]     -2 3 2
    // lower <= sum[j] - sum[i] <= upper, j > i
    // lower + sum[i] <= sum[j] <= upper + sum[i], j > i

    public static int countRangeSum(int[] nums, int lower, int upper) {
        if (nums.length == 0 || upper < lower) {
            return 0;
        }
        long[] sums = new long[nums.length];
        sums[0] = nums[0];
        int count = lower <= sums[0] && sums[0] <= upper ? 1 : 0;
        for (int i = 1; i < nums.length; i++) {
            sums[i] = sums[i - 1] + nums[i];
            if (lower <= sums[i] && sums[i] <= upper) {
                count++;
            }
        }
        return count + divide(0, sums.length - 1, sums, lower, upper);
    }

    private static int divide(int left, int right, long[] nums, int lower, int upper) {
        if (left >= right) {
            return 0;
        }
        int mid = (left + right) / 2;
        int count = divide(left, mid, nums, lower, upper) + divide(mid + 1, right, nums, lower, upper);

        int lowBound = mid + 1, upperBound = mid + 1;
        for (int i = left; i <= mid; i++) {
            while (lowBound <= right && nums[lowBound] - nums[i] < lower) {
                lowBound++;
            }
            while (upperBound <= right && nums[upperBound] - nums[i] <= upper) {
                upperBound++;
            }
            count += upperBound - lowBound;
        }

        int i = left, j = mid + 1, index = 0;
        long[] temp = new long[right - left + 1];
        while (i <= mid && j <= right) {
            if (nums[i] <= nums[j]) {
                temp[index++] = nums[i++];
            } else {
                temp[index++] = nums[j++];
            }
        }
        while (i <= mid) {
            temp[index++] = nums[i++];
        }
        while (j <= right) {
            temp[index++] = nums[j++];
        }
        System.arraycopy(temp, 0, nums, left, temp.length);
        return count;
    }


}
