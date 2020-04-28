package leetcode.recursion.merge;

/**
 * 给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。
 * 你需要返回给定数组中的重要翻转对的数量。
 * <p>
 * 示例 1:
 * 输入: [1,3,2,3,1]
 * 输出: 2
 * <p>
 * 示例 2:
 * 输入: [2,4,3,5,1]
 * 输出: 3
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/reverse-pairs
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author shiyuan.tian
 * @date 2020/4/24
 */
public class ImportantReversePairs {
    public static void main(String[] args) {
        int[] nums = {1, 3, 2, 3, 1};
        System.out.println(reversePairs(nums));
    }


    public static int reversePairs(int[] nums) {
        return divide(0, nums.length - 1, nums);
    }

    private static int divide(int left, int right, int[] nums) {
        if (left >= right) {
            return 0;
        }
        int count = 0;
        int mid = left + (right - left) / 2;
        count += divide(left, mid, nums);
        count += divide(mid + 1, right, nums);

        int j = mid + 1;
        for (int i = left; i <= mid; i++) {
            while (j <= right && nums[i] > 2L * nums[j]) {
                j++;
            }
            count += j - (mid + 1);
        }
        merge(left, mid, right, nums);
        return count;
    }

    private static void merge(int left, int mid, int right, int[] nums) {
        int index = 0;
        int i = left;
        int j = mid + 1;
        int[] temp = new int[right - left + 1];
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

    }
}
